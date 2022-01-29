package com.picpay.desafio.contacts.model

/**
 * State representing the possible states of the get contacts list operation.
 */
internal sealed class GetContactsListState {

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

    /**
     * Represents when the contacts list is being loaded.
     */
    object Loading : GetContactsListState()

    /**
     * Represents when there is no current state.
     */
    object None : GetContactsListState()
}
