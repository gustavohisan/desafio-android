package com.picpay.desafio.cache.provider

import com.picpay.desafio.cache.dao.ContactDao

/**
 * Provider used to provide the available Daos from the database.
 *
 * @param databaseProvider provider used to provide the database instance
 */
internal class DaoProvider(private val databaseProvider: DatabaseProvider) {

    /**
     * Returns the instance for the Contact Dao.
     *
     * @return a instance of [ContactDao]
     */
    fun getContactDao(): ContactDao = databaseProvider.database.contactDao()
}
