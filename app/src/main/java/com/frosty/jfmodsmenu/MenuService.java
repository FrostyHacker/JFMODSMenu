package com.frosty.jfmodsmenu;


import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Base64;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class MenuService extends Service {
    private Button Close;

    private Button Creditos;

    private Button Mods;

    private ImageView closeMenu;

    private LinearLayout creditos;

    private LinearLayout fundo;

    Drawable icon;

    private LinearLayout layout_close;

    private LinearLayout mButtonPanel;

    private RelativeLayout mCollapsed;

    private LinearLayout mExpandet;

    private View mFloatingView;

    private RelativeLayout mRootContainer;

    private LinearLayout mTitlle;

    private WindowManager mWindowManager;

    private LinearLayout mods;

    private WindowManager.LayoutParams params;

    private LinearLayout patches;

    private LinearLayout primeira;

    private LinearLayout principal;

    private FrameLayout rootFrame;

    private ImageView startimage;

    private LinearLayout tab;

    private void addButton(final String paramString, final BTN paramBTN) {
        final Button button = new Button((Context)this);
        button.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(555, 63));
        button.setAllCaps(false);
        button.setText((CharSequence)new StringBuffer().append(paramString).append(": Off").toString());
        button.setTextColor(Color.WHITE);
        button.setShadowLayer((float)15, (float)0, (float)0, Color.RED);
        button.setBackgroundColor(Color.TRANSPARENT);
        button.setPadding(0, 0, 0, 0);
        button.setTextSize(13.0f);
        button.setGravity(17);
        button.setOnClickListener(new View.OnClickListener() {
            public boolean isChecked;

            @Override
            public void onClick(View param1View) {
                String str;
                boolean bool;
                if (this.isChecked) {
                    bool = false;
                } else {
                    bool = true;
                }
                this.isChecked = bool;
                paramBTN.OnWrite(this.isChecked);
                click_btn(this.isChecked);
                Button button2 = button;
                if (this.isChecked);
                button2.setBackgroundColor(Color.CYAN);
                Button button3 = button;
                StringBuffer stringBuffer = (new StringBuffer()).append(paramString);
                if (this.isChecked) {
                    str = ": On";
                } else {
                    str = ": Off";
                }
                button3.setText(stringBuffer.append(str).toString());
                Button button1 = button;
                if (this.isChecked);
                button1.setTextColor(Color.WHITE);
                final  Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setBackgroundColor(Color.TRANSPARENT);

                    }
                },200);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (this.isChecked) {
                        button.setShadowLayer(15, 0, 0, Color.CYAN);
                        return;
                    }
                } else {
                    return;
                }
                button.setShadowLayer(15, 0, 0, Color.RED);
            }
        });
        this.mods.addView((View)button);
    }

    private void addSeekbar(int paramInt, final SBar paramSBar) {
        SeekBar seekBar = new SeekBar((Context)this);
        seekBar.setMax(paramInt);
        seekBar.getProgressDrawable().setColorFilter(Color.parseColor("#B200FFFF"), PorterDuff.Mode.MULTIPLY);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams)layoutParams).topMargin = dp(2);
        seekBar.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            public void onProgressChanged(SeekBar param1SeekBar, int param1Int, boolean param1Boolean) {
                paramSBar.OnWrite(param1Int);
            }

            public void onStartTrackingTouch(SeekBar param1SeekBar) {}

            public void onStopTrackingTouch(SeekBar param1SeekBar) {}
        });
        this.mods.addView((View)seekBar);
    }

    private void addSpinner(String paramString1, String paramString2, final SP paramSP) {
        LinkedList linkedList = new LinkedList(Arrays.asList((Object[])paramString2.split("_")));
        LinearLayout linearLayout2 = new LinearLayout((Context)this);
        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams)layoutParams1).leftMargin = dp(5);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.setGravity(17);
        linearLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
        linearLayout2.setBackgroundColor(Color.TRANSPARENT);
        TextView textView = new TextView((Context)this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        textView.setText(paramString1);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(12);
        textView.setShadowLayer((float)15, (float)0, (float)0, Color.RED);
        textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        LinearLayout linearLayout1 = new LinearLayout((Context)this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMargins(10, 2, 10, 5);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setGravity(17);
        linearLayout1.setBackgroundColor(Color.TRANSPARENT);
        linearLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
        Spinner spinner = new Spinner((Context)this);
        spinner.setGravity(17);
        spinner.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
        spinner.getBackground().setColorFilter(1, PorterDuff.Mode.SRC_ATOP);
        linkedList.get(0);
        ArrayAdapter arrayAdapter = new ArrayAdapter((Context)this, android.R.layout.simple_spinner_item, linkedList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter)arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
                ((TextView)param1AdapterView.getChildAt(0)).setTextColor(Color.WHITE);
                ((TextView)param1AdapterView.getChildAt(0)).setShadowLayer(15, 0, 0, Color.CYAN);
                ((TextView)param1AdapterView.getChildAt(0)).setTextSize(12);
                paramSP.OnWrite(param1Int);
            }

            @Override
            public void onNothingSelected(AdapterView<?> param1AdapterView) {}
        });
        linearLayout2.addView((View)textView);
        linearLayout1.addView((View)spinner);
        this.mods.addView((View)linearLayout2);
        this.mods.addView((View)linearLayout1);
    }

    private TextView addText(String paramString,LinearLayout layout) {
        TextView textView = new TextView((Context)this);
        textView.setText(paramString);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(0, 0, 0, 0);
        textView.setShadowLayer(15, 0, 0, Color.CYAN);
        textView.setTextSize(12);
        textView.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        ((ViewGroup.MarginLayoutParams)layoutParams).topMargin = dp(3);
        textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        layout.addView((View)textView);
        return textView;
    }

    private int dp(int paramInt) {
        return (int)TypedValue.applyDimension(1, paramInt, getResources().getDisplayMetrics());
    }

    private int dp2px(int paramInt) {
        float f = (getResources().getDisplayMetrics()).density;
        return (int)(paramInt * f + 0.5F);
    }

    private float getConvertetValue(int paramInt) {
        return paramInt * 0.1F;
    }

    private void initFloating() {
        AssetManager assetManager = getAssets();
        this.rootFrame = new FrameLayout(getBaseContext());
        this.mRootContainer = new RelativeLayout(getBaseContext());
        this.mCollapsed = new RelativeLayout(getBaseContext());
        this.mExpandet = new LinearLayout(getBaseContext());
        this.layout_close = new LinearLayout(getBaseContext());
        this.tab = new LinearLayout(getBaseContext());
        this.patches = new LinearLayout(getBaseContext());
        this.mods = new LinearLayout(getBaseContext());
        this.creditos = new LinearLayout(getBaseContext());
        this.primeira = new LinearLayout(getBaseContext());
        this.fundo = new LinearLayout(getBaseContext());
        this.principal = new LinearLayout(getBaseContext());
        this.mButtonPanel = new LinearLayout(getBaseContext());
        this.mTitlle = new LinearLayout(getBaseContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.rootFrame.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        this.mRootContainer.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2));
        this.mCollapsed.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
        this.mCollapsed.setVisibility(View.VISIBLE);
        try {
            this.startimage = new ImageView(getBaseContext());
            this.startimage.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-2, -2));
            int i = (int)TypedValue.applyDimension(1, 70, getResources().getDisplayMetrics());
            (this.startimage.getLayoutParams()).height = i;
            (this.startimage.getLayoutParams()).width = i;
            this.startimage.requestLayout();
            this.startimage.setScaleType(ImageView.ScaleType.FIT_XY);
            this.icon = Drawable.createFromStream(assetManager.open("ic_hack_floating.png"), (String)null);
            this.startimage.setImageDrawable(this.icon);
            this.mExpandet.setVisibility(View.GONE);
            this.mExpandet.setBackgroundColor(Color.TRANSPARENT);
            this.mExpandet.setOrientation(LinearLayout.VERTICAL);
            this.mExpandet.setGravity(5);
            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(560, 600);
            this.mExpandet.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
            this.layout_close.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 50));
            this.layout_close.setBackgroundColor(Color.TRANSPARENT);
            this.layout_close.setGravity(3);
            this.layout_close.setOrientation(LinearLayout.HORIZONTAL);
            this.tab.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(270, 60));
            this.tab.setBackgroundColor(Color.BLACK);
            this.tab.setGravity(5);
            this.tab.setPadding(5, 5, 5, 0);
            this.tab.setAlpha(0.8F);
            this.tab.setOrientation(LinearLayout.HORIZONTAL);
            this.patches.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
            this.patches.setBackgroundColor(Color.BLACK);
            this.patches.setOrientation(LinearLayout.VERTICAL);
            this.fundo.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
            this.fundo.setPadding(5, 5, 5, 5);
            this.fundo.setBackgroundColor(Color.BLACK);
            this.fundo.setAlpha(0.8F);
            this.fundo.setOrientation(LinearLayout.VERTICAL);
            this.principal.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
            this.principal.setBackgroundColor(Color.TRANSPARENT);
            this.principal.setOrientation(LinearLayout.VERTICAL);
            this.mods.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
            this.mods.setBackgroundColor(Color.TRANSPARENT);
            this.mods.setOrientation(LinearLayout.VERTICAL);
            this.creditos.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
            this.creditos.setBackgroundColor(Color.BLUE);
            this.creditos.setVisibility(View.GONE);
            this.creditos.setOrientation(LinearLayout.VERTICAL);
            ScrollView scrollView = new ScrollView(getBaseContext());
            scrollView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, 480));
            this.closeMenu = new ImageView((Context)this);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(140, dp(45));
            this.closeMenu.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
            this.closeMenu.setPadding(0, 4, 0, 2);
            byte[] arrayOfByte = Base64.decode("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", 0);
            Bitmap bitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
            this.closeMenu.setImageBitmap(bitmap);
            this.primeira.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(394, -1));
            this.primeira.setBackgroundColor(Color.TRANSPARENT);
            this.primeira.setOrientation(LinearLayout.VERTICAL);
            this.principal.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -1));
            this.principal.setBackgroundColor(Color.TRANSPARENT);
            this.principal.setOrientation(LinearLayout.VERTICAL);
            this.mButtonPanel.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
            this.mTitlle.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
            this.mTitlle.setGravity(17);
            ((ViewGroup.MarginLayoutParams)new LinearLayout.LayoutParams(-1, dp(23))).topMargin = dp(3);
            this.Mods = new Button((Context)this);
            LinearLayout.LayoutParams gfg = new LinearLayout.LayoutParams(130, -1);
            this.Mods.setLayoutParams((ViewGroup.LayoutParams)gfg);
            this.Mods.setText("Mods");
            this.Mods.setAllCaps(false);
            this.Mods.setTypeface((Typeface)null, Typeface.BOLD);
            this.Mods.setBackgroundColor(Color.BLACK);
            this.Mods.setTextSize(10);
            this.Mods.setPadding(2, 2, 2, 2);
            this.Mods.setTextColor(Color.CYAN);
            this.tab.addView((View)this.Mods);
            this.Creditos = new Button((Context)this);
            LinearLayout.LayoutParams ff = new LinearLayout.LayoutParams(130, -1);
            this.Creditos.setLayoutParams((ViewGroup.LayoutParams)ff);
            this.Creditos.setText("Credits");
            this.Creditos.setAllCaps(false);
            this.Creditos.setTypeface((Typeface)null, Typeface.BOLD);
            this.Creditos.setBackgroundColor(Color.BLACK);
            this.Creditos.setTextSize(10);
            this.Creditos.setPadding(2, 2, 2, 2);
            this.Creditos.setTextColor(Color.RED);
            this.tab.addView((View)this.Creditos);
            this.Close = new Button((Context)this);
            LinearLayout.LayoutParams ggg = new LinearLayout.LayoutParams(70, 50);
            this.Close.setLayoutParams((ViewGroup.LayoutParams)ggg);
            this.Close.setText("X");
            this.Close.setTypeface((Typeface)null, Typeface.BOLD);
            this.Close.setBackgroundColor(Color.BLACK);
            this.Close.setGravity(17);
            this.Close.setTextSize(11);
            this.Close.setPadding(0, 3, 3, 0);
            this.Close.setTextColor(Color.RED);
            this.layout_close.addView((View)this.Close);
            TextView textView2 = new TextView(getBaseContext());
            LinearLayout.LayoutParams layoutParamstextView2 = new LinearLayout.LayoutParams(-1, -2);
            textView2.setText("Standoff 2");
            textView2.setGravity(17);
            textView2.setLayoutParams(layoutParamstextView2);
            textView2.setShadowLayer((float)25, (float)0, (float)0, Color.CYAN);
            textView2.setTypeface(Typeface.DEFAULT_BOLD);
            textView2.setTextSize(14);
            textView2.setPadding(10, 1, 10, 6);
            textView2.setTextColor(Color.CYAN);
            this.mods.addView(textView2);
            TextView textView = new TextView(getBaseContext());
            LinearLayout.LayoutParams layoutParamstextView = new LinearLayout.LayoutParams(-1, -2);
            textView.setText("Fuck u jfmods");
            textView.setGravity(17);
            textView.setLayoutParams(layoutParamstextView);
            textView.setShadowLayer((float)25, (float)0, (float)0, Color.CYAN);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextSize(14);
            textView.setPadding(10, 1, 10, 6);
            textView.setTextColor(Color.CYAN);
            this.mods.addView(textView);
            this.rootFrame.addView((View)this.mRootContainer);
            this.mRootContainer.addView((View)this.mCollapsed);
            this.mRootContainer.addView((View)this.mExpandet);
            this.mCollapsed.addView((View)this.startimage);
            this.mExpandet.addView((View)this.tab);
            this.mExpandet.addView((View)this.fundo);
            this.fundo.addView((View)this.patches);
            this.patches.addView((View)scrollView);
            scrollView.addView((View)this.principal);
            this.principal.addView((View)this.mods);
            this.principal.addView((View)this.creditos);
            this.patches.addView((View)this.layout_close);
            this.mFloatingView = (View)this.rootFrame;
        } catch (IOException iOException) {
            Toast.makeText(getBaseContext(), iOException.toString(), Toast.LENGTH_LONG).show();
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.params = new WindowManager.LayoutParams(-2, -2, WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
        } else {
            this.params = new WindowManager.LayoutParams(-2, -2, 512, 1024, 2002, 8, -3);
        }
        this.params.gravity = 51;
        this.params.x = 0;
        this.params.y = 100;
        this.mWindowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        this.mWindowManager.addView(this.mFloatingView, (ViewGroup.LayoutParams)this.params);
        this.mFloatingView.setOnTouchListener(onTouchListener());
        this.startimage.setOnTouchListener(onTouchListener());
        initMenuButton((View)mCollapsed, (View)mExpandet);
        modMenu();
        Credits();
    }

    private void initMenuButton(final View paramView1, final View paramView2) {
        this.startimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View param1View) {
                paramView1.setVisibility(View.GONE);
                paramView2.setVisibility(View.VISIBLE);
            }
        });
        this.Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View param1View) {
                paramView1.setVisibility(View.VISIBLE);
                paramView2.setVisibility(View.GONE);
            }
        });
        this.Mods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View param1View) {
                mods.setVisibility(View.VISIBLE);
                creditos.setVisibility(View.GONE);
                Mods.setTextColor(Color.CYAN);
                Creditos.setTextColor(Color.RED);
            }
        });
        this.Creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View param1View) {
                creditos.setVisibility(View.VISIBLE);
                mods.setVisibility(View.GONE);
                Creditos.setTextColor(Color.CYAN);
                Mods.setTextColor(Color.RED);
            }
        });
    }

    private boolean isViewCollapsed() {
        return mFloatingView == null || mCollapsed.getVisibility() == View.VISIBLE;
    }

    private void modMenu() {
       addButton("Unlimited Ammo", new BTN() {

            public void OnWrite(boolean param1Boolean) {
                //NativeLibrary.changeToggle(1);
            }
        });
        addButton("Fov", new BTN() {
            public void OnWrite(boolean param1Boolean) {
                //NativeLibrary.changeToggle(2);
            }
        });
        addButton("Respawn Player", new BTN() {

            public void OnWrite(boolean param1Boolean) {
                //NativeLibrary.changeToggle(3);
            }
        });
        addButton("Defuse Anywhere", new BTN() {


            public void OnWrite(boolean param1Boolean) {
                //NativeLibrary.changeToggle(4);
            }
        });
        addText("Test Seekbar",mods);
        addSeekbar(100, new SBar() {
            @Override
            public void OnWrite(int param1Int) {
                Toast.makeText(MenuService.this,String.valueOf(param1Int),Toast.LENGTH_LONG).show();
            }
        });
        addSpinner("Test", "Test_Test 1_Test 2", new SP() {
            @Override
            public void OnWrite(int param1Int) {
                Toast.makeText(MenuService.this,String.valueOf(param1Int),Toast.LENGTH_LONG).show();
            }
        });
    }

    void Credits()
    {
        addText("Fuck u jfmods",creditos);
        addText("Fuck u jfmods",creditos);
        addText("Fuck u jfmods",creditos);
        addText("Fuck u jfmods",creditos);
        addText("Fuck u jfmods",creditos);

    }

    private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            final View collapsedView = mCollapsed;
            //The root element of the expanded view layout
            final View expandedView = mExpandet;
            private int initialX;
            private int initialY;
            private float initialTouchX;
            private float initialTouchY;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:

                        //remember the initial position.
                        initialX = params.x;
                        initialY = params.y;

                        //get the touch location
                        initialTouchX = event.getRawX();
                        initialTouchY = event.getRawY();
                        return true;
                    case MotionEvent.ACTION_UP:
                        int Xdiff = (int) (event.getRawX() - initialTouchX);
                        int Ydiff = (int) (event.getRawY() - initialTouchY);

                        //The check for Xdiff <10 && YDiff< 10 because sometime elements moves a little while clicking.
                        //So that is click event.
                        if (Xdiff < 10 && Ydiff < 10) {
                            if (isViewCollapsed()) {
                                //When user clicks on the image view of the collapsed layout,
                                //visibility of the collapsed layout will be changed to "View.GONE"
                                //and expanded view will become visible.
                                collapsedView.setVisibility(View.GONE);
                                expandedView.setVisibility(View.VISIBLE);

                            }
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        //Calculate the X and Y coordinates of the view.
                        params.x = initialX + (int) (event.getRawX() - initialTouchX);
                        params.y = initialY + (int) (event.getRawY() - initialTouchY);

                        //Update the layout with new X & Y coordinate
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                }
                return false;
            }
        };
    }
    public void click_btn(boolean paramBoolean) {}

    public final int conertDipPixels(float paramFloat) {
        return (int)(0.5F + (getResources().getDisplayMetrics()).density * paramFloat);
    }

    @Override
    public IBinder onBind(Intent paramIntent) {
        return (IBinder)null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                MenuService.this.Thread();
                if (mExpandet.getVisibility() == View.VISIBLE) {
                    mCollapsed.setVisibility(View.INVISIBLE);
                }
                handler.postDelayed(this, 1000);
            }
        });
       // NativeLibrary.init();
        initFloating();
    }
    public void Thread() {
        if (this.mFloatingView == null) {
            return;
        }
        if (Util.isAppBackground()) {
            this.mFloatingView.setVisibility(View.INVISIBLE);
            this.mCollapsed.setVisibility(View.INVISIBLE);
        } else  {
            this.mFloatingView.setVisibility(View.VISIBLE);
            this.mCollapsed.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mFloatingView != null)
            this.mWindowManager.removeView(this.mFloatingView);
    }

    @Override
    public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onTaskRemoved(Intent paramIntent) {
        stopSelf();
        long l = 100L;
        try {
            Thread.sleep(l);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        super.onTaskRemoved(paramIntent);
    }

    private interface BTN {
        void OnWrite(boolean param1Boolean);
    }

    private interface SBar {
        void OnWrite(int param1Int);
    }

    private interface SP {
        void OnWrite(int param1Int);
    }
}
