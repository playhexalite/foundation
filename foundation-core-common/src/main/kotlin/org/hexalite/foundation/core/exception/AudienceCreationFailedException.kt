package org.hexalite.foundation.core.exception

import org.hexalite.foundation.core.identity.Audible

/**
 * An exception used to indicate that an entity failed to be converted to an Adventure's audience or anything else
 * happened during the conversion.
 * @author FromSyntax
 */
public open class AudienceCreationFailedException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : RuntimeException(message, cause) {
    public data class NotActive(val audible: Audible) :
        ComponentSendingFailedException("The resource identified as '${audible.identity}' is not active.")
}

