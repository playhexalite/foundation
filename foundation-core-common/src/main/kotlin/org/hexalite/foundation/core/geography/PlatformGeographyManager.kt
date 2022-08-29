package org.hexalite.foundation.core.geography

import org.hexalite.foundation.core.exception.GeographyOperationFailedException
import org.hexalite.foundation.core.identity.Identity
import org.hexalite.mechanism.core.functional.Either

/**
 * @author FromSyntax
 */
public interface PlatformGeographyManager<G : PlatformGeography> {
    /**
     * Retrieve a platform-specific geography (also called as servers or worlds, depends on if it is a proxy or not).
     * @param identity The identity of the desired geography.
     */
    public suspend fun retrieve(identity: Identity.Text): Either<G, GeographyOperationFailedException>

    /**
     * Creates a new geography from the given information. It is usually only supported by world-like implementations.
     * @param data The payload containing the creation instructions.
     */
    public suspend fun create(data: PlatformGeographyCreationData): Either<G, GeographyOperationFailedException>

    /**
     * Deletes an existing geography. It is usually only supported by world-like implementations.
     * @param identity The identity of the desired geography.
     */
    public suspend fun delete(identity: Identity.Text): Either<Unit, GeographyOperationFailedException>
}