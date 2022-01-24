package com.example.shopapp.features.mainScreen.presentation.recyclerView


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shopapp.databinding.BestSellerItemBinding
import com.example.shopapp.features.mainScreen.domain.model.BestSeller

class BestSellerAdapter :
    ListAdapter<BestSeller, BestSellerViewHolder>(BestSellerDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BestSellerViewHolder {
        return BestSellerViewHolder(BestSellerItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        val homeStoreItem = getItem(position)
        holder.bind(homeStoreItem)
    }
}



