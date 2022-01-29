package com.picpay.desafio.repository.repository

import com.picpay.desafio.domain.model.Contact
import com.picpay.desafio.domain.model.GetContactsListFromCacheResult
import com.picpay.desafio.domain.model.GetContactsListState
import com.picpay.desafio.domain.repository.ContactsRepository
import com.picpay.desafio.repository.mapper.ContactMapper
import com.picpay.desafio.repository.mapper.GetContactsListFromCacheResultMapper
import com.picpay.desafio.repository.mapper.GetContactsResultMapper

/**
 * Implementation of [ContactsRepository].
 *
 * @param internalContactsRepository internal repository used for contact operations
 * @param getContactsResultMapper mapper used to map a result of the operation
 * @param contactMapper mapper used to map a contact
 * @param getContactsListFromCacheResultMapper mapper used to map a result of the operation
 */
internal class ContactsRepositoryImpl(
    private val internalContactsRepository: InternalContactsRepository,
    private val getContactsResultMapper: GetContactsResultMapper,
    private val contactMapper: ContactMapper,
    private val getContactsListFromCacheResultMapper: GetContactsListFromCacheResultMapper
) : ContactsRepository {

    override suspend fun getContactsList(): GetContactsListState =
        getContactsResultMapper.toDomain(internalContactsRepository.getContactsList())

    override suspend fun cacheContacts(contactsList: List<Contact>) =
        internalContactsRepository.cacheContacts(contactsList.map { contact ->
            contactMapper.toRepository(contact)
        })

    override suspend fun getCachedContactsList(): GetContactsListFromCacheResult =
        getContactsListFromCacheResultMapper.toDomain(
            internalContactsRepository.getCachedContacts()
        )
}
