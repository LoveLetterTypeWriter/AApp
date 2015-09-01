package aapp.aapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.scorchworks.demo.SimpleFileDialog;

import java.io.File;

/**
 * Created by 1089C on 3/21/2015.
 */
public class SettingsFragment extends PreferenceFragment {
    EditText editFile;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }


    public void startFileChooser(View v){
        editFile = new EditText(GlobalActivity.currentContext);
        //Create FileOpenDialog and register a callback
        SimpleFileDialog fileOpenDialog =  new SimpleFileDialog(
                GlobalActivity.currentContext,
                "FileOpen..",
                new SimpleFileDialog.SimpleFileDialogListener()
                {
                    @Override
                    public void onChosenDir(String chosenDir)
                    {
                        // The code in this function will be executed when the dialog OK button is pushed
                        editFile.setText(chosenDir);
                    }
                }
        );
        //You can change the default filename using the public variable "Default_File_Name"
        fileOpenDialog.default_file_name = editFile.getText().toString();
        fileOpenDialog.chooseFile_or_Dir(fileOpenDialog.default_file_name);
    }

}

