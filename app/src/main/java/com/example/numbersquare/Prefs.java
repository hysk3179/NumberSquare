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

    /**
     * Handles item selection in the options menu. Specifically, handles the back button on the toolbar.
     *
     * @param item the selected menu item
     * @return true if the event was handled, false otherwise
     */
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
    /**
     * Initializes the activity. Sets the content view and adds the SettingsFragment
     * if it's the first creation. Also enables the home button in the action bar.
     *
     * @param savedInstanceState the state of the activity, null if the activity is being created for the first time
     */
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
    /**
     * Retrieves the music preference value from shared preferences.
     *
     * @param c the context used to get the default shared preferences
     * @return true if the music preference is enabled, false otherwise. Default is true.
     */
    public static boolean getMusicPref(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("MUSIC_PREF", true);
    }
    /**
     * Retrieves the speed preference.
     *
     * @param c the context
     * @return the speed value as an integer
     */
    public static int getSpeedPref(Context c) {
        String raito = PreferenceManager.getDefaultSharedPreferences(c).getString("SPEED_PREF", "1");
        return Integer.parseInt(raito);
    }

    /**
     * Retrieves the number preference.
     *
     * @param c the context
     * @return the number value as an integer
     */
    public static int getNumberPref(Context c) {
        String raito = PreferenceManager.getDefaultSharedPreferences(c).getString("NUMBER_PREF", "5");
        return Integer.parseInt(raito);
    }

    /**
     * Retrieves the music track change preference.
     *
     * @param c the context
     * @return true if music track change is enabled, false otherwise
     */
    public static boolean getMusicTrackPref(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("Music_change", true);
    }

    public static boolean getModePref(Context c) {
        return PreferenceManager.getDefaultSharedPreferences(c).getBoolean("Mode_change", true );
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

            var musicCheck = new SwitchPreference(context);
            musicCheck.setTitle("Simple switch to change the game music");
            musicCheck.setSummaryOn("Background music will be boxstep.ogg");
            musicCheck.setSummaryOff("Background music will be space_jazz.mp3");
            musicCheck.setDefaultValue(true);
            musicCheck.setKey("Music_change");
            screen.addPreference(musicCheck);

            var modeCheck = new SwitchPreference(context);
            modeCheck.setTitle("Simple switch to change the game mode");
            modeCheck.setSummaryOn("Number mode");
            modeCheck.setSummaryOff("String mode");
            modeCheck.setDefaultValue(true);
            modeCheck.setKey("Mode_change");
            screen.addPreference(modeCheck);

            ListPreference squareSpeed = new ListPreference(context);
            String[] entries = {"Slow : 1 ", "Medium : 2 ", "Fast : 3"};
            String[] entryValues = {"1", "2", "3"};
            squareSpeed.setEntries(entries);
            squareSpeed.setEntryValues(entryValues);
            squareSpeed.setTitle("Dancing Speed");
            squareSpeed.setSummary("How fast should the square?");
            squareSpeed.setKey("SPEED_PREF");

            ListPreference numberSquares = new ListPreference(context);
            String[] number = {"square : 5", "square : 7", "square : 9"};
            String[] numberValues = {"5", "7", "9"};
            numberSquares.setEntries(number);
            numberSquares.setEntryValues(numberValues);
            numberSquares.setTitle("Number of squares");
            numberSquares.setSummary("How many squares should be displayed?");
            numberSquares.setKey("NUMBER_PREF");

            screen.addPreference(numberSquares);
            screen.addPreference(squareSpeed);
            setPreferenceScreen(screen);
        }
    }
}