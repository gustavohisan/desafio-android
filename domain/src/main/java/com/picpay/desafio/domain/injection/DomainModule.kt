package com.picpay.desafio.domain.injection

import com.picpay.desafio.domain.filter.ContactFilter
import com.picpay.desafio.domain.usecase.CacheContactsList
import com.picpay.desafio.domain.usecase.CacheContactsListImpl
import com.picpay.desafio.domain.usecase.GetContactsList
import com.picpay.desafio.domain.usecase.GetContactsListImpl
import org.koin.dsl.module

/**
 * Koin module representing the domain module.
 */
val domainModule = module {

    // Use-case
    factory<GetContactsList> { GetContactsListImpl(get(), get()) }
    factory<CacheContactsList> { CacheContactsListImpl(get()) }

    // Filter
    factory { ContactFilter() }
}
