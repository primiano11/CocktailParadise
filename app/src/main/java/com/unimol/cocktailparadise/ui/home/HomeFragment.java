package com.unimol.cocktailparadise.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.activities.ClassicDrinksActivity;
import com.unimol.cocktailparadise.activities.SearchPerformedActivity;

public class HomeFragment extends Fragment {

    private TextView iGrandiClassici;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.iGrandiClassici = (TextView) getView().findViewById(R.id.iGrandiClassiciView);

        iGrandiClassici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ClassicDrinksActivity.class));
            }
        });
    }
}