package com.picpay.desafio.domain.usecase

import com.picpay.desafio.domain.filter.ContactFilter
import com.picpay.desafio.domain.model.Contact
import com.picpay.desafio.domain.model.GetContactsListFromCacheResult
import com.picpay.desafio.domain.model.GetContactsListState
import com.picpay.desafio.domain.repository.ContactsRepository

/**
 * Implementation of [GetContactsList].
 *
 * @param contactsRepository repository used for contact related operations
 * @param contactFilter filter used to filter incomplete contacts
 */
internal class GetContactsListImpl(
    private val contactsRepository: ContactsRepository,
    private val contactFilter: ContactFilter
) : GetContactsList {

    override suspend operator fun invoke(): GetContactsListState {
        val state = contactsRepository.getContactsList()
        return if (state is GetContactsListState.Loaded) {
            checkIfContactsListIsEmpty(state.contactsList)
        } else {
            getContactsFromCache()
        }
    }

    private suspend fun checkIfContactsListIsEmpty(
        contactsList: List<Contact>
    ): GetContactsListState {
        val filteredList = contactFilter.filterIncompleteContact(contactsList)
        return if (filteredList.isEmpty()) {
            getContactsFromCache()
        } else {
            GetContactsListState.Loaded(filteredList)
        }
    }

    private suspend fun getContactsFromCache(): GetContactsListState {
        return when (val result = contactsRepository.getCachedContactsList()) {
            is GetContactsListFromCacheResult.Success ->
                checkIfCachedContactsListIsEmpty(result.contactsList)
            is GetContactsListFromCacheResult.Error -> GetContactsListState.Failed(result.error)
        }
    }

    private suspend fun checkIfCachedContactsListIsEmpty(
        contactsList: List<Contact>
    ): GetContactsListState =
        if (contactsList.isEmpty()) {
            GetContactsListState.Empty
        } else {
            GetContactsListState.LoadedFromCache(contactsList)
        }
}
