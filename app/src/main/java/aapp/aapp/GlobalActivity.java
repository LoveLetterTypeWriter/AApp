package aapp.aapp;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by 1089C on 5/13/2015.
 */
public class GlobalActivity extends Application {
    public static Context currentContext;

    @Override
    public void onCreate() {
        super.onCreate();
        currentContext = getApplicationContext();
    }
}
