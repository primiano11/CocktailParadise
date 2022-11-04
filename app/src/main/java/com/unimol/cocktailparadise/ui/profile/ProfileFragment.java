package com.unimol.cocktailparadise.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.activities.MainActivity;
import com.unimol.cocktailparadise.activities.UserDrinksActivity;
import com.unimol.cocktailparadise.util.Preferences;

public class ProfileFragment extends Fragment {

    private TextView userNameText;
    private TextView emailText;
    private TextView seeDrinks;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.userNameText = (TextView) getView().findViewById(R.id.userNameText);
        userNameText.setText(Preferences.getUsernameFromPreferences(getContext()));
        this.emailText = (TextView) getView().findViewById(R.id.emailText);
        emailText.setText(Preferences.getMailFromPreferences(getContext()));

        this.seeDrinks = (TextView) getView().findViewById(R.id.seeDrinks);

        this.seeDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), UserDrinksActivity.class));
            }
        });



    }
}