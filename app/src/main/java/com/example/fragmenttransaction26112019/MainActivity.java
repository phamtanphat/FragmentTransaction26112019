package com.example.fragmenttransaction26112019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
    }

    public void addAndroid(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.add(R.id.liearlayoutContainer,androidFragment,"AndroidFragment");
        fragmentTransaction.addToBackStack("StackAndroidFragment");
        fragmentTransaction.commit();
    }

    public void addIos(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.add(R.id.liearlayoutContainer,iosFragment , "IosFragment");
        fragmentTransaction.addToBackStack("StackIosFragment");
        fragmentTransaction.commit();
    }

    public void replaceAndroid(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AndroidFragment androidFragment = new AndroidFragment();
        fragmentTransaction.replace(R.id.liearlayoutContainer,androidFragment,"AndroidFragment");
        fragmentTransaction.commit();
    }

    public void replaceIos(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        IosFragment iosFragment = new IosFragment();
        fragmentTransaction.replace(R.id.liearlayoutContainer,iosFragment,"IosFragment");
        fragmentTransaction.commit();
    }

    public void removeAndroid(View view) {
        AndroidFragment androidFragment = (AndroidFragment) fragmentManager.findFragmentByTag("AndroidFragment");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(androidFragment);
            fragmentTransaction.commit();
        }
    }

    public void removeIos(View view) {
        IosFragment iosFragment = (IosFragment) fragmentManager.findFragmentByTag("IosFragment");
        if (iosFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(iosFragment);
            fragmentTransaction.commit();
        }
    }

    public void popbackstack(View view) {
        //xoa het tat ca cac fragment stack android
//        fragmentManager.popBackStack("StackAndroidFragment",FragmentManager.POP_BACK_STACK_INCLUSIVE);
        // pop ve vi trong stack
//        fragmentManager.popBackStack(0,0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (fragmentManager.getBackStackEntryCount() <= 1 ){
            finish();
        }
    }

    public void Detach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) fragmentManager.findFragmentByTag("AndroidFragment");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(androidFragment);
            fragmentTransaction.commit();
        }
    }

    public void Attach(View view) {
        AndroidFragment androidFragment = (AndroidFragment) fragmentManager.findFragmentByTag("AndroidFragment");
        if (androidFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(androidFragment);
            fragmentTransaction.commit();
        }
    }
}
