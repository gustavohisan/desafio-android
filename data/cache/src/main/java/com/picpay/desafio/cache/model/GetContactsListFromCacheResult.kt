package com.picpay.desafio.cache.model

/**
 * Sealed class representing the result of the get contacts from cache operation.
 */
internal sealed class GetContactsListFromCacheResult {

    /**
     * Represents when the contacts were successfully retrieved from cache.
     *
     * @param contactsList the [List] of [Contact]s retrieved
     */
    data class Success(val contactsList: List<Contact>) : GetContactsListFromCacheResult()

    /**
     * Represents when there was an error retrieving the contacts.
     *
     * @param error the error type
     */
    data class Error(val error: String) : GetContactsListFromCacheResult()
}
