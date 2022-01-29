package com.picpay.desafio.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.picpay.desafio.contacts.presentation.Contacts
import com.picpay.desafio.design.ApplicationTheme

/**
 * Application main activity.
 */
internal class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ApplicationTheme {
                Contacts()
            }
        }
    }
}
