package com.example.shopapp.features.myCartScreen.presentation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import coil.load
import coil.transform.RoundedCornersTransformation
import com.example.shopapp.features.myCartScreen.R
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

        myCartViewModel.myCartList.observe(viewLifecycleOwner) {
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
                imageViewItem1.setImageUrl(basketProduct1.images)
                textViewItem1Name.text = basketProduct1.title
                textViewItem1Price.text =
                    NumberFormat.getCurrencyInstance(Locale.US).format(basketProduct1.price)
                val image2Url = (basketProduct2.images).substringBefore('?')
                imageViewItem2.setImageUrl(image2Url)
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
                        "We can't load images! Exception: ${MyCartApiStatus.ERROR().exception}",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }
            }
        }

    }

    private fun ImageView.setImageUrl(imgUrl: String) {
        imgUrl.let {
            this.load(imgUrl) {
                placeholder(R.drawable.loading_animation)
                error(R.drawable.ic_broken_image)
                transformations(RoundedCornersTransformation(40f))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



