package me.varunon9.sellmyservices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import me.varunon9.sellmyservices.constants.AppConstants;
import me.varunon9.sellmyservices.uifragments.AboutUsFragment;
import me.varunon9.sellmyservices.uifragments.LoginFragment;
import me.varunon9.sellmyservices.uifragments.SellerServicesFragment;
import me.varunon9.sellmyservices.uifragments.SignupFragment;

/**
 * This activity  displays various UI fragments when called from navigation drawer
 */
public class UiFragmentActivity extends AppCompatActivity {

    private static final String LOG = "UiFragmentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG, "onCreate called");
        setContentView(R.layout.activity_fragment);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // display back button in action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            int navigationLink = bundle.getInt(AppConstants.NAVIGATION_ITEM);
            Fragment fragment = getSelectedFragment(navigationLink);
            if (fragment != null) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                        .beginTransaction();
                fragmentTransaction.add(R.id.frameLayout, fragment);
                fragmentTransaction.commit();
            } else {
                Log.e(LOG, "Null Fragment to display");
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(LOG, "onResume called");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private Fragment getSelectedFragment(int id) {
        Fragment fragment = null;
        String title = "";
        if (id == R.id.nav_user_profile) {
            title = AppConstants.YOUR_PROFILE;
        } else if (id == R.id.nav_seller_services) {
            title = AppConstants.YOUR_SERVICES;
            fragment = new SellerServicesFragment();
        } else if (id == R.id.nav_user_login) {
            title = AppConstants.LOGIN;
            fragment = new LoginFragment();
        } else if (id == R.id.nav_user_signup) {
            title = AppConstants.SIGNUP;
            fragment = new SignupFragment();
        } else if (id == R.id.nav_about_us) {
            title = AppConstants.ABOUT_US;
            fragment = new AboutUsFragment();
        }
        updateActionBarTitle(title);
        return fragment;
    }

    private void updateActionBarTitle(String title) {
        if (title != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    // calling from XML
    public void goToSignupAsSellerFragment(View view) {
        Fragment fragment = new SignupFragment();
        String title = AppConstants.SIGNUP;
        updateActionBarTitle(title);
        replaceOldFragment(fragment);
    }

    public void goToLoginAsSellerFragment(View view) {
        Fragment fragment = new LoginFragment();
        String title = AppConstants.LOGIN;
        updateActionBarTitle(title);
        replaceOldFragment(fragment);
    }

    private void replaceOldFragment(Fragment newFragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, newFragment);
        fragmentTransaction.commit();
    }

}
