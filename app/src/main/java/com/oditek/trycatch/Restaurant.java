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


public class Restaurant extends Fragment {
    CardView cardView;
    RecyclerView mRecyclerView;
    List<Model> list = new ArrayList<>();

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public Restaurant() {
        // Required empty public constructor
    }


    public static Restaurant newInstance(String param1, String param2) {
        Restaurant fragment = new Restaurant();
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
        View view=inflater.inflate(R.layout.fragment_restaurant, container, false);

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
        s.setName("Cuisines");
        s.setDetails("Find your choice of cuisine");
        s.setImage(R.drawable.resttt_cuisines);
        list.add(s);

        s=new Model();
        s.setName("Home Delivery");
        s.setDetails("Never miss a meal");
        s.setImage(R.drawable.resttt_home);
        list.add(s);

        s=new Model();
        s.setName("Pure Veg");
        s.setDetails("Vegetarian delights");
        s.setImage(R.drawable.resttt_pure);
        list.add(s);

        s=new Model();
        s.setName("Cafes");
        s.setDetails("Spill the beans");
        s.setImage(R.drawable.resttt_book);
        list.add(s);

        s=new Model();
        s.setName("Desserts");
        s.setDetails("Satiate your sweet cravings");
        s.setImage(R.drawable.resttt_deserts);
        list.add(s);

        CustomAdapter customAdapter = new CustomAdapter(getActivity(), list);
        mRecyclerView.setAdapter(customAdapter);

    }



}
