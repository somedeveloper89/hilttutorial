package com.kabms.hilttutorial

import com.kabms.hilttutorial.hilt.AuthInterceptorOkHttpClient
import okhttp3.OkHttpClient
import javax.inject.Inject

/**
 * To perform field injection, Hilt needs to know how to provide instances of
 * the necessary dependencies from the corresponding component. A binding contains
 * the information necessary to provide instances of a type as a dependency.
 * One way to provide binding information to Hilt is constructor injection. Use the
 * @Inject annotation on the constructor of a class to tell Hilt how to provide
 * instances of that class.
 * The parameters of an annotated constructor of a class are the dependencies of
 * that class.
 * Note: At build time, Hilt generates Dagger components for Android classes.
 * Then, Dagger walks through your code and performs the following steps:
 *  - Builds and validates dependency graphs, ensuring that there are no unsatisfied
 *  dependencies and no dependency cycles.
 *  - Generates the classes that it uses at runtime to create the actual objects
 *  and their dependencies.
 */
class SessionManagerImpl @Inject constructor(
    private val service: SessionService,
    // As a dependency of a constructor-injected class with multiple definitions.
    @AuthInterceptorOkHttpClient private val okHttpClient: OkHttpClient
) : SessionManager {

    init {
        log("SessionManager init")
    }

    override fun sayHello() {
        log(this::sayHello)
    }
}

interface SessionManager {
    fun sayHello()
}