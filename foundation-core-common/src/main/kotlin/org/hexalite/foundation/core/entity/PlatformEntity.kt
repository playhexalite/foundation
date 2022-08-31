package org.hexalite.foundation.core.entity

import org.hexalite.foundation.core.identity.Identity
import org.hexalite.foundation.core.math.Position

/**
 * A representative wrapper for a platform-specific entity.
 * @author FromSyntax
 */
public interface PlatformEntity {
    /**
     * An identity for this [entity][PlatformEntity].
     */
    public val id: Identity

    /**
     * The health for this possibly living entity. Returns -1 when it is not a living entity, and zero
     * when it is dead.
     */
    public val health: Double

    /**
     * The name identity for this [PlatformEntity]. For simple entities, it will be their display name, and for
     * [PlatformPlayer]s it will be its username.
     */
    public val nameIdentity: Identity.Text?

    /**
     * Returns the position of this [PlatformEntity] in a geography.
     */
    public val position: Position
}

/**
 * Returns whether an [PlatformEntity] is alive.
 */
public val PlatformEntity.isAlive: Boolean
    inline get() = health > 0.0
