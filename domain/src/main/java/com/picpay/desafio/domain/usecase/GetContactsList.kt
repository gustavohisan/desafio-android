package com.picpay.desafio.domain.usecase

import com.picpay.desafio.domain.model.GetContactsListState

/**
 * Use-case used to retrieve the list of contacts from the api, and in case of an error tries to
 * retrieve any cached contacts.
 */
interface GetContactsList {

    /**
     * Retrieves the list of contacts available in the api, and in case an error happens tries to
     * retrieve the users from cache.
     *
     * @return the [GetContactsListState] with the state of the operation
     */
    suspend operator fun invoke(): GetContactsListState
}
