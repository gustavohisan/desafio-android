package com.picpay.desafio.api.injection

import com.picpay.desafio.api.datasource.ContactsApiDataSourceImpl
import com.picpay.desafio.api.datasource.InternalContactsApiDataSource
import com.picpay.desafio.api.factory.ApiFactory
import com.picpay.desafio.api.interceptor.NetworkInterceptor
import com.picpay.desafio.api.mapper.ContactMapper
import com.picpay.desafio.api.mapper.GetContactsResultMapper
import com.picpay.desafio.repository.datasource.ContactsApiDataSource
import org.koin.dsl.module

/**
 * Koin module representing the api module.
 */
val apiModule = module {

    // Data source
    factory<ContactsApiDataSource> { ContactsApiDataSourceImpl(get(), get()) }
    factory { InternalContactsApiDataSource(get()) }

    // Factory
    single { ApiFactory(get()) }

    // Interceptor
    factory { NetworkInterceptor() }

    // Mapper
    factory { ContactMapper() }
    factory { GetContactsResultMapper(get()) }
}
