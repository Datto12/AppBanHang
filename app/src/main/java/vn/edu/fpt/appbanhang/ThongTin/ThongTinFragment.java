package vn.edu.fpt.appbanhang.ThongTin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import vn.edu.fpt.appbanhang.R;


public class ThongTinFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap myMap;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public ThongTinFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ThongTinFragment newInstance() {
        ThongTinFragment fragment = new ThongTinFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thong_tin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        myMap = googleMap;
        LatLng hanoi = new LatLng(21.0054,105.8021);
        myMap.addMarker(new MarkerOptions().position(hanoi).title("Ha noi"));
        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanoi,12));
    }

}