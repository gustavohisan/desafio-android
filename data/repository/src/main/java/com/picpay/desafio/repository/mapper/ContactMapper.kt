package com.picpay.desafio.repository.mapper

import com.picpay.desafio.domain.model.Contact as DomainContact
import com.picpay.desafio.repository.model.Contact as RepositoryContact

/**
 * Mapper used to map a contact.
 */
internal class ContactMapper {

    /**
     * Maps a [RepositoryContact] to a [DomainContact].
     *
     * @param repositoryContact the contact to be mapped
     *
     * @return the mapped contact
     */
    fun toDomain(repositoryContact: RepositoryContact): DomainContact =
        DomainContact(
            image = repositoryContact.image,
            name = repositoryContact.name,
            id = repositoryContact.id,
            username = repositoryContact.username
        )

    /**
     * Maps a [DomainContact] to a [RepositoryContact].
     *
     * @param domainContact the contact to be mapped
     *
     * @return the mapped repository contact
     */
    fun toRepository(domainContact: DomainContact): RepositoryContact =
        RepositoryContact(
            image = domainContact.image,
            name = domainContact.name,
            id = domainContact.id,
            username = domainContact.username
        )
}
