package org.hexalite.foundation.core.server

import org.hexalite.foundation.core.entity.EntityScope
import org.hexalite.foundation.core.event.ProprietaryEventScope
import org.hexalite.foundation.core.geography.GeographyScope

/**
 * An abstraction layer over a generic Minecraft server implementation.
 * @param E The generic type of events this platform runs against.
 * @param G The kind of geography this platform runs against.
 * @param T The generic type of entities this platform runs against.
 * @author FromSyntax
 */
public interface PlatformServer<E : ProprietaryEventScope<*>, G : GeographyScope<*>, T : EntityScope<*, *>> {
    /**
     * The scope for managing proprietary events within this specific platform.
     */
    public val events: E

    /**
     * The scope for managing geographies within this specific platform.
     */
    public val geographies: G

    /**
     * The scope for managing entities within this specific platform, no matter what geography that entity
     * belongs to.
     */
    public val entities: T
}

