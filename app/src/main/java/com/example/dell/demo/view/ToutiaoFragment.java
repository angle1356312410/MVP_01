package com.example.dell.demo.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.demo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ToutiaoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_toutiao,null);
        return view;
    }

}
