package com.picpay.desafio.contacts.mapper

import com.picpay.desafio.contacts.model.GetContactsListState as PresentationState
import com.picpay.desafio.domain.model.GetContactsListState as DomainState

/**
 * Mapper used to map the state of get contacts list.
 *
 * @param contactMapper mapper used to map a contact
 */
internal class GetContactsListStateMapper(private val contactMapper: ContactMapper) {

    /**
     * Maps a [DomainState] to a [PresentationState].
     *
     * @param domainState the state to be mapped
     *
     * @return the mapped state
     */
    fun toPresentation(domainState: DomainState): PresentationState =
        when (domainState) {
            is DomainState.Loaded -> PresentationState.Loaded(
                contactMapper.toPresentation(domainState.contactsList)
            )
            is DomainState.Failed -> PresentationState.Failed(domainState.error)
            is DomainState.Empty -> PresentationState.Empty
            is DomainState.LoadedFromCache -> PresentationState.LoadedFromCache(
                contactMapper.toPresentation(domainState.contactsList)
            )
        }
}
