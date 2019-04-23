package gif.ganesh.pushnotififirebase.fragmentTestings;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gif.ganesh.pushnotififirebase.R;

public class FirstActivity extends AppCompatActivity {

    ViewPagerAdapter adapter;
    ViewPager viewPager;
    int id,count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

         viewPager = (ViewPager) findViewById(R.id.kitty_party_home_screen_viewpager);
         adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new kittipartyinvitationfragment(), "Invitation");
        adapter.addFragment(new KittyPartyContacts(),"Contacts");
        adapter.addFragment(new KittyPartyContacts(),"Celebs");

        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.kitty_party_tabs_home_layout);
        tabLayout.setupWithViewPager(viewPager);
        getFragmentManager().beginTransaction();


        //code for getting the current fragment position
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                id=i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });




    }
    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager)
        {
            super(manager);
        }
        @Override
        public   Fragment getItem(int position)
        {
            return mFragmentList.get(position);
        }


        @Override
        public int getCount()
        {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title)
        {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }



        @Override
        public CharSequence getPageTitle(int position)
        {
            return mFragmentTitleList.get(position);
        }

        //code for displaying the fragment depending on the position
        public void setCurrentItem (int item, boolean smoothScroll) {
            viewPager.setCurrentItem(item, smoothScroll);
        }
    }



    @Override
    public void onBackPressed()
    {
        count++;

        if (count<=1)
        {
            adapter.setCurrentItem(0,true);

        }else
        {
            super.onBackPressed();
        }


    }
}
