package com.unimol.cocktailparadise.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Preferences {
    private static final String PREFERENCE_NAME = "UserInfo";

    public static void savePreferences(Context context, String mail, String password, int userId, String username) {
        SharedPreferences  sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("mail", mail);
        editor.putString("password", password);
        editor.putInt("userId", userId);
        editor.putString("username", username);
        editor.apply();
    }


    public static String getUsernameFromPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("username", " ");
    }

    public static String getMailFromPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("mail", " ");
    }

    public static int getUserIdFromPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getInt("userId", 0);
    }

    public static void clearPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
