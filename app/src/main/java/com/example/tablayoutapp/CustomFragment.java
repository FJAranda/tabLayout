package com.example.tablayoutapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by usuario on 13/12/17.
 */

public class CustomFragment extends Fragment {
    private TextView tvMensaje;
    public static String KEY_MENSAJE = "mensaje";

    public static CustomFragment newInstance(Bundle arguments){
        CustomFragment customFragment = new CustomFragment();
        if (arguments != null){
            customFragment.setArguments(arguments);
        }
        return customFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        tvMensaje = view.findViewById(R.id.tvMensaje);
        tvMensaje.setText(getArguments().getString(KEY_MENSAJE));

        return view;
    }
}
