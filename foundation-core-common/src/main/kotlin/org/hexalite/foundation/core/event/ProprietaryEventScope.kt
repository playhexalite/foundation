package org.hexalite.foundation.core.event

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlin.reflect.KClass

/**
 * A scope for managing proprietary events from a specific platform server. A proprietary event is an event that is
 * specific to a platform, and only can be managed within it. For example, some events from the Bukkit or Sponge
 * platform couldn't be listened from proxy-like platforms like Velocity or BungeeCord through its public API.
 * @author FromSyntax
 */
public interface ProprietaryEventScope<E: PlatformEvent<*>> {
    /**
     * The global shared flow for proprietary event publishing and consumption. It works by searching for events that
     * were opt in to be listened to. To make an event type be listened here, you need to let the platform know it by
     * using [global].
     */
    public fun asFlow(): SharedFlow<E>

    /**
     * Opt-in for a proprietary event [kind] to be searched.
     * @param T The kind of event to be searched.
     * @param kind The Kotlin class type for [T].
     */
    public fun <T: E> global(kind: KClass<T>)

    /**
     * Publish an event into the proprietary shared event flow.
     * @see Flow
     */
    public suspend fun publish(event: E): Result<Unit>

    /**
     * Disable all global listening/searching interfaces for a specific event [kind].
     * @param T The kind of event to be opt-out from searching.
     * @param kind The Kotlin class type for [T].
     */
    public fun <T: E> optOut(kind: KClass<T>)
}