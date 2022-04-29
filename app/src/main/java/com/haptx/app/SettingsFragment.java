package com.haptx.app;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsFragment newInstance(String param1, String param2) {
        SettingsFragment fragment = new SettingsFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);
        
        // DENIM
        SeekBar denimDistance = rootView.findViewById(R.id.denim_distance);
        SeekBar denimLength = rootView.findViewById(R.id.denim_length);
        denimDistance.setProgress((int) VibrationMaterial.DENIM_DISTANCE);
        denimLength.setProgress((int) VibrationMaterial.DENIM_LENGTH);

        TextView denimDistanceText = rootView.findViewById(R.id.denim_distance_text);
        TextView denimLengthText = rootView.findViewById(R.id.denim_length_text);

        denimDistanceText.setText("Distance: " + VibrationMaterial.DENIM_DISTANCE + " px");
        denimLengthText.setText("Length: " + VibrationMaterial.DENIM_LENGTH + " ms");

        denimDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.DENIM_DISTANCE = progress;
                denimDistanceText.setText("Distance: " + VibrationMaterial.DENIM_DISTANCE + " px");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        denimLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.DENIM_LENGTH = progress;
                denimLengthText.setText("Length: " + VibrationMaterial.DENIM_LENGTH + " ms");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        // LEATHER
        SeekBar leatherDistance = rootView.findViewById(R.id.leather_distance);
        SeekBar leatherLength = rootView.findViewById(R.id.leather_length);
        leatherDistance.setProgress((int) VibrationMaterial.LEATHER_DISTANCE);
        leatherLength.setProgress((int) VibrationMaterial.LEATHER_LENGTH);

        TextView leatherDistanceText = rootView.findViewById(R.id.leather_distance_text);
        TextView leatherLengthText = rootView.findViewById(R.id.leather_length_text);

        leatherDistanceText.setText("Distance: " + VibrationMaterial.LEATHER_DISTANCE + " px");
        leatherLengthText.setText("Length: " + VibrationMaterial.LEATHER_LENGTH + " ms");

        leatherDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.LEATHER_DISTANCE = progress;
                leatherDistanceText.setText("Distance: " + VibrationMaterial.LEATHER_DISTANCE + " px");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        leatherLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.LEATHER_LENGTH = progress;
                leatherLengthText.setText("Length: " + VibrationMaterial.LEATHER_LENGTH + " ms");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        // SILK
        SeekBar silkDistance = rootView.findViewById(R.id.silk_distance);
        SeekBar silkLength = rootView.findViewById(R.id.silk_length);
        silkDistance.setProgress((int) VibrationMaterial.SILK_DISTANCE);
        silkLength.setProgress((int) VibrationMaterial.SILK_LENGTH);

        TextView silkDistanceText = rootView.findViewById(R.id.silk_distance_text);
        TextView silkLengthText = rootView.findViewById(R.id.silk_length_text);

        silkDistanceText.setText("Distance: " + VibrationMaterial.SILK_DISTANCE + " px");
        silkLengthText.setText("Length: " + VibrationMaterial.SILK_LENGTH + " ms");

        silkDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.SILK_DISTANCE = progress;
                silkDistanceText.setText("Distance: " + VibrationMaterial.SILK_DISTANCE + " px");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        silkLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.SILK_LENGTH = progress;
                silkLengthText.setText("Length: " + VibrationMaterial.SILK_LENGTH + " ms");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        // WOOL
        SeekBar woolDistance = rootView.findViewById(R.id.wool_distance);
        SeekBar woolLength = rootView.findViewById(R.id.wool_length);
        woolDistance.setProgress((int) VibrationMaterial.WOOL_DISTANCE);
        woolLength.setProgress((int) VibrationMaterial.WOOL_LENGTH);

        TextView woolDistanceText = rootView.findViewById(R.id.wool_distance_text);
        TextView woolLengthText = rootView.findViewById(R.id.wool_length_text);

        woolDistanceText.setText("Distance: " + VibrationMaterial.WOOL_DISTANCE + " px");
        woolLengthText.setText("Length: " + VibrationMaterial.WOOL_LENGTH + " ms");

        woolDistance.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.WOOL_DISTANCE = progress;
                woolDistanceText.setText("Distance: " + VibrationMaterial.WOOL_DISTANCE + " px");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });

        woolLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                VibrationMaterial.WOOL_LENGTH = progress;
                woolLengthText.setText("Length: " + VibrationMaterial.WOOL_LENGTH + " ms");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar){
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){
            }
        });


        // Reset button
        Button resetButton = rootView.findViewById(R.id.reset_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VibrationMaterial.resetVibrationMaterialSettings();
                
                leatherDistanceText.setText("Distance: " + VibrationMaterial.LEATHER_DISTANCE + " px");
                leatherLengthText.setText("Length: " + VibrationMaterial.LEATHER_LENGTH + " ms");
                leatherDistance.setProgress((int) VibrationMaterial.LEATHER_DISTANCE);
                leatherLength.setProgress((int) VibrationMaterial.LEATHER_LENGTH);
                
                denimDistanceText.setText("Distance: " + VibrationMaterial.DENIM_DISTANCE + " px");
                denimLengthText.setText("Length: " + VibrationMaterial.DENIM_LENGTH + " ms");
                denimDistance.setProgress((int) VibrationMaterial.DENIM_DISTANCE);
                denimLength.setProgress((int) VibrationMaterial.DENIM_LENGTH);
                
                silkDistanceText.setText("Distance: " + VibrationMaterial.SILK_DISTANCE + " px");
                silkLengthText.setText("Length: " + VibrationMaterial.SILK_LENGTH + " ms");
                silkDistance.setProgress((int) VibrationMaterial.SILK_DISTANCE);
                silkLength.setProgress((int) VibrationMaterial.SILK_LENGTH);

                woolDistanceText.setText("Distance: " + VibrationMaterial.WOOL_DISTANCE + " px");
                woolLengthText.setText("Length: " + VibrationMaterial.WOOL_LENGTH + " ms");
                woolDistance.setProgress((int) VibrationMaterial.WOOL_DISTANCE);
                woolLength.setProgress((int) VibrationMaterial.WOOL_LENGTH);
            }
        });
        
        return rootView;
    }
}