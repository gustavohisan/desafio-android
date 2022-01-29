package com.picpay.desafio.domain.filter

import com.picpay.desafio.domain.model.Contact

/**
 * Filter used to filter contacts that have incomplete data.
 */
internal class ContactFilter {

    /**
     * Filters a list of contacts with incomplete data.
     *
     * @param contactsList the list to be filtered
     *
     * @return the filtered list of contacts
     */
    fun filterIncompleteContact(contactsList: List<Contact>) =
        contactsList.filter { contact ->
            contact.image.isNotEmpty() && contact.name.isNotEmpty() && contact.username.isNotEmpty()
        }
}
