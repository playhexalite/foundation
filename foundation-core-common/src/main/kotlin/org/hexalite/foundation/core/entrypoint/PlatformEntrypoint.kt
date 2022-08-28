package org.hexalite.foundation.core.entrypoint

import kotlinx.coroutines.flow.Flow
import mu.KLogger
import org.hexalite.foundation.core.event.PlatformEvent
import org.hexalite.foundation.core.exception.AddonEntrypointFailedException
import org.hexalite.foundation.core.server.PlatformServer
import org.hexalite.mechanism.core.functional.Either
import java.io.File
import java.lang.Runtime.Version

/**
 * The entrypoint for an add-on or plug-in of a server software platform. The goal of this type is to
 * give access to various features addressed by Foundation in any supported platform through the power
 * of this abstraction layer.
 * @param E The generic type of events this platform will run against.
 * @author FromSyntax
 */
public interface PlatformEntrypoint<E>: WithEntrypoint {
    /**
     * The wrapped add-on entrypoint instance this abstraction is attached to.
     */
    override val entrypoint: PlatformEntrypoint<E>
        get() = this

    /**
     * The server this add-on is running on.
     */
    public val server: PlatformServer<E>

    /**
     * All kind of platforms this add-on can be run against.
     */
    public val platforms: Set<PlatformKind>

    /**
     * The namespace used to interact with Minecraft's data pack-like features, such as biomes, items,
     * blocks, etc. In other words, it is used in anything that need a namespace.
     */
    public val namespace: String

    /**
     * The events emitted from the platform this add-on belongs to. Events here are be consumed from
     * both global shared flow and local publisher.
     * A local publisher means that it belongs to this add-on only and will not be sent to any other
     * add-ons.
     * A global shared flow means that it consumes and publishes proprietary events
     * * Global publisher: a channel that can be consumed
     */
    public val events: Flow<PlatformEvent<E>>

    /**
     * The file representing the add-on data directory.
     */
    public val dataDirectory: File

    /**
     * The version of this add-on.
     */
    public val version: Version

    /**
     * The logger related to this add-on namespace.
     */
    public val logger: KLogger

    /**
     * Returns whether this add-on is active/enabled.
     */
    public val isActive: Boolean

    /**
     * Publish an event into the shared [events] flow.
     * @param globally Whether this event will be published globally instead of locally.
     * @see Flow
     */
    public suspend fun publish(event: PlatformEvent<E>, globally: Boolean = false): Result<Unit>

    /**
     * Executed when this add-on reaches enabling state. This is a synchronous operation; it will prevent
     * other add-ons to be loaded until this ends, which is a design choice targeting security improvements.
     */
    public suspend fun up(): Either<Unit, AddonEntrypointFailedException>

    /**
     * Executed when this add-on reaches disabling state. This is a synchronous operation; it will prevent
     * other add-ons to be disabled until this ends, which is a design choice targeting security improvements.
     */
    public suspend fun down()
}

