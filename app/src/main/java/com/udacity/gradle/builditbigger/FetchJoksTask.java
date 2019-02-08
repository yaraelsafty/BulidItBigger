package com.udacity.gradle.builditbigger;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.example.andjoklib.JokyActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.gradle.builditbigger.backend.myApi.model.MyBean;

import java.io.IOException;

/**
 */

@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class FetchJoksTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi jokyApi = null;
    private Context context;
    private ProgressBar mProgressBar;

    public FetchJoksTask(ProgressBar progressBar, Context context) {
        this.mProgressBar = progressBar;
        this.context = context;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (jokyApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");

            jokyApi = builder.build();
        }
        
        try {
            String myJoke = jokyApi.putJoke(new MyBean()).execute().getJoke();
            Log.i("Joke :) ", myJoke);

            return myJoke;
        } catch (IOException e) {

            return null;
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onPostExecute(final String result) {
        super.onPostExecute(result);

        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        startJokyActivity(result);

    }

    private void startJokyActivity(String mResult) {
        Intent i = new Intent(context, JokyActivity.class);
        i.putExtra(JokyActivity.INTENT_JOKE, mResult);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}


