package com.haptx.app;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeatherFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private VibrationMaterial mVibrationMaterial;
    private ImageButton mMaterialSurface;

    public LeatherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeatherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeatherFragment newInstance(String param1, String param2) {
        LeatherFragment fragment = new LeatherFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_leather, container, false);

        Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        mVibrationMaterial = new VibrationMaterial(
                VibrationMaterial.LEATHER_DISTANCE, VibrationMaterial.LEATHER_LENGTH,
                vibrator, this.getContext(), R.raw.leather);

        mMaterialSurface = (ImageButton) rootView.findViewById(R.id.textile_leather);
        mMaterialSurface.setOnTouchListener(mVibrationMaterial.getOnTouchVibrator());

        return rootView;
    }
}