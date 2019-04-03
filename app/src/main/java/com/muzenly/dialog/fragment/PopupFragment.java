package com.muzenly.dialog.fragment;


import android.app.DialogFragment;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muzenly.dialog.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopupFragment extends DialogFragment {

    private int screenWidth, screenHeight;
    private float density;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
        density = displayMetrics.density;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_popup, container, false);

        TextView tvDesignation = view.findViewById(R.id.tvDesignation);
        Spannable wordtoSpan = new SpannableString(tvDesignation.getText());
        wordtoSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.shadeColor)), 10, 19, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvDesignation.setText(wordtoSpan);

        TextView tvTwit = view.findViewById(R.id.tvTwit);
        wordtoSpan = new SpannableString(tvTwit.getText());
        wordtoSpan.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.shadeColor)), 2, 14, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvTwit.setText(wordtoSpan);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = (int) (screenWidth - 15 * density);
        params.height = (int) (screenHeight - 150 * density);
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }
}
