package com.example.shopapp.features.mapScreen.presentation

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.shopapp.common.constants.Constants.LOCATION_REQUEST_CODE
import com.example.shopapp.features.mapScreen.R
import com.example.shopapp.features.mapScreen.databinding.FragmentMapsBinding
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationSettingsRequest
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class MapsFragment : Fragment(), GoogleMap.OnMarkerClickListener {

    private lateinit var binding: FragmentMapsBinding
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var lastLocation: Location
    private lateinit var locationRequest: LocationRequest
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
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(zihuatanejo))
        googleMap.uiSettings.isMyLocationButtonEnabled = true
        binding.buttonFindMe.setOnClickListener {
            checkGPS(googleMap)
        }
    }

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

    private fun checkGPS(googleMap: GoogleMap) {
        if (checkGPSEnabled()) {
            if (ActivityCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
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
            locationRequest = LocationRequest.create().apply {
                interval = 10000
                fastestInterval = 5000
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
            }
            val builder = LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest)
                .setAlwaysShow(true)
            LocationServices.getSettingsClient(requireActivity().applicationContext)
                .checkLocationSettings(builder.build())
                .addOnFailureListener {
                    if (it is ResolvableApiException) {
                        try {
                            it.startResolutionForResult(
                                requireActivity(),
                                LOCATION_REQUEST_CODE
                            )
                        } catch (e: ApiException) {
                            e.printStackTrace()
                        }
                    }
                }
        }
    }

    override fun onMarkerClick(p0: Marker): Boolean = false

    private fun checkGPSEnabled(): Boolean {
        val locationManager =
            requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    private fun placeMarkerOnMap(currentLatLong: LatLng, googleMap: GoogleMap) {
        val markerOptions = MarkerOptions().position(currentLatLong)
        markerOptions.title("$currentLatLong")
        googleMap.addMarker(markerOptions)
    }
}