package com.oditek.trycatch;


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


public class Event extends Fragment {
    CardView cardView;
    RecyclerView mRecyclerView;
    List<Model> list = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;



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
        View view=inflater.inflate(R.layout.fragment_event, container, false);

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
        s.setName("GC Lawns");
        s.setDetails("Banquet Halls");
        s.setImage(R.drawable.even_a);
        list.add(s);

        s=new Model();
        s.setName("Paradise Catering");
        s.setDetails("Caterers");
        s.setImage(R.drawable.even_b);
        list.add(s);

        s=new Model();
        s.setName("DJ Height");
        s.setDetails("DJ on Hire");
        s.setImage(R.drawable.even_c);
        list.add(s);

        s=new Model();
        s.setName("Sony Vision");
        s.setDetails("Photographers");
        s.setImage(R.drawable.even_d);
        list.add(s);


        CustomAdapter customAdapter = new CustomAdapter(getActivity(), list);
        mRecyclerView.setAdapter(customAdapter);

    }
}
