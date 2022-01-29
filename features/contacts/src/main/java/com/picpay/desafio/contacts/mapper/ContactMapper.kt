package com.picpay.desafio.contacts.mapper

import com.picpay.desafio.contacts.model.Contact as PresentationContact
import com.picpay.desafio.domain.model.Contact as DomainContact

/**
 * Mapper used to map a contact.
 */
internal class ContactMapper {

    /**
     * Maps a list of [DomainContact] to a list of [PresentationContact].
     *
     * @param domainContactList the list to be mapped
     *
     * @return the mapped list of contacts
     */
    fun toPresentation(domainContactList: List<DomainContact>): List<PresentationContact> =
        domainContactList.map { contact -> toPresentation(contact) }

    private fun toPresentation(domainContact: DomainContact): PresentationContact =
        PresentationContact(
            image = domainContact.image,
            name = domainContact.name,
            id = domainContact.id,
            username = domainContact.username
        )

    /**
     * Maps a list of [PresentationContact] to a list of [DomainContact].
     *
     * @param presentationContactList the list to be mapped
     *
     * @return the mapped list of contacts
     */
    fun toDomain(presentationContactList: List<PresentationContact>): List<DomainContact> =
        presentationContactList.map { contact -> toDomain(contact) }

    private fun toDomain(presentationContact: PresentationContact): DomainContact =
        DomainContact(
            image = presentationContact.image,
            name = presentationContact.name,
            id = presentationContact.id,
            username = presentationContact.username
        )
}
