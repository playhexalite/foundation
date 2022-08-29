package org.hexalite.foundation.core.exception

import org.hexalite.foundation.core.identity.Identity

/**
 * An exception indicating that a geography creation operation has failed.
 * @author FromSyntax
 */
public open class GeographyOperationFailedException(override val message: String) : RuntimeException(message) {
    /**
     * An exception indicating that the running platform does not expose its geography creation API, or it is
     * not implemented yet.
     * @author FromSyntax
     */
    public object Unsupported :
        GeographyOperationFailedException("This platform doesn't expose its geography creation API.")

    /**
     * An exception indicating that a geography retrieving operation has failed.
     * @author FromSyntax
     */
    public data class Nonexistent(val id: Identity) :
        ComponentSendingFailedException("The geography identified as '$id' is not active or does not exist.")
}
