package com.kabms.hilttutorial

import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Step 5: Once Hilt is set up in your Application class and an application-level
 * component is available, Hilt can provide dependencies to other Android classes
 * that have the @AndroidEntryPoint annotation.
 * Step 6: If you annotate an Android class with @AndroidEntryPoint, then you also
 * must annotate Android classes that depend on it. For example, if you annotate a
 * fragment, then you must also annotate any activities where you use that fragment.
 * Step 7: @AndroidEntryPoint generates an individual Hilt component for each Android
 * class in your project. These components can receive dependencies from their
 * respective parent classes as described in
 * https://developer.android.com/training/dependency-injection/hilt-android#component-hierarchy.
 * Note: The following exceptions apply to Hilt support for Android classes:
 *  - Hilt only supports activities that extend ComponentActivity, such as
 *  AppCompatActivity.
 *  - Hilt only supports fragments that extend androidx.Fragment.
 *  - Hilt does not support retained fragments.
 *  Classes that Hilt injects can have other base classes that also use injection.
 *  Those classes don't need the @AndroidEntryPoint annotation if they're abstract.
 *  To learn more about which lifecycle callback an Android class gets injected in,
 *  see https://developer.android.com/training/dependency-injection/hilt-android#component-lifetimes.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Note: Fields injected by Hilt cannot be private. Attempting to inject a private field with Hilt results in a compilation error.
    @Inject lateinit var sessionManager: SessionManagerImpl


}