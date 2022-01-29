package com.picpay.desafio.domain.model

/**
 * State representing the possible states of the get contacts list operation.
 */
sealed class GetContactsListState {

    /**
     * Represents when the contacts list was successfully retrieved.
     *
     * @param contactsList the retrieved [List] of [Contact]s
     */
    data class Loaded(val contactsList: List<Contact>) : GetContactsListState()

    /**
     * Represents when the contacts list was retrieved from cache.
     *
     * @param contactsList the retrieved [List] of [Contact]s
     */
    data class LoadedFromCache(val contactsList: List<Contact>): GetContactsListState()

    /**
     * Represents when the operation failed to retrieve the contacts list.
     *
     * @param error the error type
     */
    data class Failed(val error: String) : GetContactsListState()

    /**
     * Represents when the contacts list was empty.
     */
    object Empty : GetContactsListState()
}
