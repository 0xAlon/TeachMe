package com.android.turtleschool.custom_views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.turtleschool.R;
import com.android.turtleschool.activities.MainActivity;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("ViewConstructor")
public class BottomSheetView extends LinearLayout {

    @BindView(R.id.tilSearch)
    TextInputLayout tilSearch;
    @BindView(R.id.etSearch)
    TextInputEditText etSearch;
    @BindView(R.id.lvList)
    ListView lvList;
    private ArrayList<String> filteredList;
    private MainActivity.OnCloseListener onCloseListener;
    private MainActivity.OnChoseValueListener onChoseValueListener;
    private String type;

    public BottomSheetView(Context context, ArrayList<String> originalList, String type) {
        super(context);
        inflate(context, R.layout.view_button_sheet, this);
        ButterKnife.bind(this);
        this.type = type;
        tilSearch.setHint(type.equalsIgnoreCase("subject") ? "הקלד את שם המקצוע" : "הקלד את שם התלמיד");
        boolean isSearchAbility = !type.equalsIgnoreCase("semester");
        if (isSearchAbility) {
            intiSearch(originalList);
        } else {
            tilSearch.setVisibility(GONE);
            lvList.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, originalList));
            lvList.setOnItemClickListener((parent, view, position, id) -> {
                if (onChoseValueListener != null) {
                    onChoseValueListener.onChoseValue(type, originalList.get(position));
                }
            });
        }
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
                    lvList.setOnItemClickListener((parent, view, position, id) -> {
                        if (onChoseValueListener != null) {
                            onChoseValueListener.onChoseValue(type, filteredList.get(position));
                        }
                    });
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick(R.id.llClose)
    public void close() {
        if (onCloseListener != null) {
            onCloseListener.onCloseClicked();
        }
    }

    public void setOnCloseListener(MainActivity.OnCloseListener onCloseListener) {
        this.onCloseListener = onCloseListener;
    }

    public void setOnChoseValueListener(MainActivity.OnChoseValueListener onChoseValueListener) {
        this.onChoseValueListener = onChoseValueListener;
    }
}
