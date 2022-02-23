package com.example.shopapp.features.mapScreen.presentation.fragment

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.location.LocationRequest
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import com.example.shopapp.R
import com.example.shopapp.databinding.FragmentMapsBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest.create
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.system.exitProcess


const val LOCATION_REQUEST_CODE = 1

class MapsFragment : androidx.fragment.app.Fragment(), GoogleMap.OnMarkerClickListener {
    private lateinit var binding: FragmentMapsBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private lateinit var locationRequest: LocationRequest

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireActivity())
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    override fun onMarkerClick(p0: Marker): Boolean = false

    private val callback = OnMapReadyCallback { googleMap ->
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.setOnMarkerClickListener(this)


        val zihuatanejo = LatLng(17.64, -101.0)
        val paris = LatLng(48.86, 2.34)
        val california = LatLng(36.77, -119.41)
        val amsterdam = LatLng(52.37, 4.89)
        googleMap.addMarker(MarkerOptions().position(zihuatanejo).title("Marker in Mexica"))
        googleMap.addMarker(MarkerOptions().position(paris).title("Marker in Paris"))
        googleMap.addMarker(MarkerOptions().position(california).title("Marker in California"))
        googleMap.addMarker(MarkerOptions().position(amsterdam).title("Marker in Amsterdam"))
        binding.buttonFindMe.setOnClickListener {
            setUpMap(googleMap)
        }
    }

    private fun checkGPSEnabled(): Boolean {
        var locationManager =
            requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    private fun setUpMap(googleMap: GoogleMap) {
        if (checkGPSEnabled()) {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    LOCATION_REQUEST_CODE
                )
                return
            }
            googleMap.isMyLocationEnabled = true
            fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                if (it != null) {
                    lastLocation = it
                    val currentLatLong = LatLng(it.latitude, it.longitude)
                    placeMarkerOnMap(currentLatLong, googleMap)
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLong, 12f))
                }
            }

        } else {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("GPS is disabled.")
                .setMessage("Please, click \"yes\" button to turn on GPS")
                .setCancelable(false)
                .setNegativeButton("No") { _, _ ->
                    exitProcess(0)
                }
                .setPositiveButton("Yes") { _, _ ->
                    startActivity(Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS))
                }
                .show()
        }



    }

    private fun placeMarkerOnMap(currentLatLong: LatLng, googleMap: GoogleMap) {
        val markerOptions = MarkerOptions().position(currentLatLong)
        markerOptions.title("$currentLatLong")
        googleMap.addMarker(markerOptions)
    }


}








