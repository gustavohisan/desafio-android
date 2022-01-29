package com.picpay.desafio.cache.datasource

import com.picpay.desafio.cache.model.Contact
import com.picpay.desafio.cache.model.GetContactsListFromCacheResult
import com.picpay.desafio.cache.provider.DaoProvider

/**
 * Internal data source used for contact related operations.
 *
 * @param daoProvider provider used to provide the dao instance
 */
internal class InternalContactsCacheDataSource(
    private val daoProvider: DaoProvider
) {

    /**
     * Caches a list of contacts into the database.
     *
     * @param contactsList the list of contacts to be mapped
     */
    suspend fun cacheContacts(contactsList: List<Contact>) {
        daoProvider.getContactDao().clearContacts()
        daoProvider.getContactDao().insertContacts(contactsList)
    }

    /**
     * Returns the list of contacts cached in the database.
     *
     * @return the result of the operation
     */
    suspend fun getCachedContacts(): GetContactsListFromCacheResult {
        return try {
            GetContactsListFromCacheResult.Success(daoProvider.getContactDao().getContactsList())
        } catch (exception: Exception) {
            GetContactsListFromCacheResult.Error(exception.message.orEmpty())
        }
    }
}
