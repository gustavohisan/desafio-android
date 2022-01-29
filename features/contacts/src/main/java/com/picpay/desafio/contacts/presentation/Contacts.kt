package com.picpay.desafio.contacts.presentation

import android.util.Log
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.picpay.desafio.contacts.R
import com.picpay.desafio.contacts.model.Contact
import com.picpay.desafio.contacts.model.GetContactsListState
import org.koin.androidx.compose.getViewModel
import timber.log.Timber

/**
 * Composable function used to compose the main contacts screen.
 */
@Composable
fun Contacts() {
    ContactsLoader()
}

@Composable
private fun ContactsLoader(viewModel: ContactsViewModel = getViewModel()) {
    val getContactsListState by viewModel.getContactsListState.observeAsState()
    if (getContactsListState is GetContactsListState.None) {
        viewModel.loadContactsList()
    }
    getContactsListState?.let { state ->
        ContactsScaffold(state = state, viewModel = viewModel)
    }
}

@Composable
private fun ContactsScaffold(state: GetContactsListState, viewModel: ContactsViewModel) {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                modifier = Modifier.padding(top = 48.dp, start = 24.dp),
                text = stringResource(id = R.string.contacts_screen_title),
                style = MaterialTheme.typography.h1
            )
            Crossfade(modifier = Modifier.padding(top = 24.dp), targetState = state) { state ->
                when (state) {
                    is GetContactsListState.Loaded -> {
                        viewModel.cacheContactsList(state.contactsList)
                        ContactsList(state.contactsList)
                    }
                    is GetContactsListState.Empty -> EmptyMessage()
                    is GetContactsListState.Failed -> {
                        Timber.e("Error requesting contacts list = ${state.error}")
                        ErrorMessage()
                    }
                    is GetContactsListState.LoadedFromCache -> {
                        Timber.d("Loaded contacts from cache")
                        ContactsList(state.contactsList)
                    }
                    is GetContactsListState.Loading -> LoadingIndicator()
                    is GetContactsListState.None -> Timber.d("No state available")
                }
            }
        }
    }
}

@Composable
private fun EmptyMessage() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.contacts_screen_empty_message)
    )
}

@Composable
private fun ErrorMessage() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.contacts_screen_error_message)
    )
}

@Composable
private fun ContactsList(contacts: List<Contact>) {
    LazyColumn {
        items(contacts) { contact ->
            Contact(contactData = contact)
        }
    }
}

@Composable
private fun LoadingIndicator() {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}
