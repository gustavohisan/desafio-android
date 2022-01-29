package com.picpay.desafio.domain.fake

import com.picpay.desafio.domain.model.Contact
import com.picpay.desafio.domain.model.GetContactsListFromCacheResult
import com.picpay.desafio.domain.model.GetContactsListState
import com.picpay.desafio.domain.repository.ContactsRepository

/**
 * Fake used for test with the contact repository
 */
class ContactsRepositoryFake : ContactsRepository {

    private var contactsList: List<Contact> = listOf(ContactFake.CONTACT)

    private var cachedContactsList: List<Contact> = listOf(ContactFake.CONTACT)

    private var state: GetContactsListState = GetContactsListState.Loaded(contactsList)

    private var cacheResult: GetContactsListFromCacheResult =
        GetContactsListFromCacheResult.Success(contactsList)

    fun setContactListToEmpty() {
        contactsList = listOf()
    }

    fun setCachedContactListToEmpty() {
        cachedContactsList = listOf()
    }

    fun setContactListToValid() {
        contactsList = listOf(
            ContactFake.CONTACT,
            ContactFake.CONTACT.copy(id = 2),
            ContactFake.CONTACT.copy(id = 3)
        )
    }

    fun setCachedContactListToValid() {
        cachedContactsList = listOf(
            ContactFake.CONTACT,
            ContactFake.CONTACT.copy(id = 2),
            ContactFake.CONTACT.copy(id = 3)
        )
    }

    fun setContactListToIncomplete() {
        contactsList = listOf(
            ContactFake.CONTACT,
            ContactFake.CONTACT.copy(id = 2, image = ""),
            ContactFake.CONTACT.copy(id = 3),
            ContactFake.CONTACT.copy(id = 4, name = ""),
            ContactFake.CONTACT.copy(id = 5, username = ""),
            ContactFake.CONTACT.copy(id = 6)
            )
    }

    fun setContactListToFullIncomplete() {
        contactsList = listOf(
            ContactFake.CONTACT.copy(id = 2, image = ""),
            ContactFake.CONTACT.copy(id = 4, name = ""),
            ContactFake.CONTACT.copy(id = 5, username = ""),
        )
    }

    fun setStateAsLoaded() {
        state = GetContactsListState.Loaded(contactsList)
    }

    fun setStateAsError() {
        state = GetContactsListState.Failed("error message")
    }

    fun setResultAsSuccess() {
        cacheResult = GetContactsListFromCacheResult.Success(cachedContactsList)
    }

    fun setResultAsError() {
        cacheResult = GetContactsListFromCacheResult.Error("error message")
    }

    override suspend fun getContactsList(): GetContactsListState = state

    override suspend fun cacheContacts(contactsList: List<Contact>) {
        // Not implemented
    }

    override suspend fun getCachedContactsList(): GetContactsListFromCacheResult = cacheResult
}
