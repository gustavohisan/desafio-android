package com.picpay.desafio.repository.datasource

import com.picpay.desafio.repository.model.GetContactsResult

/**
 * Data source used to contacts related operations with the api.
 */
interface ContactsApiDataSource {

    /**
     * Returns the contacts list available in the api.
     *
     * @return the result of the operation
     */
    suspend fun getContactsList(): GetContactsResult
}
