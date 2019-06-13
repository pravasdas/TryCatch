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


public class Movie extends Fragment {
    CardView cardView;
    RecyclerView mRecyclerView;
    List<Model> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_movie, container, false);

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
        s.setName("Roy");
        s.setDetails("Hindi");
        s.setImage(R.drawable.mov_a);
        list.add(s);

        s=new Model();
        s.setName("P.K");
        s.setDetails("Hindi");
        s.setImage(R.drawable.mov_b);
        list.add(s);

        s=new Model();
        s.setName("THE SQUARE");
        s.setDetails("English");
        s.setImage(R.drawable.mov_c);
        list.add(s);

        s=new Model();
        s.setName("Captain Fantastic");
        s.setDetails("English");
        s.setImage(R.drawable.mov_d);
        list.add(s);

        s=new Model();
        s.setName("Champions");
        s.setDetails("English");
        s.setImage(R.drawable.mov_e);
        list.add(s);

        CustomAdapter customAdapter = new CustomAdapter(getActivity(), list);
        mRecyclerView.setAdapter(customAdapter);

    }



}
