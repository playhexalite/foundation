@file:JvmName("EntrypointExt")
package org.hexalite.foundation.core.extension

import org.hexalite.foundation.core.entity.EntityScope
import org.hexalite.foundation.core.entity.PlatformEntity
import org.hexalite.foundation.core.entity.PlatformPlayer
import org.hexalite.foundation.core.entrypoint.PlatformEntrypoint
import org.hexalite.foundation.core.event.PlatformEvent
import org.hexalite.foundation.core.event.ProprietaryEventScope
import org.hexalite.foundation.core.geography.GeographyScope
import org.hexalite.foundation.core.geography.PlatformGeography

public typealias GenericPlatformEntrypoint = PlatformEntrypoint<
        ProprietaryEventScope<PlatformEvent<Any>>,
        GeographyScope<PlatformGeography>,
        EntityScope<PlatformEntity, PlatformPlayer>
        >
