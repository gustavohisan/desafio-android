package com.picpay.desafio.domain.usecase

import com.picpay.desafio.domain.model.Contact
import com.picpay.desafio.domain.repository.ContactsRepository

/**
 * Implementation of [CacheContactsList].
 *
 * @param contactsRepository repository used for contact related operations
 */
internal class CacheContactsListImpl(
    private val contactsRepository: ContactsRepository
) : CacheContactsList {

    override suspend operator fun invoke(contactsList: List<Contact>) {
        contactsRepository.cacheContacts(contactsList)
    }
}
