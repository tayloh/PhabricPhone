package com.haptx.app;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WoodFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WoodFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private VibrationMaterial mVibrationMaterial;
    private ImageButton mMaterialSurface;

    public WoodFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WoodFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WoodFragment newInstance(String param1, String param2) {
        WoodFragment fragment = new WoodFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_wood, container, false);

        Vibrator vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        mVibrationMaterial = new VibrationMaterial(
                0, 120,
                vibrator, this.getContext(), R.raw.tra3);

        mVibrationMaterial.enableLineCollider();
        mVibrationMaterial.disableDistanceBasedVibrations();

        // Need to match these to image
        mVibrationMaterial.addLineCollider(100, (long) 100);
        mVibrationMaterial.addLineCollider(150, (long) 100);
        mVibrationMaterial.addLineCollider(250, (long) 100);
        mVibrationMaterial.addLineCollider(350, (long) 100);
        mVibrationMaterial.addLineCollider(450, (long) 100);
        mVibrationMaterial.addLineCollider(600, (long) 100); // 60
        mVibrationMaterial.addLineCollider(750, (long) 180); // 120
        mVibrationMaterial.addLineCollider(1300, (long) 180); // 120
        mVibrationMaterial.addLineCollider(1500, (long) 120); // 100
        mVibrationMaterial.addLineCollider(1650, (long) 100); // 60
        mVibrationMaterial.addLineCollider(1750, (long) 100); // 60
        mVibrationMaterial.addLineCollider(1850, (long) 100); // 60
        mVibrationMaterial.addLineCollider(1950, (long) 100); // 60

        mMaterialSurface = (ImageButton) rootView.findViewById(R.id.textile_wood);
        mMaterialSurface.setOnTouchListener(mVibrationMaterial.getOnTouchVibrator());

        return rootView;
    }
}