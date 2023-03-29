package com.example.shivam;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShivamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShivamFragment extends Fragment {

    RecyclerView rvCards;
    ArrayList<Card> cards;
    CardAdapter cardAdapter;
    AppCompatButton addCard;

    public ShivamFragment() {
        // Required empty public constructor
    }

    public static ShivamFragment newInstance(String param1, String param2) {
        ShivamFragment fragment = new ShivamFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cards = new ArrayList<>();
//        cards.add(new Card("xxxx xxxx 2532", 123));
//        cards.add(new Card("xxxx xxxx 3223", 123));
//        cards.add(new Card("xxxx xxxx 3432", 123));
//        cards.add(new Card("xxxx xxxx 8675", 123));

        cardAdapter = new CardAdapter(cards);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView =  inflater.inflate(R.layout.fragment_shivam, container, false);

        rvCards = fragmentView.findViewById(R.id.rvCards);
        addCard = fragmentView.findViewById(R.id.btnAddCard);

        addCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddCardBottomSheet addCardBottomSheet = new AddCardBottomSheet(new AddCardInterface() {
                    @Override
                    public void addNewCard(Card card) {
                        cards.add(card);
                        cardAdapter.notifyDataSetChanged();
                    }
                });

                addCardBottomSheet.show(getParentFragmentManager(), "Add New Credit Card");
                addCardBottomSheet.setCancelable(true);
            }
        });

        rvCards.setLayoutManager(new LinearLayoutManager(getContext()));
        rvCards.setAdapter(cardAdapter);

        return fragmentView;
    }
}