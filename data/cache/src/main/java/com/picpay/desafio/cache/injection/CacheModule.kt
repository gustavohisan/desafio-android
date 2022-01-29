package com.picpay.desafio.cache.injection

import com.picpay.desafio.cache.datasource.ContactsCacheDataSourceImpl
import com.picpay.desafio.cache.datasource.InternalContactsCacheDataSource
import com.picpay.desafio.cache.mapper.ContactMapper
import com.picpay.desafio.cache.mapper.GetContactsListFromCacheResultMapper
import com.picpay.desafio.cache.provider.DaoProvider
import com.picpay.desafio.cache.provider.DatabaseProvider
import com.picpay.desafio.repository.datasource.ContactsCacheDataSource
import org.koin.dsl.module

/**
 * Koin module representing the cache module.
 */
val cacheModule = module {

    // Provider
    factory { DaoProvider(get()) }
    single { DatabaseProvider(get()) }

    // Factory
    factory { ContactMapper() }
    factory { GetContactsListFromCacheResultMapper(get()) }

    // Datasource
    factory<ContactsCacheDataSource> { ContactsCacheDataSourceImpl(get(), get(), get()) }
    factory { InternalContactsCacheDataSource(get()) }
}
