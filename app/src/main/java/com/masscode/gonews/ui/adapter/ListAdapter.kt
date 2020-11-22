package com.masscode.gonews.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masscode.gonews.R
import com.masscode.gonews.databinding.ItemListNewsBinding
import com.masscode.gonews.domain.model.User

class ListAdapter : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var listData = ArrayList<User>()
    var onItemClick: ((User) -> Unit)? = null

    fun setData(newListData: List<User>?) {
        if (newListData == null) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_news, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListNewsBinding.bind(itemView)
        fun bind(data: User) {
            with(binding) {
                article = data
                executePendingBindings()
                root.setOnClickListener { onItemClick?.invoke(listData[adapterPosition]) }
            }
        }
    }
}