package me.varunon9.sellmyservices.servicefragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.varunon9.sellmyservices.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceDetailsFragment extends Fragment {


    public ServiceDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_service_details, container, false);
    }

}
