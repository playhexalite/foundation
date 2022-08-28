package org.hexalite.foundation.core.exception

import org.hexalite.foundation.core.identity.Identity

/**
 * An exception indicating that an entity retrieving operation has failed.
 * @author FromSyntax
 */
public open class EntityRetrievingFailedException(override val message: String) : RuntimeException(message) {
    public data class NotActive(val id: Identity) :
        ComponentSendingFailedException("The entity identified as '$id' is not active.")
}
