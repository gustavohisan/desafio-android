package com.picpay.desafio.repository.mapper

import com.picpay.desafio.domain.model.GetContactsListState as DomainState
import com.picpay.desafio.repository.model.GetContactsResult as RepositoryResult

/**
 * Mapper used to map the result of the get contacts operation.
 *
 * @param contactMapper mapper used to map a contact
 */
internal class GetContactsResultMapper(private val contactMapper: ContactMapper) {

    /**
     * Maps a [RepositoryResult] to a [DomainState].
     *
     * @param repositoryResult the result to be mapped
     *
     * @return the mapped result
     */
    fun toDomain(repositoryResult: RepositoryResult): DomainState =
        when (repositoryResult) {
            is RepositoryResult.Success -> DomainState.Loaded(repositoryResult.contactsList.map { contact ->
                contactMapper.toDomain(
                    contact
                )
            })
            is RepositoryResult.Error -> DomainState.Failed(repositoryResult.error)
        }
}
