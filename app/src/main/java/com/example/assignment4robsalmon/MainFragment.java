package com.example.assignment4robsalmon;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment4robsalmon.databinding.FragmentMainBinding;
import com.google.android.material.textfield.TextInputEditText;


public class MainFragment extends Fragment {

    int feelingNum = -1;

    int moodNum;
    ImageView feelingsFace;
    TextView rating;
    String userNameText;
    String userAgeText;
    String moodText;



    public void setMood(int mood){

        Log.d("demo", "mood Set");
        this.feelingNum = mood;
    }

    public MainFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    FragmentMainBinding binding;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false);


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Main");
        binding.buttonTellUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.goToMood();
            }
        });

        if(feelingNum == -1){
            //binding.rating.setText(String.valueOf(feelingNum));
        }
        else{
            binding.rating.setText(String.valueOf(feelingNum));
        }

        if (feelingNum == 0) {
            binding.imageView3.setImageResource(R.drawable.not_well);
            binding.rating.setText("0 out of 4");
        } else if (feelingNum == 1) {
            binding.imageView3.setImageResource(R.drawable.sad);
            binding.rating.setText("1 out of 4");
        } else if (feelingNum == 2) {
            binding.imageView3.setImageResource(R.drawable.ok);
            binding.rating.setText("2 out of 4");
        } else if (feelingNum == 3) {
            binding.imageView3.setImageResource(R.drawable.good);
            binding.rating.setText("3 out of 4");
        } else if (feelingNum == 4) {
            binding.imageView3.setImageResource(R.drawable.very_good);
            binding.rating.setText("4 out of 4");
        }

        TextInputEditText userName = binding.editText;
        TextInputEditText userAge = binding.editText2;
        TextView rating = binding.rating;

        binding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNameText = userName.getText().toString();
                userAgeText = userAge.getText().toString();
                moodText = rating.getText().toString();
                if (!userNameText.isEmpty() && !userAgeText.isEmpty() && !moodText.isEmpty()) {
                    Profile profile = new Profile(userNameText, userAgeText, moodText);
                    mListener.goToProfile(profile);
                } else if (userNameText.isEmpty() && !userAgeText.isEmpty() && !moodText.isEmpty()){
                    Toast.makeText(getActivity(), "Please enter an input for name.",Toast.LENGTH_SHORT).show();
                } else if (!userNameText.isEmpty() && userAgeText.isEmpty() && !moodText.isEmpty()){
                    Toast.makeText(getActivity(), "Please enter an input for age.",Toast.LENGTH_SHORT).show();
                } else if (!userNameText.isEmpty() && !userAgeText.isEmpty() && moodText.isEmpty()) {
                    Toast.makeText(getActivity(), "Please select your mood.",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Multiple fields are missing inputs.",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    MainFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (MainFragmentListener) context;
    }

    interface MainFragmentListener{
        void goToMood();
        void goToProfile(Profile profile);
    }
}