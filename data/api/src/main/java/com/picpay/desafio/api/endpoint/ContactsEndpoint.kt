package com.picpay.desafio.api.endpoint

import com.picpay.desafio.api.model.Contact
import retrofit2.Response
import retrofit2.http.GET

/**
 * Endpoint used for contact related operations in the api.
 */
internal interface ContactsEndpoint {

    /**
     * Returns the available contacts.
     *
     * @return a [Response] with a [List] of [Contact]s
     */
    @GET("users")
    suspend fun getContacts(): Response<List<Contact>>
}
