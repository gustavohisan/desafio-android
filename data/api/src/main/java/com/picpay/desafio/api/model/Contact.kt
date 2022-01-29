package com.picpay.desafio.api.model

import com.google.gson.annotations.SerializedName

/**
 * Data class representing a contact and its data.
 *
 * @param image the picture of the contact
 * @param name the name of the contact
 * @param id the id of the contact
 * @param username the username of the contact
 */
internal data class Contact(
    @SerializedName("img")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String?
)
