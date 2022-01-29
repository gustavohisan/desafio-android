package com.picpay.desafio.repository.repository

import com.picpay.desafio.repository.datasource.ContactsApiDataSource
import com.picpay.desafio.repository.datasource.ContactsCacheDataSource
import com.picpay.desafio.repository.model.Contact
import com.picpay.desafio.repository.model.GetContactsListFromCacheResult
import com.picpay.desafio.repository.model.GetContactsResult

/**
 * Internal repository used for contact related operations.
 *
 * @param contactsApiDataSource data source used for api related operations
 * @param contactsCacheDataSource data source used for cache related operations
 */
internal class InternalContactsRepository(
    private val contactsApiDataSource: ContactsApiDataSource,
    private val contactsCacheDataSource: ContactsCacheDataSource
) {

    /**
     * Returns the list of contacts available in the api.
     *
     * @return the result of the operation
     */
    suspend fun getContactsList(): GetContactsResult = contactsApiDataSource.getContactsList()

    /**
     * Caches a list of contacts into the database.
     *
     * @param contactsList the list of contacts to be mapped
     */
    suspend fun cacheContacts(contactsList: List<Contact>) =
        contactsCacheDataSource.cacheContacts(contactsList)

    /**
     * Returns the list of contacts cached in the database.
     *
     * @return the result of the operation
     */
    suspend fun getCachedContacts(): GetContactsListFromCacheResult =
        contactsCacheDataSource.getCachedContacts()
}
