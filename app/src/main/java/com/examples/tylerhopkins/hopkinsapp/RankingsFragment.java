package com.examples.tylerhopkins.hopkinsapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


/**
 * A simple {@link Fragment} subclass.
 */
public class RankingsFragment extends Fragment {
    private  ListView rankedList;
    private MainActivity mainActivity;

    public RankingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rankings, container, false);

        rankedList = (ListView) view.findViewById(R.id.ranked_list);

        mainActivity = (MainActivity) this.getActivity();

        final RankingAdapter adapter = new RankingAdapter(this.getActivity(), this.getRankings());
        rankedList.setAdapter(adapter);

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        RankingAdapter adapter = new RankingAdapter(this.getActivity(), this.getRankings());
        rankedList.setAdapter(adapter);
    }

    public ArrayList<Bulldog> getRankings()
    {
        ArrayList<Bulldog> theDogs = new ArrayList<Bulldog>(mainActivity.realm.where(Bulldog.class).findAll());

        Collections.sort(theDogs, new Comparator<Bulldog>()
        {
            @Override
            public int compare(Bulldog dog, Bulldog dogie)
            {
                return ((Double) dog.getVotes().average("rating")).compareTo((Double) dogie.getVotes().average("rating"));
            }
        });
        return theDogs;
    }

}
