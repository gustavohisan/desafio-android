package com.picpay.desafio.api.model

/**
 * Result of the get contacts operation.
 */
internal sealed class GetContactsResult {

    /**
     * Represents when the operation was successful.
     *
     * @param contactsList the list of contacts retrieved
     */
    data class Success(val contactsList: List<Contact>) : GetContactsResult()

    /**
     * Represents when the operation failed.
     *
     * @param error the error message
     */
    data class Error(val error: String) : GetContactsResult()
}
