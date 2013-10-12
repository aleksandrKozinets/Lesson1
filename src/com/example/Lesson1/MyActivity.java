package com.example.Lesson1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


import android.view.View;
import android.widget.TextView;

public class MyActivity extends FragmentActivity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Fragment nameFragment = new NameFragment();
        Fragment ageFragment2 = new AgeFragment();
        Fragment resultFragment3 = new ResutlFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.name_fragment, nameFragment);

        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.age_fragment, ageFragment2);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        fragmentTransaction = getSupportFragmentManager().beginTransaction()
                .replace(R.id.result_fragment, resultFragment3);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void onClick(View view) {
        TextView textViewResultForNameOrAge;
        TextView textViewInputFieldForNameOrAGe;

        TextView textViewNameResult;
        TextView textViewAgeResult;

        switch (view.getId()){
            case R.id.ageButton:   {
                textViewResultForNameOrAge = (TextView) findViewById(R.id.ageView);
                textViewInputFieldForNameOrAGe = (TextView) findViewById(R.id.editAge);
                textViewResultForNameOrAge.setText(textViewInputFieldForNameOrAGe.getText());
                break;
            }
            case R.id.nameButton:   {
                textViewResultForNameOrAge = (TextView) findViewById(R.id.nameView);
                textViewInputFieldForNameOrAGe = (TextView) findViewById(R.id.editName);
                textViewResultForNameOrAge.setText(textViewInputFieldForNameOrAGe.getText());
                break;
            }
            case R.id.resultButton:   {
                textViewResultForNameOrAge = (TextView) findViewById(R.id.resultView);
                textViewAgeResult = (TextView) findViewById(R.id.ageView);
                textViewNameResult = (TextView) findViewById(R.id.nameView);
                textViewResultForNameOrAge.setText("Hello! Your name is " + textViewNameResult.getText() + " and your age is " + textViewAgeResult.getText());
                break;
            }

        }

    }


}
