package com.example.shopapp.features.mainScreen.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shopapp.features.mainScreen.databinding.BestSellerItemBinding
import com.example.shopapp.features.mainScreen.domain.model.BestSeller

class BestSellerAdapter(private val onItemClicked: (BestSeller) -> Unit) :
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
        holder.itemView.setOnClickListener {
            onItemClicked(homeStoreItem)
        }
    }
}


