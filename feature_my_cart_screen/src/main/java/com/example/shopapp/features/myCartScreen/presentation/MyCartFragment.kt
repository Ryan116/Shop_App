package com.example.shopapp.features.myCartScreen.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.shopapp.common.extensions.setImageDrawableFromUrl
import com.example.shopapp.features.myCartScreen.databinding.FragmentMyCartBinding
import com.example.shopapp.features.myCartScreen.presentation.viewModel.MyCartApiStatus
import com.example.shopapp.features.myCartScreen.presentation.viewModel.MyCartViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.NumberFormat
import java.util.*


class MyCartFragment : Fragment() {

    private var _binding: FragmentMyCartBinding? = null
    private val binding
        get() = _binding!!

    private val myCartViewModel by viewModel<MyCartViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myCartViewModel.myCart.observe(viewLifecycleOwner) {
            val basketMain = it
            binding.apply {
                textViewDelivery.text = basketMain.delivery
                val total = NumberFormat.getCurrencyInstance(Locale.US).format(basketMain.total)
                textViewTotal.text = "$total us"
            }
            val basketProductsList = basketMain.basket
            val basketProduct1 = basketProductsList[0]
            val basketProduct2 = basketProductsList[1]

            binding.apply {
                imageViewItem1.setImageDrawableFromUrl(basketProduct1.images, 0f)
                textViewItem1Name.text = basketProduct1.title
                textViewItem1Price.text =
                    NumberFormat.getCurrencyInstance(Locale.US).format(basketProduct1.price)
                val image2Url = (basketProduct2.images).substringBefore('?')
                imageViewItem2.setImageDrawableFromUrl(image2Url, 0f)
                textViewItem2Name.text = basketProduct2.title
                textViewItem2Price.text =
                    NumberFormat.getCurrencyInstance(Locale.US).format(basketProduct2.price)
            }
        }

        myCartViewModel.status.observe(viewLifecycleOwner) {
            when (it) {
                is MyCartApiStatus.ERROR -> {
                    Toast.makeText(
                        requireContext(),
                        "Warning! You are don't have connection to internet!" +
                                " Exception: ${MyCartApiStatus.ERROR().exception}\nLoading from database...",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
                else -> {}
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



