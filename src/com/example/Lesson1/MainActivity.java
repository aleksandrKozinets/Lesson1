package com.example.Lesson1;


import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;


import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;

import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence name = "";
    private CharSequence age = "";
    private FragmentTransaction fragmentTransaction;
    private Fragment nameFragment;
    private Fragment ageFragment;
    private Fragment resultFragment;
    private Fragment animationFragment;
    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private TextView helloWorld;
    private Animation animation;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mPlanetTitles = getResources().getStringArray(R.array.planets_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));

        mDrawerToggle = (new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.ic_drawer,
                R.string.open_drawer,
                R.string.close_drawer
        ) {
            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View drawerView) {
            }
        });
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        if (savedInstanceState == null) {
            nameFragment = new NameFragment();
            ageFragment = new AgeFragment();
            resultFragment = new ResutlFragment();
            animationFragment = new AnimationFragment();

            fragmentTransaction = getSupportFragmentManager().beginTransaction();

            fragmentTransaction.add(R.id.content_frame, nameFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        // Saving variables
        savedInstanceState.putCharSequence("age", age);
        savedInstanceState.putCharSequence("name", name);

        // Call at the end
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        // Call at the start
        super.onRestoreInstanceState(savedInstanceState);

        // Retrieve variables
        age = savedInstanceState.getCharSequence("age");
        name = savedInstanceState.getCharSequence("name");

    }

    public void onClick(View view) {
        TextView textViewResultForNameOrAge;
        TextView textViewInputFieldForNameOrAge;

        switch (view.getId()) {
            case R.id.age_button: {
                textViewResultForNameOrAge = (TextView) findViewById(R.id.age_view);
                textViewInputFieldForNameOrAge = (TextView) findViewById(R.id.edit_age);
                age = textViewInputFieldForNameOrAge.getText();
                textViewResultForNameOrAge.setText(age);
                break;
            }
            case R.id.name_button: {
                textViewResultForNameOrAge = (TextView) findViewById(R.id.name_view);
                textViewInputFieldForNameOrAge = (TextView) findViewById(R.id.edit_name);
                name = textViewInputFieldForNameOrAge.getText();
                textViewResultForNameOrAge.setText(name);
                break;
            }
            case R.id.view_result_button: {
                textViewResultForNameOrAge = (TextView) findViewById(R.id.result_view);
                textViewResultForNameOrAge.setText("Hello! Your name is " + name + ". Your age is " + age);
                break;
            }
            case R.id.next_button1: {
                ageFragment = new AgeFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, ageFragment);
                fragmentTransaction.commit();
                break;
            }
            case R.id.next_button2: {
                resultFragment = new ResutlFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, resultFragment);
                fragmentTransaction.commit();
                break;
            }
        }
    }


    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            selectItem(position);

        }
    }

    private void selectItem(int position) {
        TextView textViewResultForNameOrAge;
        TextView textViewInputFieldForNameOrAge;
        switch (position) {
            case 0: {
                nameFragment = new NameFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, nameFragment);
                fragmentTransaction.commit();
                break;
            }
            case 1: {
                ageFragment = new AgeFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, ageFragment);
                fragmentTransaction.commit();
                break;
            }
            case 2: {
                resultFragment = new ResutlFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, resultFragment);
                fragmentTransaction.commit();
                break;
            }
            case 3: {
                animationFragment = new AnimationFragment();
                fragmentTransaction = getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_frame, animationFragment);
                fragmentTransaction.commit();
                break;
            }
        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    public void startAnimation4(View view) {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        helloWorld = (TextView) findViewById(R.id.animation4);
        helloWorld.setVisibility(1);
        helloWorld.startAnimation(animation);
    }

    public void startAnimation1(View view) {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        helloWorld = (TextView) findViewById(R.id.animation1);
        helloWorld.setVisibility(1);
        helloWorld.startAnimation(animation);
    }

    public void startAnimation2(View view) {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        helloWorld = (TextView) findViewById(R.id.animation2);
        helloWorld.setVisibility(1);
        helloWorld.startAnimation(animation);
    }

    public void startAnimation3(View view) {
        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        helloWorld = (TextView) findViewById(R.id.animation3);
        helloWorld.setVisibility(1);
        helloWorld.startAnimation(animation);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
