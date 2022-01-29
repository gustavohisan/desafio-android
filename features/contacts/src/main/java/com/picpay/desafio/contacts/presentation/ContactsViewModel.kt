package com.picpay.desafio.contacts.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.contacts.mapper.ContactMapper
import com.picpay.desafio.contacts.mapper.GetContactsListStateMapper
import com.picpay.desafio.contacts.model.Contact
import com.picpay.desafio.contacts.model.GetContactsListState
import com.picpay.desafio.domain.usecase.CacheContactsList
import com.picpay.desafio.domain.usecase.GetContactsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View model used for the contacts screen.
 *
 * @param getContactsList use-case used to retrieve the contact list
 * @param getContactsListStateMapper mapper used to map the state of the operation
 * @param cacheContactsList use-case used to cache a list of contacts
 * @param contactMapper mapper used to map a contact
 */
internal class ContactsViewModel(
    private val getContactsList: GetContactsList,
    private val getContactsListStateMapper: GetContactsListStateMapper,
    private val cacheContactsList: CacheContactsList,
    private val contactMapper: ContactMapper
) : ViewModel() {

    private val _getContactsListState: MutableLiveData<GetContactsListState> =
        MutableLiveData(GetContactsListState.None)
    val getContactsListState: LiveData<GetContactsListState>
        get() = _getContactsListState

    fun loadContactsList() {
        _getContactsListState.value = GetContactsListState.Loading
        viewModelScope.launch(Dispatchers.IO) {
            _getContactsListState.postValue(
                getContactsListStateMapper.toPresentation(
                    getContactsList()
                )
            )
        }
    }

    fun cacheContactsList(contactList: List<Contact>) {
        viewModelScope.launch(Dispatchers.IO) {
            cacheContactsList(contactMapper.toDomain(contactList))
        }
    }
}
