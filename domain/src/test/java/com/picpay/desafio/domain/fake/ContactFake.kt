package com.picpay.desafio.domain.fake

import com.picpay.desafio.domain.model.Contact

/**
 * Fake used to provide contact fakes.
 */
internal object ContactFake {

    val CONTACT = Contact(
        id = 0,
        username = "fake",
        name = "fake",
        image = "fake"
    )
}
