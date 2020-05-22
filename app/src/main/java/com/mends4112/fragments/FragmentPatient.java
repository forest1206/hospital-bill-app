package com.mends4112.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.mends4112.MainActivity;
import com.mends4112.R;
import com.mends4112.model.Patient;

public class FragmentPatient extends Fragment {

    private EditText editName;
    private EditText editAddress;
    private EditText editAge;
    private RadioButton radioGender;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }
        return inflater.inflate(R.layout.fragment_patient_input, container, false);
    }

    @Override
    public void onViewCreated(final View view, final Bundle savedInstanceState){

        editName = (EditText) view.findViewById(R.id.name_input);
        editAddress = (EditText) view.findViewById(R.id.address_input);
        editAge = (EditText) view.findViewById(R.id.age_input);
        RadioGroup rg = (RadioGroup) view.findViewById(R.id.gender_input);
        radioGender = view.findViewById(rg.getCheckedRadioButtonId());

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                radioGender = (RadioButton) group.findViewById(checkedId);
            }
        });

        ((Button) view.findViewById(R.id.next_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String gender = radioGender.getText().toString();
                    String name = editName.getText().toString();
                    String address = editAddress.getText().toString();
                    int age = Integer.parseInt(editAge.getText().toString());
                    MainActivity activity = (MainActivity) getActivity();
                    if (activity != null) {
                        activity.setPatient(new Patient(name, address, age, gender));
                    }
                    Navigation.findNavController(v).navigate(R.id.service_input);
                }else {
                    Toast.makeText(getActivity(), "Please fill out all the fields", Toast.LENGTH_SHORT).show();
                };

            }
        });
    }

    public boolean validateInputs(){
        if (isEmpty(editName) || isEmpty(editAddress) || isEmpty(editAge)){
            return false;
        }
        return true;
    }

    public boolean isEmpty(EditText editText){
        return editText.getText().toString().trim().length() == 0;
    }
}
