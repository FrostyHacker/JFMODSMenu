package com.frosty.jfmodsmenu;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@SuppressLint("StaticFieldLeak")
public class AuthLogin extends AsyncTask<String, Void, String> {
    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2002;

    Context context;

    public ProgressDialog pDialog;

    public WeakReference<MainActivity> weakActivity;

    AuthLogin(Context paramContext) {

        this.context = paramContext;
    }

    public AuthLogin(MainActivity paramMainActivity) {
        this.weakActivity = new WeakReference<MainActivity>(paramMainActivity);
        ProgressDialog progressDialog = new ProgressDialog((Context)paramMainActivity);
        progressDialog.setCancelable(false);
        this.pDialog = progressDialog;
    }

    public void Start() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(getActivity())) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getActivity().getPackageName()));
            getActivity().startActivityForResult(intent, CODE_DRAW_OVER_OTHER_APP_PERMISSION);
        } else {
            getActivity().startService(new Intent(getActivity(), MenuService.class));

        }
    }

    @Override
    protected String doInBackground(String... strings) {
        URL url;
        String fetched = null;
        try {
            url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                fetched = line;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return fetched;
    }

    public final MainActivity getActivity() {
        return this.weakActivity.get();
    }

    public final ProgressDialog getDialog() {
        return this.pDialog;
    }

    @Override
    protected void onPostExecute(String paramString) {
        if (getActivity() != null) {
            if (getDialog() != null)
                getDialog().dismiss();
            if (getActivity().PasswordEt.getText().toString().equals(paramString) && getActivity().UsernameEt.getText().toString().equals(paramString)) {
                Start();
                Toast.makeText((Context)getActivity(), "Login Successful", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText((Context)getActivity(), "Expired", Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    protected void onPreExecute() {
        if (getActivity() != null && getDialog() != null) {
            getDialog().setMessage("Logging...");
            getDialog().show();
        }
    }

    @Override
    public void onProgressUpdate(Void... voidArr) {
            super.onProgressUpdate(voidArr);
    }


}
