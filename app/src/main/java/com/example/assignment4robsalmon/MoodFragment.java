package com.example.assignment4robsalmon;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.assignment4robsalmon.databinding.FragmentMoodBinding;


public class MoodFragment extends Fragment {


    int feelingNum = 0;


    public MoodFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    FragmentMoodBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        binding = FragmentMoodBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Select Mood");

        ImageView faces = binding.imageView4;
        TextView textViewProgress = binding.textViewFeelingNum;
        SeekBar seekBar = binding.seekBar;

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.d("seek", "onProgressChanged: " + i);
                feelingNum = i;
                textViewProgress.setText(String.valueOf(i));
                if(feelingNum == 0){
                    faces.setImageResource(R.drawable.not_well);
                } else if(feelingNum == 1) {
                    faces.setImageResource(R.drawable.sad);
                } else if(feelingNum == 2) {
                    faces.setImageResource(R.drawable.ok);
                } else if(feelingNum == 3) {
                    faces.setImageResource(R.drawable.good);
                } else if(feelingNum == 4) {
                    faces.setImageResource(R.drawable.very_good);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d("seek", "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d("seek", "onStopTrackingTouch: ");
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.cancelMood();
            }
        });

        binding.submitButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.sendMood(feelingNum);
            }
        });

    }

    MoodFragmentListener mListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (MoodFragmentListener) context;
    }

    interface MoodFragmentListener{
        void sendMood(int mood);
        void cancelMood();
    }
}