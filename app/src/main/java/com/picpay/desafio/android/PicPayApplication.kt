package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.api.injection.apiModule
import com.picpay.desafio.cache.injection.cacheModule
import com.picpay.desafio.contacts.injection.contactsModule
import com.picpay.desafio.domain.injection.domainModule
import com.picpay.desafio.repository.injection.repositoryModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Application class used for dependency injection.
 */
internal class PicPayApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidContext(this@PicPayApplication)
            modules(
                domainModule,
                repositoryModule,
                apiModule,
                contactsModule,
                cacheModule
            )
        }
    }
}
