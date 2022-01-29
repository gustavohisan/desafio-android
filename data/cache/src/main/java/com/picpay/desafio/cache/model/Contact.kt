package com.picpay.desafio.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class representing a contact and its data.
 *
 * @param image the picture of the contact
 * @param name the name of the contact
 * @param id the id of the contact
 * @param username the username of the contact
 */
@Entity(tableName = "contacts")
internal data class Contact(
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "name")
    val name: String,
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "username")
    val username: String
)
