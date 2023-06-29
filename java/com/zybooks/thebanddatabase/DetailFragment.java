package com.zybooks.thebanddatabase;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {

    private Band mBand;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int bandId = 1;

        // Get the selected band
        mBand = BandRepository.getInstance(requireContext()).getBand(bandId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        if (mBand != null) {
            TextView nameTextView = rootView.findViewById(R.id.band_name);
            nameTextView.setText(mBand.getName());

            TextView descriptionTextView = rootView.findViewById(R.id.band_description);
            descriptionTextView.setText(mBand.getDescription());
        }

        return rootView;
    }
}