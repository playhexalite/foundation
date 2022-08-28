package org.hexalite.foundation.core.entrypoint

/**
 * A type surrounding an add-on entrypoint. This is required in all kind of extended or brand-new
 * features introduced on Foundation.
 * @property entrypoint The surrounding add-on entrypoint.
 * @author FromSyntax
 */
public interface WithEntrypoint {
    /**
     * The wrapped add-on entrypoint instance this abstraction is attached to.
     */
    public val entrypoint: PlatformEntrypoint<*>
}
