package com.coolab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrationFragment extends Fragment {

    EditText uname , email , phone , pass;
    Button submit;
    DatabaseReference mDatabase;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistrationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootView =  inflater.inflate(R.layout.fragment_registration, container, false);


        uname = rootView.findViewById(R.id.editTextUsername);
        email = rootView.findViewById(R.id.editTextEmail);
        phone = rootView.findViewById(R.id.editTextPhone);
        pass = rootView.findViewById(R.id.editTextPassword);
        submit = rootView.findViewById(R.id.buttonSubmit);

        mDatabase = FirebaseDatabase.getInstance().getReference("Users");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addUser();

            }
        });






        return rootView;
    }


    private void addUser(){

        String username,emailId,phoneNo,password;

        username = uname.getText().toString().trim();
        emailId = email.getText().toString().trim();
        phoneNo = phone.getText().toString().trim();
        password = pass.getText().toString().trim();

        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(emailId) || TextUtils.isEmpty(phoneNo) || TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(),"Kindly fill all the details!",Toast.LENGTH_SHORT).show();
        }


    }
}