package com.picpay.desafio.api.datasource

import com.picpay.desafio.api.mapper.GetContactsResultMapper
import com.picpay.desafio.repository.datasource.ContactsApiDataSource
import com.picpay.desafio.repository.model.GetContactsResult

/**
 * Implementation of [ContactsApiDataSource].
 *
 * @param internalContactsApiDataSource internal data source used for contacts operation
 * @param getContactsResultMapper mapper used to map the result of the operation
 */
internal class ContactsApiDataSourceImpl(
    private val internalContactsApiDataSource: InternalContactsApiDataSource,
    private val getContactsResultMapper: GetContactsResultMapper
) : ContactsApiDataSource {

    override suspend fun getContactsList(): GetContactsResult =
        getContactsResultMapper.toRepository(internalContactsApiDataSource.getContactsList())
}
