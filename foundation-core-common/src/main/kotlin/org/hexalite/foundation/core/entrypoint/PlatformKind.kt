package org.hexalite.foundation.core.entrypoint

import java.lang.Runtime.Version

/**
 * Information about specific supported platforms, and maybe a scope to access platform-specific features.
 * The preferred way to implement this is treating it like a global scope, so marking it as object instead
 * may be a better choice.
 * @param identifier A basic identifier for this platform.
 * @author FromSyntax
 */
@Suppress("MemberVisibilityCanBePrivate")
public abstract class PlatformKind(public val identifier: String) {
    /**
     * Returns whether this platform is being executed at this exact moment.
     */
    public abstract fun isActive(): Boolean

    /**
     * The semantic versioning type for this platform.
     */
    public abstract val version: Version
}