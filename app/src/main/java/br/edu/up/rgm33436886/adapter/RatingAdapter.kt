package br.edu.up.rgm33436886.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import java.text.SimpleDateFormat
import java.util.Locale

open class RatingAdapter(query: Query) : FirestoreAdapter<RatingAdapter.ViewHolder>(query) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemRatingBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getSnapshot(position).toObject<Rating>())
    }

    class ViewHolder(val binding: ItemRatingBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(rating: Rating?) {
            if (rating == null) {
                return
            }

            binding.ratingItemName.text = rating.userName
            binding.ratingItemRating.rating = rating.rating.toFloat()
            binding.ratingItemText.text = rating.text

            if (rating.timestamp != null) {
                binding.ratingItemDate.text = FORMAT.format(rating.timestamp)
            }
        }

        companion object {

            private val FORMAT = SimpleDateFormat(
                "MM/dd/yyyy", Locale.US)
        }
    }
}