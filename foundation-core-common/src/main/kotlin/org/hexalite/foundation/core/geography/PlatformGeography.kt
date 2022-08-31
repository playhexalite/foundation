package org.hexalite.foundation.core.geography

import kotlinx.coroutines.flow.Flow
import org.hexalite.foundation.core.entity.PlatformEntity
import org.hexalite.foundation.core.entity.PlatformPlayer

/**
 * An agnostic representation of a world or server.
 * @author FromSyntax
 */
public interface PlatformGeography {
    /**
     * Whether this geography is under a proxy. For example, the geography for a Velocity proxy. Simple worlds
     * won't return true.
     */
    public val isProxied: Boolean

    /**
     * A cold flow of [PlatformPlayer]s attached to this specific [PlatformGeography].
     */
    public val players: Flow<PlatformPlayer>

    /**
     * A cold flow of [entities][PlatformEntity] attached to this specific [PlatformGeography]. It may return simply
     * an empty flow if geography is under a proxy.
     */
    public val entities: Flow<PlatformEntity>
}