package org.hexalite.foundation.core.exception

import org.hexalite.foundation.core.identity.Audible

/**
 * An exception used to indicate a component failed to be sent to an [Audible] resource.
 * @author FromSyntax
 */
public open class ComponentSendingFailedException(override val message: String) : RuntimeException(message) {
    public data class NotActive(val audible: Audible) :
        ComponentSendingFailedException("The resource identified as '${audible.identity}' is not active.")
}
