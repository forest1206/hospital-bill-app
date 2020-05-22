package com.mends4112.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.mends4112.MainActivity;
import com.mends4112.R;
import com.mends4112.model.HospitalCharge;

public class FragmentService extends Fragment {

    private EditText editDays;
    private EditText editMedication;
    private EditText editSurgical;
    private EditText editLab;
    private EditText editRehab;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        return inflater.inflate(R.layout.fragment_service_input, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        editDays = (EditText) view.findViewById(R.id.days_input);
        editMedication = (EditText) view.findViewById(R.id.medication_input);
        editSurgical = (EditText) view.findViewById(R.id.surgical_input);
        editLab = (EditText) view.findViewById(R.id.lab_input);
        editRehab = (EditText) view.findViewById(R.id.rehab_input);

        ((Button) view.findViewById(R.id.next_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    int medication = Integer.parseInt(editMedication.getText().toString());
                    int days = Integer.parseInt(editDays.getText().toString());
                    int surgical = Integer.parseInt(editSurgical.getText().toString());
                    int lab = Integer.parseInt(editLab.getText().toString());
                    int rehab = Integer.parseInt(editRehab.getText().toString());

                    final MainActivity activity = (MainActivity) getActivity();
                    activity.setHospitalCharge(new HospitalCharge(days, medication, surgical, lab, rehab));
                    Navigation.findNavController(v).navigate(R.id.summary);
                }else {
                    Toast.makeText(getActivity(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                };

            }
        });
    }

    public boolean validateInputs(){
        if (isEmpty(editDays) || isEmpty(editMedication) || isEmpty(editSurgical) || isEmpty(editRehab)){
            return false;
        }
        return true;
    }

    public boolean isEmpty(EditText editText){
        return editText.getText().toString().trim().length() == 0;
    }

}
