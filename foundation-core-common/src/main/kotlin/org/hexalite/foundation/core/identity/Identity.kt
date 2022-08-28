package org.hexalite.foundation.core.identity

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.nullable
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.hexalite.mechanism.core.functional.Either
import org.hexalite.mechanism.core.functional.Either.Companion.either
import org.hexalite.mechanism.core.serialization.parseUuidOrNull
import net.kyori.adventure.identity.Identity as AdventureIdentity

/**
 * An identity is a type used to search for entities; to distinguish them from another entities. This is, of
 * course, also valid for players, so it is another reason that multiple times of identity exists. This is also
 * used in resources, such as namespace-based identifiers (e.g. items, blocks, entity types, biomes), world
 * names, etc.
 * @author FromSyntax
 */
@Suppress("OVERRIDE_BY_INLINE", "INAPPLICABLE_JVM_NAME")
@Serializable(with = Identity.Serializer::class)
public sealed interface Identity {
    override fun toString(): String

    /**
     * Returns a representation of this [Identity] as an [Adventure's identity][AdventureIdentity] bound to
     * the left side ([Either.Left]), or a fail to the right side ([Either.Right]), if not possible.
     */
    public fun adventure(): Either<AdventureIdentity, IdentityConversionFailedException>

    /**
     * Returns whether this [Identity] is empty.
     */
    public val isEmpty: Boolean

    /**
     * An [Uuid]-represented [Identity]. This is often assigned to entities due to their uniqueness and low
     * probability of duplicating itself at runtime.
     * @author FromSyntax
     */
    @JvmInline
    public value class Uuid(private val delegate: AdventureIdentity) : Identity, AdventureIdentity by delegate {
        public constructor(uuid: com.benasher44.uuid.Uuid): this(AdventureIdentity.identity(uuid))

        override val isEmpty: Boolean
            inline get() = false

        override fun adventure(): Either<AdventureIdentity, IdentityConversionFailedException> = Either.left(this)

        override fun toString(): String = uuid().toString()
    }

    /**
     * An empty [Identity].
     * @author FromSyntax
     */
    @Serializable
    public object Nil : Identity, AdventureIdentity by AdventureIdentity.nil() {
        override val isEmpty: Boolean
            inline get() = true

        override fun toString(): String = "Identity.Nil"

        override fun adventure(): Either<AdventureIdentity, IdentityConversionFailedException> = Either.left(this)
    }

    /**
     * A Minecraft namespace-like [Identity]. Usually used in data pack-like features, such as custom biomes, items,
     * blocks, tags, etc.
     * @author FromSyntax
     */
    @Serializable
    public data class Namespaced(public val namespace: String, public val key: String) : Identity,
        CharSequence by "${namespace.let({ if (it.isNotBlank()) "$it:" else "" })}$key" {

        override val isEmpty: Boolean
            @JvmName("empty") inline get() = namespace.isBlank() && key.isBlank()

        override fun adventure(): Either<AdventureIdentity, IdentityConversionFailedException> =
            Either.right(IdentityConversionFailedException)

        override fun toString(): String = buildString {
            if (namespace.isNotBlank()) {
                append("$namespace:")
            }
            append(key)
        }
    }

    /**
     * A simple stringified [Identity].
     * @author FromSyntax
     */
    @JvmInline
    @Serializable
    public value class Text(public val text: String) : Identity, CharSequence by text {
        override fun adventure(): Either<AdventureIdentity, IdentityConversionFailedException> =
            text.parseUuidOrNull()?.let(AdventureIdentity::identity).either { IdentityConversionFailedException }

        override val isEmpty: Boolean
            @JvmName("empty") inline get() = text.isBlank()

        override fun toString(): String = text

        @Suppress("NOTHING_TO_INLINE")
        public inline fun number(): Number? {
            return Number(text.toUIntOrNull() ?: return null)
        }
    }

    /**
     * A simple number-based [Identity], usually assigned to living entities.
     * @author FromSyntax
     */
    @JvmInline
    @Serializable
    public value class Number(public val unsigned: UInt): Identity {
        override val isEmpty: Boolean
            @JvmName("empty") inline get() = false

        override fun adventure(): Either<AdventureIdentity, IdentityConversionFailedException> =
            Either.right(IdentityConversionFailedException)

        override fun toString(): String = unsigned.toString()
    }

    /**.
     * kotlinx.serialization adapter; [KSerializer].
     * @author FromSyntax
     */
    public companion object Serializer : KSerializer<Identity> {
        override val descriptor: SerialDescriptor =
            PrimitiveSerialDescriptor("org.hexalite.foundation.core.identity.Identity", PrimitiveKind.STRING)
                .nullable

        @OptIn(ExperimentalSerializationApi::class)
        override fun deserialize(decoder: Decoder): Identity {
            if (!decoder.decodeNotNullMark()) {
                return Nil
            }
            val value = decoder.decodeString()
            val uuid = value.parseUuidOrNull()
            if (uuid != null) {
                return Uuid(uuid)
            }
            return Number(value.toUIntOrNull() ?: return Text(value))
        }

        @OptIn(ExperimentalSerializationApi::class)
        override fun serialize(encoder: Encoder, value: Identity) {
            if (value is Nil) {
                encoder.encodeNull()
            } else {
                encoder.encodeNotNullMark()
                encoder.encodeString(value.toString())
            }
        }
    }
}