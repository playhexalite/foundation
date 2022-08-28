package org.hexalite.foundation.core.identity

import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import org.hexalite.foundation.core.exception.AudienceCreationFailedException
import org.hexalite.foundation.core.exception.ComponentSendingFailedException
import org.hexalite.mechanism.core.functional.Either

/**
 * An entity capable to receive social interactions in Minecraft: text, action bar; any text-related components.
 * @author FromSyntax
 */
public interface Audible {
    /**
     * The identity bound to this [Audible] component or entity.
     */
    public val identity: Identity

    /**
     * Send an [Component] to this [Audible] resource.
     * @param component The component to be sent.
     */
    public suspend fun send(component: Component): Either<Unit, ComponentSendingFailedException>

    /**
     * Convert this [Audible] resource to an Adventure's [Audience].
     */
    public fun adventure(): Either<Audience, AudienceCreationFailedException>
}