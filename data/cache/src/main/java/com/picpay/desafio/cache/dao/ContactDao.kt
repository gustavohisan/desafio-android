package com.picpay.desafio.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.cache.model.Contact

/**
 * Dao used for Contact operations in the database.
 */
@Dao
internal interface ContactDao {

    /**
     * Returns every contact available in the database.
     *
     * @return a [List] with every [Contact] cached
     */
    @Query("SELECT * FROM contacts")
    suspend fun getContactsList(): List<Contact>

    /**
     * Inserts a list of contacts into the database.
     *
     * @param contactsList the [List] of [Contact] to be cached
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContacts(contactsList: List<Contact>)

    /**
     * Clears the contacts from the database.
     */
    @Query("DELETE FROM contacts")
    suspend fun clearContacts()
}
