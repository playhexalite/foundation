package org.hexalite.foundation.core.event

import org.hexalite.foundation.core.entrypoint.WithEntrypoint

/**
 * A simple type that surrounds a platform-specific event.
 * @param S Where this event come from originally
 * @author FromSyntax
 */
public interface PlatformEvent<S> : WithEntrypoint {
    /**
     * Returns where this event come from originally; the source for this platform-agnostic event.
     */
    public val source: S

    /**
     * A cancellable version of [PlatformEvent].
     * @author FromSyntax
     */
    public interface Cancellable<S>: PlatformEvent<S> {
        /**
         * Returns whether this event is cancelled.
         */
        public var isCancelled: Boolean
    }
}
