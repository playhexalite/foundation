package org.hexalite.foundation.core.entity

import kotlinx.coroutines.flow.Flow
import org.hexalite.foundation.core.exception.EntityRetrievingFailedException
import org.hexalite.foundation.core.identity.Identity
import org.hexalite.foundation.core.server.PlatformServer
import org.hexalite.mechanism.core.functional.Either

/**
 * A scope for managing entities attached to a specific server.
 * @param S The source; a generic kind of entity this scope abstraction consumes.
 * @param P The kind of players this scope abstraction consumes.
 * @author FromSyntax
 */
public interface EntityScope<S: PlatformEntity, P: PlatformPlayer> {
    /**
     * Retrieve a single entity active on this [PlatformServer]. Behind the scenes, this checks
     * the kind of the given [identity] to see what kind of entity it will return.
     * - [Identity.Uuid] - it will try to find an online or offline player, depending on the given parameters.
     * - [Identity.Text] - it will find an online or offline player named like that, depending on the given parameters.
     * - [Identity.Number] - it will find an entity with a number-assigned id
     * @param identity The identity to be filtered on.
     * @param allowInactive Whether this will search by offline players as well.
     */
    public suspend fun find(identity: Identity, allowInactive: Boolean = false):
            Either<S, EntityRetrievingFailedException>

    /**
     * Returns a cold of all [entities][PlatformEntity] attached to this server.
     * @see Flow
     */
    public fun asFlow(): Flow<S>

    /**
     * A cold flow of [PlatformPlayer]s attached to this [PlatformServer].
     * @see Flow
     */
    public val players: Flow<P>
}