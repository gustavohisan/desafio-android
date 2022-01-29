package com.picpay.desafio.domain.repository

import com.picpay.desafio.domain.model.Contact
import com.picpay.desafio.domain.model.GetContactsListFromCacheResult
import com.picpay.desafio.domain.model.GetContactsListState

/**
 * Repository used to handle contact related operations.
 */
interface ContactsRepository {

    /**
     * Returns the list of contacts available.
     *
     * @return a [GetContactsListState] with the state of the operation
     */
    suspend fun getContactsList(): GetContactsListState

    /**
     * Caches a list of contacts.
     *
     * @param contactsList the [List] of [Contact]s to be cached
     */
    suspend fun cacheContacts(contactsList: List<Contact>)

    /**
     * Returns the list of contacts available in cache.
     *
     * @return a [GetContactsListFromCacheResult] with the result of the operation
     */
    suspend fun getCachedContactsList(): GetContactsListFromCacheResult
}
