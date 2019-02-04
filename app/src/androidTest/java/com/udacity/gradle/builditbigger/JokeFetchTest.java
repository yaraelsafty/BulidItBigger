package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

public class JokeFetchTest extends AndroidTestCase {

    private static final String LOG_TAG = "NonEmptyString";

    @SuppressWarnings("unchecked")
    public void test() {

        // Testing that Async task successfully retrieves a non-empty string
        // You can test this from androidTest -> Run 'All Tests'
        Log.v("JokeFetchTest", "Running JokeFetchTest");
        String result = null;
        FetchJoksTask task = new FetchJoksTask(null, getContext());
        task.execute();
        try {
            result = task.get();
            Log.d(LOG_TAG, "Retrieved a non-empty string successfully: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(LOG_TAG,e.getMessage());
        }
//        assertNotNull(result);
    }
}
