package com.frosty.jfmodsmenu;

import android.app.ActivityManager;

class Util {

    static float getConvertetValue(int intVal) {
        int value;
        value = intVal * 1;
        return value;
    }

    static boolean isAppBackground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance != 100;
    }
}
