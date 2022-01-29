package com.picpay.desafio.domain

import com.picpay.desafio.domain.fake.ContactFake
import com.picpay.desafio.domain.fake.ContactsRepositoryFake
import com.picpay.desafio.domain.filter.ContactFilter
import com.picpay.desafio.domain.model.GetContactsListState
import com.picpay.desafio.domain.usecase.GetContactsListImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.BeforeEach

/**
 * Test used to test the implementation of the [GetContactsListImpl].
 */
class GetContactsListTest {

    private val contactsRepository = ContactsRepositoryFake()

    private val contactFilter = ContactFilter()

    private val getContactsList = GetContactsListImpl(contactsRepository, contactFilter)

    @BeforeEach
    fun setup() {
        contactsRepository.setContactListToValid()
        contactsRepository.setStateAsLoaded()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN valid contacts WHEN contacts are requested THEN the loaded state is returned`() {
        // Given
        contactsRepository.setContactListToValid()
        contactsRepository.setStateAsLoaded()

        // When
        var state: GetContactsListState? = null
        TestCoroutineScope().launch {
            state = getContactsList()
        }

        // Then
        assertTrue(state is GetContactsListState.Loaded)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN incomplete contacts WHEN contacts are requested THEN the incomplete contacts are filtered`() {
        // Given
        contactsRepository.setContactListToIncomplete()
        contactsRepository.setStateAsLoaded()

        // When
        var state: GetContactsListState? = null
        TestCoroutineScope().launch {
            state = getContactsList()
        }

        // Then
        assertTrue(state is GetContactsListState.Loaded)
        val contactsList = (state as GetContactsListState.Loaded).contactsList
        val expectedList = listOf(
            ContactFake.CONTACT,
            ContactFake.CONTACT.copy(id = 3),
            ContactFake.CONTACT.copy(id = 6)
        )
        assertEquals(expectedList, contactsList)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN empty list of contacts WHEN contacts are requested THEN cached contacts are returned`() {
        // Given
        contactsRepository.setContactListToEmpty()
        contactsRepository.setStateAsLoaded()
        contactsRepository.setCachedContactListToValid()
        contactsRepository.setResultAsSuccess()

        // When
        var state: GetContactsListState? = null
        TestCoroutineScope().launch {
            state = getContactsList()
        }

        // Then
        assertTrue(state is GetContactsListState.LoadedFromCache)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN empty list of contacts and no cache WHEN contacts are requested THEN empty state is returned`() {
        // Given
        contactsRepository.setContactListToEmpty()
        contactsRepository.setStateAsLoaded()
        contactsRepository.setCachedContactListToEmpty()
        contactsRepository.setResultAsSuccess()

        // When
        var state: GetContactsListState? = null
        TestCoroutineScope().launch {
            state = getContactsList()
        }

        // Then
        assertTrue(state is GetContactsListState.Empty)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN error in contacts request WHEN contacts are requested THEN cached contacts is returned`() {
        // Given
        contactsRepository.setStateAsError()
        contactsRepository.setCachedContactListToValid()
        contactsRepository.setResultAsSuccess()

        // When
        var state: GetContactsListState? = null
        TestCoroutineScope().launch {
            state = getContactsList()
        }

        // Then
        assertTrue(state is GetContactsListState.LoadedFromCache)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN error in contacts request and cache request WHEN contacts are requested THEN failed state is returned`() {
        // Given
        contactsRepository.setStateAsError()
        contactsRepository.setResultAsError()

        // When
        var state: GetContactsListState? = null
        TestCoroutineScope().launch {
            state = getContactsList()
        }

        // Then
        assertTrue(state is GetContactsListState.Failed)
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `GIVEN full incomplete list of contacts WHEN contacts are requested THEN cached contacts is returned`() {
        // Given
        contactsRepository.setContactListToFullIncomplete()
        contactsRepository.setStateAsLoaded()
        contactsRepository.setCachedContactListToValid()
        contactsRepository.setResultAsSuccess()

        // When
        var state: GetContactsListState? = null
        TestCoroutineScope().launch {
            state = getContactsList()
        }

        // Then
        assertTrue(state is GetContactsListState.LoadedFromCache)
    }
}
