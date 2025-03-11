package com.example.numbersquare;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;
import androidx.preference.PreferenceScreen;
import androidx.preference.SwitchPreference;

public class Prefs extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle the back button on the toolbar
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.settings, new SettingsFragment())
                    .commit();
        }
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    public static boolean getMusicPref(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("MUSIC_PREF", true);
    }

    public static int getSpeedPref(Context c) {
        String raito = PreferenceManager.getDefaultSharedPreferences(c).getString("SPEED_PREF", "10");
        return Integer.parseInt(raito);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle b, String s) {
            Context context = getPreferenceManager().getContext();
            PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);

            var musicPref = new SwitchPreference(context);
            musicPref.setTitle("Play Background Music");
            musicPref.setSummaryOn("Background music will play");
            musicPref.setSummaryOff("Background music will not play");
            musicPref.setDefaultValue(true);
            musicPref.setKey("MUSIC_PREF");
            screen.addPreference(musicPref);


            ListPreference duckSpeed = new ListPreference(context);
            String[] entries = {"Fast : 1.6 ", "Medium : 1.3 ", "Slow : 1.0"};
            String[] entryValues = {"1.6", "1.3", "1.0"};
            duckSpeed.setEntries(entries);
            duckSpeed.setEntryValues(entryValues);
            duckSpeed.setTitle("Dancing Speed");
            duckSpeed.setSummary("How fast should the ducks dance?");
            //duckSpeed.setDefaultValue("10");
            duckSpeed.setKey("SPEED_PREF");

            screen.addPreference(duckSpeed);
            setPreferenceScreen(screen);
        }
    }
}