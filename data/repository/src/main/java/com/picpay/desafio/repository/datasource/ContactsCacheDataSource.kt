package com.picpay.desafio.repository.datasource

import com.picpay.desafio.repository.model.Contact
import com.picpay.desafio.repository.model.GetContactsListFromCacheResult

/**
 * Data source used to contacts cache related operations.
 */
interface ContactsCacheDataSource {

    /**
     * Caches a list of contacts into the database.
     *
     * @param contactsList the list contacts to be cached
     */
    suspend fun cacheContacts(contactsList: List<Contact>)

    /**
     * Returns the list of contacts cached.
     *
     * @return the result of operation
     */
    suspend fun getCachedContacts(): GetContactsListFromCacheResult
}
