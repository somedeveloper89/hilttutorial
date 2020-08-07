package com.kabms.hilttutorial

import android.content.Context
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

/**
 * Hilt provides some predefined qualifiers. For example, as you might need the
 * Context class from either the application or the activity, Hilt provides the
 * @ApplicationContext and @ActivityContext qualifiers.
 * Suppose that the AnalyticsAdapter class from the example needs the context of
 * the activity. The following code demonstrates how to provide the activity
 * context to AnalyticsAdapter:
 */
class ExampleAdapter @Inject constructor(
    @ActivityContext private val context: Context,
    private val service: SessionService
) {
}