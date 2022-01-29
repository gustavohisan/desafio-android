package com.picpay.desafio.api.datasource

import com.picpay.desafio.api.endpoint.ContactsEndpoint
import com.picpay.desafio.api.factory.ApiFactory
import com.picpay.desafio.api.model.GetContactsResult

/**
 * Internal data source used for contact related operations.
 *
 * @param apiFactory factory used to provide the retrofit instance
 */
internal class InternalContactsApiDataSource(apiFactory: ApiFactory) {

    private val endpoint = apiFactory.getRetrofitInstance().create(ContactsEndpoint::class.java)

    /**
     * Returns the contacts list from the api.
     *
     * @return the result of the operation
     */
    suspend fun getContactsList(): GetContactsResult {
        val callback = endpoint.getContacts()
        return when (callback.code()) {
            SUCCESS_CODE -> GetContactsResult.Success(callback.body().orEmpty())
            NO_NETWORK_CODE -> GetContactsResult.Error("Sem conexão com a rede")
            else -> GetContactsResult.Error("Falha no servidor")
        }
    }

    private companion object {
        const val NO_NETWORK_CODE = 403
        const val SUCCESS_CODE = 200
    }
}
