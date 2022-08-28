package org.hexalite.foundation.core.exception

/**
 * An exception used to indicate when an add-on entrypoint execution lifecycle fails to execute.
 * @author FromSyntax
 */
public data class AddonEntrypointFailedException(
    override val message: String? = null,
    override val cause: Throwable? = null
): RuntimeException(message, cause)
