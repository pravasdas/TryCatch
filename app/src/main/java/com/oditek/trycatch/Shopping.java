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


public class Shopping extends Fragment {
    CardView cardView;
    RecyclerView mRecyclerView;
    List<Model> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_shopping, container, false);

        cardView = (CardView)view.findViewById(R.id.card_view);
        mRecyclerView= (RecyclerView)view.findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearLayoutManager);
        getData();
        return view;
    }

    private void

    getData()
    {
        ArrayList<Model> list=new ArrayList<>();

        Model s=new Model();
        s.setName("Adidas & NIKE");
        s.setDetails("Under 3999");
        s.setImage(R.drawable.shop_a);
        list.add(s);

        s=new Model();
        s.setName("Timex,Daniel & more");
        s.setDetails("Under 1999");
        s.setImage(R.drawable.shop_b);
        list.add(s);

        s=new Model();
        s.setName("Casseroles & more");
        s.setDetails("From 999");
        s.setImage(R.drawable.shop_c);
        list.add(s);

        s=new Model();
        s.setName("fans");
        s.setDetails("From 799");
        s.setImage(R.drawable.shop_d);
        list.add(s);

        CustomAdapter customAdapter = new CustomAdapter(getActivity(), list);
        mRecyclerView.setAdapter(customAdapter);

    }
}
