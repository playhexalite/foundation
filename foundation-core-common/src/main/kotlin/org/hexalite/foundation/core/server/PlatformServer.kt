package org.hexalite.foundation.core.server

import kotlinx.coroutines.flow.MutableSharedFlow
import org.hexalite.foundation.core.entity.PlatformEntity
import org.hexalite.foundation.core.event.PlatformEvent
import org.hexalite.foundation.core.exception.EntityRetrievingFailedException
import org.hexalite.foundation.core.identity.Identity
import org.hexalite.mechanism.core.functional.Either
import kotlin.reflect.KClass

/**
 * An abstraction layer over a generic Minecraft server implementation.
 * @param E The generic type of events this platform will run against.
 * @author FromSyntax
 */
public interface PlatformServer<E> {
    /**
     * Retrieve a single entity active on this [PlatformServer]. Behind the scenes, this checks
     * the kind of the given [identity] to see what kind of entity it will return.
     * - [Identity.Uuid] - it will try to find an online or offline player, depending on the given parameters.
     * - [Identity.Text] - it will find an online or offline player named like that, depending on the given parameters.
     * - [Identity.Number] - it will find an entity with a number-assigned id
     * @param identity The identity to be filtered on.
     * @param allowInactive Whether this will search by offline players as well.
     */
    public suspend fun findEntity(identity: Identity, allowInactive: Boolean = false):
            Either<PlatformEntity, EntityRetrievingFailedException>

    /**
     * The global shared flow for proprietary event publishing and consumption. It works by searching for events that
     * were opt in to be listened to. To make an event type be listened here, you need to let the platform know it by
     * using [enableSearchingFor].
     */
    public val events: MutableSharedFlow<PlatformEvent<E>>

    /**
     * Let the global shared flow search for a specific kind of proprietary event.
     * @param T The kind of event to be searched for.
     * @param kind The [KClass] for the event kind.
     */
    public fun <T : Any> enableSearchingFor(kind: KClass<T>)

    /**
     * Retrieve an geography.
     */
}