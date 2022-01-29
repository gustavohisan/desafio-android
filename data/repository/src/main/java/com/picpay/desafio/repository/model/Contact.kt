package com.picpay.desafio.repository.model

/**
 * Data class representing a contact and its data.
 *
 * @param image the picture of the contact
 * @param name the name of the contact
 * @param id the id of the contact
 * @param username the username of the contact
 */
data class Contact(
    val image: String,
    val name: String,
    val id: Int,
    val username: String
)
