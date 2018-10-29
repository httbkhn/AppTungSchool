package com.example.admin.myapp.ConnectDatabase;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;

import com.example.admin.myapp.MainActivity;
import com.example.parent.ParentMenuActivity;
import com.example.teacher.TeacherMainActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Duy Anh on 10/13/2018
 **/
public class BackgroungWorker extends AsyncTask<String, Void, String> {
    Context context;
    AlertDialog alertDialog;


    public BackgroungWorker(Context ctx) {
        context = ctx;
    }

    static MainActivity mainActivity = new MainActivity();

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        //String root = "http://192.168.7.199/";
        String root = "http://192.168.0.102/";
        //String root = "http://192.168.0.104/";
        //String root = "http://192.168.133.130/";
        String folder = "php_tungschool/";
        String foot = ".php";
        //admin
        return ExecuteQuery(type, root + folder + type + foot, params);
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");
    }

    @Override
    protected void onPostExecute(String result) {
        //alertDialog.setMessage(result);
        //alertDialog.show();
        ShowActivity(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    private void ShowActivity(String result) {

        if (!result.equals("false")) {
            if(result.equals("Parent")) ShowParentAcitity();

            if(result.equals("Teacher")) ShowTeacherAcitity();
        }
        else
        {
            Toast.makeText(context,"Wrong account or password.\n Please try again.",
                    Toast.LENGTH_SHORT).show();
        }
        MainActivity.progressBar.setVisibility(View.GONE);
    }

    private String ExecuteQuery(String type, String path, String... params) {
        if (type.equals("login")) {
            try {
                String user = params[1];
                String pass = params[2];

                URL url = new URL(path);

                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user", "UTF-8") + "=" + URLEncoder.encode(user, "UTF-8") + "&&"
                        + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "ISO-8859-1"));

                String result = "";
                String line = "";

                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
        return null;
    }

    private void ShowParentAcitity()
    {
        Intent intent = new Intent(context, ParentMenuActivity.class);
        context.startActivity(intent);
    }
    private void ShowTeacherAcitity()
    {
        Intent intent = new Intent(context, TeacherMainActivity.class);
        context.startActivity(intent);
    }
}
