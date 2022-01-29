package com.picpay.desafio.domain.usecase

import com.picpay.desafio.domain.model.Contact

/**
 * Use-case to cache a list of contacts into the database.
 */
interface CacheContactsList {

    /**
     * Caches a [List] of [Contact]s into the database.
     *
     * @param contactsList the list of contacts to be cached
     */
    suspend operator fun invoke(contactsList: List<Contact>)
}
