package org.acra;

import android.app.Activity;
import android.os.Bundle;

public class CrashTestActivity extends Activity {

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        ErrorReporter.getInstance().checkAndSendReports(getApplicationContext());
        Object nul = null;
        nul.toString();
    }

}
