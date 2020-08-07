package com.kabms.hilttutorial.hilt

import com.kabms.hilttutorial.SessionManager
import com.kabms.hilttutorial.SessionManagerImpl
import com.kabms.hilttutorial.SessionService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

/**
 * A Hilt module is a class that is annotated with @Module. Like a Dagger
 * module, it informs Hilt how to provide instances of certain types.
 * Unlike Dagger modules, you must annotate Hilt modules with @InstallIn
 * to tell Hilt which Android class each module will be used or installed in.
 * Dependencies that you provide in Hilt modules are available in all
 * generated components that are associated with the Android class where
 * you install the Hilt module.
 */
@Module
/**
 * The Hilt module AnalyticsModule is annotated with
 * @InstallIn(ActivityComponent::class) because you want Hilt
 * to inject that dependency into ExampleActivity. This annotation means
 * that all of the dependencies in AnalyticsModule are available in all of
 * the app's activities.
 */
@InstallIn(ActivityComponent::class)
abstract class SessionModule {

    /**
     * The @Binds annotation tells Hilt which implementation to use when
     * it needs to provide an instance of an interface.
     *
     * The annotated function provides the following information to Hilt:
     *  - The function return type tells Hilt what interface the function
     *      provides instances of.
     *  - The function parameter tells Hilt which implementation to provide.
     */
    @Binds
    abstract fun bindSessionManager(
        sessionManagerImpl: SessionManagerImpl
    ): SessionManager

    /**
     * If you don't directly own the AnalyticsService class, you can tell
     * Hilt how to provide instances of this type by creating a function inside
     * a Hilt module and annotating that function with @Provides.
     *
     * The annotated function supplies the following information to Hilt:
     *  - The function return type tells Hilt what type the function provides
     *  instances of.
     *  - The function parameters tell Hilt the dependencies of the corresponding
     *  type.
     *  - The function body tells Hilt how to provide an instance of the
     *  corresponding
     *  type. Hilt executes the function body every time it needs to provide an
     *  instance of that type.
     */
    @Provides
    fun provideSessionService(): SessionService {
        return Retrofit.Builder().baseUrl("https://example.com")
            .build()
            .create(SessionService::class.java)
    }
}