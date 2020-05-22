package com.mends4112.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mends4112.MainActivity;
import com.mends4112.R;

public class FragmentSummary extends Fragment {
    private TextView viewReport;
    private EditText editDays;
    private EditText editMedication;
    private EditText editSurgical;
    private EditText editLab;
    private EditText editRehab;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        return inflater.inflate(R.layout.fragment_summary, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        viewReport = (TextView) view.findViewById(R.id.view_report);
        editDays = (EditText) view.findViewById(R.id.days_input);
        editMedication = (EditText) view.findViewById(R.id.medication_input);
        editSurgical = (EditText) view.findViewById(R.id.surgical_input);
        editLab = (EditText) view.findViewById(R.id.lab_input);
        editRehab = (EditText) view.findViewById(R.id.rehab_input);

        final MainActivity activity = (MainActivity) getActivity();
        viewReport.setText(activity.getReport());

        ((Button) view.findViewById(R.id.calculate_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewReport.getText().toString().matches("")){
                    viewReport.setText(activity.getReport());
                }
            }
        });

        ((Button) view.findViewById(R.id.clear_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewReport.setText("");
            }
        });

        ((Button) view.findViewById(R.id.send_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.sendEmail();
            }
        });
    }

}
