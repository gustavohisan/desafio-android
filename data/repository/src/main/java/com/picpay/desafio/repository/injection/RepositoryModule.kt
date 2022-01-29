package com.picpay.desafio.repository.injection

import com.picpay.desafio.domain.repository.ContactsRepository
import com.picpay.desafio.repository.mapper.ContactMapper
import com.picpay.desafio.repository.mapper.GetContactsListFromCacheResultMapper
import com.picpay.desafio.repository.mapper.GetContactsResultMapper
import com.picpay.desafio.repository.repository.ContactsRepositoryImpl
import com.picpay.desafio.repository.repository.InternalContactsRepository
import org.koin.dsl.module

/**
 * Koin module representing the repository module.
 */
val repositoryModule = module {

    // Repository
    factory<ContactsRepository> { ContactsRepositoryImpl(get(), get(), get(), get()) }
    factory { InternalContactsRepository(get(), get()) }

    // Mapper
    factory { ContactMapper() }
    factory { GetContactsResultMapper(get()) }
    factory { GetContactsListFromCacheResultMapper(get()) }
}
