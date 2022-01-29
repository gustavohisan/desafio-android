package com.picpay.desafio.api.mapper

import com.picpay.desafio.api.model.GetContactsResult as ApiResult
import com.picpay.desafio.repository.model.GetContactsResult as RepositoryResult

/**
 * Mapper used to map the result of the get contacts operation.
 *
 * @param contactMapper mapper used to map a contact
 */
internal class GetContactsResultMapper(private val contactMapper: ContactMapper) {

    /**
     * Maps a [ApiResult] to a [RepositoryResult].
     *
     * @param apiResult the result to be mapped
     *
     * @return the mapped result
     */
    fun toRepository(apiResult: ApiResult): RepositoryResult =
        when (apiResult) {
            is ApiResult.Success -> RepositoryResult.Success(apiResult.contactsList.map { contact ->
                contactMapper.toRepository(
                    contact
                )
            })
            is ApiResult.Error -> RepositoryResult.Error(apiResult.error)
        }
}
