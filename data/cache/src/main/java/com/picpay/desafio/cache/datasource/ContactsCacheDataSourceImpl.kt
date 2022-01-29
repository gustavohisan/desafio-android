package com.picpay.desafio.cache.datasource

import com.picpay.desafio.cache.mapper.ContactMapper
import com.picpay.desafio.cache.mapper.GetContactsListFromCacheResultMapper
import com.picpay.desafio.repository.datasource.ContactsCacheDataSource
import com.picpay.desafio.repository.model.Contact
import com.picpay.desafio.repository.model.GetContactsListFromCacheResult

/**
 * Implementation of [ContactsCacheDataSource].
 *
 * @param internalContactsCacheDataSource internal data source used for contacts related operations
 * @param contactMapper mapper used to map a contact
 * @param getContactsListFromCacheResultMapper mapper used to map the result of the operation
 */
internal class ContactsCacheDataSourceImpl(
    private val internalContactsCacheDataSource: InternalContactsCacheDataSource,
    private val contactMapper: ContactMapper,
    private val getContactsListFromCacheResultMapper: GetContactsListFromCacheResultMapper
) : ContactsCacheDataSource {

    override suspend fun cacheContacts(contactsList: List<Contact>) {
        internalContactsCacheDataSource.cacheContacts(contactsList.map { contact ->
            contactMapper.toCache(
                contact
            )
        })
    }

    override suspend fun getCachedContacts(): GetContactsListFromCacheResult =
        getContactsListFromCacheResultMapper.toRepository(internalContactsCacheDataSource.getCachedContacts())
}
