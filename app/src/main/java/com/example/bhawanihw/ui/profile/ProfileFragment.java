package com.example.bhawanihw.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bhawanihw.R;
import com.example.bhawanihw.SharedPrefManager;
import com.example.bhawanihw.Model.User;

public class ProfileFragment extends Fragment {

    TextView textViewUsername, textViewEmail, textViewMobileno;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_profile, container, false);
        textViewUsername = (TextView) root.findViewById(R.id.username);
        textViewEmail = (TextView) root.findViewById(R.id.email);
        textViewMobileno = (TextView) root.findViewById(R.id.mobileno);


        //getting the current user
        User user = SharedPrefManager.getInstance(root.getContext()).getUser();

        //setting the values to the textviews
        textViewUsername.setText(user.getUsername());
        textViewEmail.setText(user.getEmail());
        textViewMobileno.setText(user.getMobileno());

        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Profile");
    }
}