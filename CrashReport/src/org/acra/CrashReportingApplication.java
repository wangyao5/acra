package org.acra;

import android.app.Application;

public abstract class CrashReportingApplication extends Application {

    /* (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();
        ErrorReporter crashReporter = new ErrorReporter();
        crashReporter.init(getApplicationContext());
    }

}
