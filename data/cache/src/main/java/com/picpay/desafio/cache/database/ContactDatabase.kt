package com.picpay.desafio.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.cache.dao.ContactDao
import com.picpay.desafio.cache.model.Contact

/**
 * Database used to cache the contacts data into the device.
 */
@Database(entities = [Contact::class], version = 1, exportSchema = false)
internal abstract class ContactDatabase : RoomDatabase() {

    /**
     * Contact Dao, used for contact related operations.
     *
     * @return the instance of [ContactDao]
     */
    abstract fun contactDao(): ContactDao
}
