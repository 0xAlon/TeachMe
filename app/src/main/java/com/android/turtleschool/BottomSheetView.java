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

public class BottomSheetView extends LinearLayout {

    @BindView(R.id.etSearch)
    TextInputEditText etSearch;
    @BindView(R.id.lvList)
    ListView lvList;
    private ArrayList<String> originalList, filteredList;

    public BottomSheetView(Context context) {
        super(context);
        inflate(context, R.layout.view_button_sheet, this);
        ButterKnife.bind(this);
        initList();
        intiSearch();
    }

    private void intiSearch() {

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

    private void initList() {
        originalList = new ArrayList<>();
        originalList.add("Alon");
        originalList.add("Alon1");
        originalList.add("Alon2");
        originalList.add("Alon3");
        originalList.add("Refeal");
        originalList.add("Refeal1");
        originalList.add("Refeal3");
        originalList.add("Refeal2");
        originalList.add("Inna");
        originalList.add("Assaf");
        originalList.add("Dan");
        originalList.add("Ilan");
        originalList.add("Daviv");
        originalList.add("Piter");
        originalList.add("Josh");
    }
}
