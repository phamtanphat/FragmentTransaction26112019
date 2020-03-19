package com.example.fragmenttransaction26112019;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends Fragment {

    FrameLayout frameLayout;
    View view;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("BBB","Join main");
    }

    public AndroidFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_android, container, false);
        frameLayout = view.findViewById(R.id.frameLayout);
        frameLayout.setBackgroundColor(Color.rgb(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(256)));
        Log.d("BBB","onCreate View");
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("BBB","onDestroy View");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("BBB","out main");
    }
}
