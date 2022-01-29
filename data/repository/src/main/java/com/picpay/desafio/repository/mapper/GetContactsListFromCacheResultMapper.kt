package com.picpay.desafio.repository.mapper

import com.picpay.desafio.domain.model.GetContactsListFromCacheResult as DomainResult
import com.picpay.desafio.repository.model.GetContactsListFromCacheResult as RepositoryResult

/**
 * Mapper used to map a result from the get contacts list operation.
 *
 * @param contactMapper mapper used to map a contact
 */
internal class GetContactsListFromCacheResultMapper(private val contactMapper: ContactMapper) {

    /**
     * Maps a [RepositoryResult] to a [DomainResult].
     *
     * @param repositoryResult the result to be mapped
     *
     * @return the mapped result
     */
    fun toDomain(repositoryResult: RepositoryResult): DomainResult =
        when (repositoryResult) {
            is RepositoryResult.Success -> DomainResult.Success(repositoryResult.contactsList.map { contact ->
                contactMapper.toDomain(
                    contact
                )
            })
            is RepositoryResult.Error -> DomainResult.Error(repositoryResult.error)
        }
}
