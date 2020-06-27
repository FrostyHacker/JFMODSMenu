package com.frosty.jfmodsmenu;

public class NativeLibrary {
    public static native void changeSeekBar(int i, int i2);

    public static native void changeToggle(int i);

    public static native void init();

    public static native void spinnerToggle(int i);

    static {
        System.loadLibrary("hook");
    }

    public NativeLibrary() {
    }
}
