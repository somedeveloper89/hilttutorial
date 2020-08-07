package com.kabms.hilttutorial.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.inject.Qualifier

/**
 * In cases where you need Hilt to provide different implementations of
 * the same type as dependencies, you must provide Hilt with multiple
 * bindings. You can define multiple bindings for the same type with qualifiers.
 */

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthInterceptorOkHttpClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class OtherInterceptorOkHttpClient

@Module
@InstallIn(ApplicationComponent::class)
object MultiBindingModule {

    /**
     * Then, Hilt needs to know how to provide an instance of the type that
     * corresponds with each qualifier. In this case, you could use a Hilt
     * module with @Provides. Both methods have the same return type, but the
     * qualifiers label them as two different bindings:
     */

    @AuthInterceptorOkHttpClient
    @Provides
    fun provideAuthInterceptorOkHttpClient(
        authInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(authInterceptor)
            .build()
    }

    @OtherInterceptorOkHttpClient
    @Provides
    fun provideOtherInterceptorOkHttpClient(
        otherInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(otherInterceptor)
            .build()
    }

}