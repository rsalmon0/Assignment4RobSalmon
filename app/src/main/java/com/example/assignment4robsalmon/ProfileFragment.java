package com.example.assignment4robsalmon;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignment4robsalmon.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {
    public static final String ARG_PARAM_PROFILE = "ARG_PARAM_PROFILE";
    private Profile mProfile;

    TextView feelingLabel;
    ImageView image;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance(Profile profile) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM_PROFILE, profile);
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null){
            mProfile = (Profile) getArguments().getSerializable(ARG_PARAM_PROFILE);
        }

    }

    FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Profile");


        feelingLabel = binding.feelingLabel;
        image = binding.imageView2;

        binding.userName.setText(mProfile.getName());
        binding.userAge.setText(mProfile.getAge());
        binding.feelingRating.setText(mProfile.getMoodNum() + " of 4");


        if(mProfile.getMoodNum().equals("0 out of 4")){
            feelingLabel.setText("Not Well");
            binding.imageView2.setImageResource(R.drawable.not_well);
        } else if(mProfile.getMoodNum().equals("1 out of 4")){
            feelingLabel.setText("Sad");
            binding.imageView2.setImageResource(R.drawable.sad);
        } else if(mProfile.getMoodNum().equals("2 out of 4")){
            feelingLabel.setText("Ok");
            binding.imageView2.setImageResource(R.drawable.ok);
        } else if(mProfile.getMoodNum().equals("3 out of 4")){
            feelingLabel.setText("Good");
            binding.imageView2.setImageResource(R.drawable.good);
        } else if(mProfile.getMoodNum().equals("4 out of 4")){
            feelingLabel.setText("Very Good");
            binding.imageView2.setImageResource(R.drawable.very_good);
        }

        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.cancelProfile();
            }
        });
    }

    ProfileFragmentListener mListener;

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ProfileFragment.ProfileFragmentListener) context;
    }

    interface ProfileFragmentListener{
        void cancelProfile();
    }
}