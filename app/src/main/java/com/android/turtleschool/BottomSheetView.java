package com.android.turtleschool;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BottomSheetView extends LinearLayout {

    @BindView(R.id.etSearch)
    TextInputEditText etSearch;
    @BindView(R.id.lvList)
    ListView lvList;
    private ArrayList<String> filteredList;
    private MainActivity.CloseListener closeListener;

    public BottomSheetView(Context context, ArrayList<String> originalList) {
        super(context);
        inflate(context, R.layout.view_button_sheet, this);
        ButterKnife.bind(this);
        intiSearch(originalList);
    }

    private void intiSearch(ArrayList<String> originalList) {

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (count == 0) {
                    lvList.setVisibility(INVISIBLE);
                } else {
                    lvList.setVisibility(VISIBLE);
                    filteredList = new ArrayList<>();
                    for (String value : originalList) {
                        if (value.startsWith(s.toString())) {
                            filteredList.add(value);
                        }
                    }

                    lvList.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, filteredList));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick(R.id.ibClose)
    public void close() {
        if (closeListener != null) {
            closeListener.onCloseClicked();
        }
    }

    public void setCloseListener(MainActivity.CloseListener closeListener) {
        this.closeListener = closeListener;
    }
}
