package com.example.travelapp.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.GridLayout;

import com.example.travelapp.AdapterHomeGrid;
import com.example.travelapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RecyclerView datalist;
    List<String> titles;
    List<Integer> images;

    AdapterHomeGrid adapterHomeGrid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        datalist = view.findViewById(R.id.datalist);

        addTitle();
        addImage();

        adapterHomeGrid = new AdapterHomeGrid(titles, images, getActivity());
        datalist.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        datalist.setAdapter(adapterHomeGrid);

        return view;
    }

    private void addTitle() {
        titles = new ArrayList<>();

        titles.add("Dwarka");
        titles.add("Indraprasth");
        titles.add("Nalanda University");
        titles.add("Taxila University");
        titles.add("Shivneri Fort");
        titles.add("Raigadh Fort");

    }

    private void addImage() {
        images = new ArrayList<>();

        images.add(R.drawable.dwarka);
        images.add(R.drawable.indraprasth);
        images.add(R.drawable.nalanda_university);
        images.add(R.drawable.taxila);
        images.add(R.drawable.shivneri_fort);
        images.add(R.drawable.raigadh_fort);


    }


}