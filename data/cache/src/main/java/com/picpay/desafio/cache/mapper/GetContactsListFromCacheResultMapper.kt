package com.picpay.desafio.cache.mapper

import com.picpay.desafio.cache.model.GetContactsListFromCacheResult as CacheResult
import com.picpay.desafio.repository.model.GetContactsListFromCacheResult as RepositoryResult

/**
 * Mapper used to map a result from the get contacts list operation.
 *
 * @param contactMapper mapper used to map a contact
 */
internal class GetContactsListFromCacheResultMapper(private val contactMapper: ContactMapper) {

    /**
     * Maps a [CacheResult] to a [RepositoryResult].
     *
     * @param cacheResult the result to be mapped
     *
     * @return the mapped result
     */
    fun toRepository(cacheResult: CacheResult): RepositoryResult =
        when (cacheResult) {
            is CacheResult.Success -> RepositoryResult.Success(cacheResult.contactsList.map { contact ->
                contactMapper.toRepository(
                    contact
                )
            })
            is CacheResult.Error -> RepositoryResult.Error(cacheResult.error)
        }
}
