package com.frosty.jfmodsmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final int CODE_DRAW_OVER_OTHER_APP_PERMISSION = 2002;
    EditText PasswordEt;
    EditText UsernameEt;

    /* access modifiers changed from: protected */
    @Override
    public void onCreate(Bundle bundle) {

        super.onCreate(bundle);
        setContentView(getResID("activity_main", "layout"));
        this.UsernameEt = (EditText) findViewById(getID("etUserName"));
        this.PasswordEt = (EditText) findViewById(getID("etPassword"));

    }

    public void OnLogin(View paramView) {
        if(this.PasswordEt.getText() != null && this.UsernameEt.getText() != null) {
            (new AuthLogin(this)).execute(new String[]{"https://pastebin.com/raw/M3YERjMx"});
        }
    }

    private int getResID(String str, String str2) {
        return getResources().getIdentifier(str, str2, getPackageName());
    }

    private int getLayout(String str) {
        return getResID(str, "layout");
    }

    private int getID(String str) {
        return getResID(str, "id");
    }

    public MainActivity() {
    }
}
