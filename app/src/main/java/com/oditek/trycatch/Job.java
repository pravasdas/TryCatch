package com.oditek.trycatch;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class Job extends Fragment {
    CardView cardView;
    RecyclerView mRecyclerView;
    List<Model> list = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;



    public static Fashion newInstance(String param1, String param2) {
        Fashion fragment = new Fashion();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_job, container, false);

        cardView = (CardView)view.findViewById(R.id.card_view);
        mRecyclerView= (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        getData();
        return view;
    }

    private void getData()
    {
        ArrayList<Model> list=new ArrayList<>();

        Model s=new Model();
        s.setName("Android Developer");
        s.setDetails("Google");
        s.setImage(R.drawable.jobc);
        list.add(s);

        s=new Model();
        s.setName("C, C++ Developer");
        s.setDetails("Facebook");
        s.setImage(R.drawable.jobc);
        list.add(s);

        s=new Model();
        s.setName("Direct walk-in for programmer freshers");
        s.setDetails("Accenture");
        s.setImage(R.drawable.jobc);
        list.add(s);

        s=new Model();
        s.setName("Hiring for Email & Chat process");
        s.setDetails("BES Consultants");
        s.setImage(R.drawable.jobc);
        list.add(s);

        s=new Model();
        s.setName("front Office Executive");
        s.setDetails("KPS Commission");
        s.setImage(R.drawable.jobc);
        list.add(s);

        CustomAdapter customAdapter = new CustomAdapter(getActivity(), list);
        mRecyclerView.setAdapter(customAdapter);

    }


}
