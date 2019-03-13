package gif.ganesh.pushnotififirebase.bottomNavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import gif.ganesh.pushnotififirebase.R;

public class BottomNavigationActivities extends AppCompatActivity
{
    ActionBar toolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_activities);

        toolBar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_naig);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //toolBar.setTitle("Shop");
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.first:
                    toolBar.setTitle("Shop");
                    fragment = new StoreFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.second:
                    toolBar.setTitle("My Gifts");
//                    fragment = new GiftsFragment();
//                    loadFragment(fragment);
                    return true;
                case R.id.third:
                    toolBar.setTitle("Cart");
//                    fragment = new CartFragment();
//                    loadFragment(fragment);
                    return true;
                case R.id.fourth:
                    toolBar.setTitle("Profile");
//                    fragment = new ProfileFragment();
//                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
