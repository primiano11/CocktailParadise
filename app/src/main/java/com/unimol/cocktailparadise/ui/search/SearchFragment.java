package com.unimol.cocktailparadise.ui.search;

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

import com.unimol.cocktailparadise.R;
import com.unimol.cocktailparadise.activities.MainActivity;
import com.unimol.cocktailparadise.activities.SearchPerformedActivity;

public class SearchFragment extends Fragment {


    private Button searchButton;
    private EditText searchBox;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.searchButton = (Button) getView().findViewById(R.id.searchButton);
        this.searchBox = (EditText) getView().findViewById(R.id.searchBox);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchPerformedActivity.class);
                intent.putExtra("strDrink", searchBox.getText().toString().trim());
                startActivity(intent);
            }
        });
    }
}