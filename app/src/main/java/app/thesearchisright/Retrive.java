package app.thesearchisright;

import android.os.AsyncTask;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Lachlan on 19/05/2017.
 */
public class Retrive {

    private static int arraySize;

    public void getRes(String q) throws IOException {

        new RetrieveInt().execute(q);
    }

    private class RetrieveInt extends AsyncTask<String, Void, Integer> {


        @Override
        protected Integer doInBackground(String ... params) {
            Integer res = 0;
            try {
//                URL url = new URL("https://google.com/search?q=" + params[0].toString());
                URL url = new URL("https://www.google.com/search?q=" + params[0].toString());

                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));

                StringBuilder total = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    total.append(line).append('\n');
                }

//                line.indexOf("resultStats");
                String x = line.substring(line.indexOf("About"), line.indexOf("results"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            return res;
        }


        protected void onPostExecute(Integer i) {

            // TODO: do something with the number

        }
    }


}