package com.picpay.desafio.cache.mapper

import com.picpay.desafio.cache.model.Contact as CacheContact
import com.picpay.desafio.repository.model.Contact as RepositoryContact

/**
 * Mapper used to map a contact.
 */
internal class ContactMapper {

    /**
     * Maps a [RepositoryContact] to a [CacheContact].
     *
     * @param repositoryContact the contact to be mapped
     *
     * @return the mapped contact
     */
    fun toCache(repositoryContact: RepositoryContact): CacheContact =
        CacheContact(
            image = repositoryContact.image,
            name = repositoryContact.name,
            id = repositoryContact.id,
            username = repositoryContact.username
        )

    /**
     * Maps a [CacheContact] to a [RepositoryContact].
     *
     * @param cacheContact the contact to be mapped
     *
     * @return the mapped repository contact
     */
    fun toRepository(cacheContact: CacheContact): RepositoryContact =
        RepositoryContact(
            image = cacheContact.image,
            name = cacheContact.name,
            id = cacheContact.id,
            username = cacheContact.username
        )
}
