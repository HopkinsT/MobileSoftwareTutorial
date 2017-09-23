package com.examples.tylerhopkins.hopkinsapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RankingsFragment extends Fragment {
    private  ListView rankedList;

    public RankingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rankings, container, false);

        rankedList = (ListView) view.findViewById(R.id.ranked_list);

        MainActivity mainActivity = (MainActivity) this.getActivity();

        final BulldogArrayAdapter adapter = new BulldogArrayAdapter(this.getActivity(), mainActivity.realm.where(Bulldog.class).findAll());
        rankedList.setAdapter(adapter);

        return view;
    }

}
