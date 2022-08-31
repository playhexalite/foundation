@file:JvmName("ServerExt")
package org.hexalite.foundation.core.extension

import kotlinx.coroutines.flow.Flow
import org.hexalite.foundation.core.entity.EntityScope
import org.hexalite.foundation.core.entity.PlatformEntity
import org.hexalite.foundation.core.entity.PlatformPlayer
import org.hexalite.foundation.core.event.PlatformEvent
import org.hexalite.foundation.core.event.ProprietaryEventScope
import org.hexalite.foundation.core.geography.GeographyScope
import org.hexalite.foundation.core.geography.PlatformGeography
import org.hexalite.foundation.core.server.PlatformServer

public typealias GenericPlatformServer = PlatformServer<
        ProprietaryEventScope<PlatformEvent<Any>>,
        GeographyScope<PlatformGeography>,
        EntityScope<PlatformEntity, PlatformPlayer>
        >

/**
 * A cold flow of [PlatformPlayer]s attached to this [PlatformServer].
 * @see Flow
 */
@Suppress("NOTHING_TO_INLINE")
public inline fun <P: PlatformPlayer> PlatformServer<*, *, EntityScope<*, P>>.players(): Flow<P> = entities.players
