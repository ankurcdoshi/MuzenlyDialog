package com.muzenly.dialog.activity;

import android.app.Activity;
import android.os.Bundle;

import com.muzenly.dialog.R;
import com.muzenly.dialog.fragment.PopupFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayPopup();
    }

    private void displayPopup() {
        PopupFragment popupFragment = new PopupFragment();
        popupFragment.show(getFragmentManager(), PopupFragment.class.getSimpleName());
    }
}
