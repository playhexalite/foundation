package org.hexalite.foundation.core.entity

import org.hexalite.foundation.core.identity.Audible
import org.hexalite.foundation.core.identity.CommandAssignee

/**
 * A simple agnostic representation of a player attached to a geography.
 * @author FromSyntax
 */
public interface PlatformPlayer: PlatformEntity, Audible, CommandAssignee {
    /**
     * Whether this [PlatformPlayer] is on-line/active.
     */
    public val isOnline: Boolean
}
