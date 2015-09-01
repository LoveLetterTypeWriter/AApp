package aapp.aapp;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by 1089C on 3/21/2015.
 */
public class SettingsActivity extends Activity {
    //Settings constants go here
    public static final String IMAGE_PATH = "image_alert_path";
    public static final String AUDIO_PATH = "audio_alert_path";
    public static final String VIDEO_PATH = "video_alert_path";
    public static final String TEXT_STRING = "text_alert_string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //get the new value from Intent data
        Uri uri = data.getData();
        Log.d("E", "File Uri: " + uri.toString());
        String newValue = uri.getPath();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);;
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("image_alert_path", newValue);
        editor.commit();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
