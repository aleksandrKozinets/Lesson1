package com.example.Lesson1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NameFragment extends Fragment {
    public static final String ARG_PLANET_NUMBER = "planet_number";
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
        return inflater.inflate(R.layout.name_fragment, container, false);

    }


}