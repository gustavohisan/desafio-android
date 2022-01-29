package com.picpay.desafio.api.mapper

import com.picpay.desafio.api.model.Contact as ApiContact
import com.picpay.desafio.repository.model.Contact as RepositoryContact

/**
 * Mapper used to map a contact.
 */
internal class ContactMapper {

    /**
     * Maps a [ApiContact] to a [RepositoryContact].
     *
     * @param apiContact the contact to be mapped
     *
     * @return the mapped repository contact
     */
    fun toRepository(apiContact: ApiContact): RepositoryContact =
        RepositoryContact(
            image = apiContact.image ?: "",
            name = apiContact.name ?: "",
            id = apiContact.id,
            username = apiContact.username ?: ""
        )
}
