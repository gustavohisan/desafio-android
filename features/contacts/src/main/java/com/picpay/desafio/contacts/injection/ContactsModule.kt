package com.picpay.desafio.contacts.injection

import com.picpay.desafio.contacts.mapper.ContactMapper
import com.picpay.desafio.contacts.mapper.GetContactsListStateMapper
import com.picpay.desafio.contacts.presentation.ContactsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Koin module representing the contacts presentation module.
 */
val contactsModule = module {

    // ViewModel
    viewModel { ContactsViewModel(get(), get(), get(), get()) }

    // Mappers
    factory { ContactMapper() }
    factory { GetContactsListStateMapper(get()) }
}
