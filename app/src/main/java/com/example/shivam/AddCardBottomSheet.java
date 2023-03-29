package com.example.shivam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class AddCardBottomSheet extends BottomSheetDialogFragment {

    AddCardInterface addCardInterface;

    EditText cardNumber, cardCvv;
    Button done;

    public AddCardBottomSheet(AddCardInterface addCardInterface){
        this.addCardInterface = addCardInterface;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.card_bottom_sheet,
                container, false);

        cardNumber = v.findViewById(R.id.etCardNumber);
        cardCvv = v.findViewById(R.id.etCvv);

        done = v.findViewById(R.id.btnDone);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cardNumber.getText().toString().length() == 12){
                    if(cardCvv.getText().toString().length() == 3){
                        addCardInterface.addNewCard(new Card(cardNumber.getText().toString(), Integer.parseInt(cardCvv.getText().toString())));
                        dismiss();
                    }else{
                        Toast.makeText(getContext(), "CVV invalid!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getContext(), "Card Number Invalid!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return v;
    }
}
