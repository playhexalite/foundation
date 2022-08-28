package org.hexalite.foundation.core.identity

import net.kyori.adventure.text.Component
import org.hexalite.foundation.core.exception.ComponentSendingFailedException
import org.hexalite.mechanism.core.functional.Either

/**
 * An entity capable of executing chat commands. Common implementations are console and players.
 * @author FromSyntax
 */
public interface CommandAssignee {
    /**
     * Forces this assignee to send a chat message.
     * @param component The component to be sent.
     */
    public suspend fun chat(component: Component): Either<Unit, ComponentSendingFailedException>
}