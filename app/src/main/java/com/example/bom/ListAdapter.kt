package com.example.bom

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.bom.databinding.ListItemBinding

class ListAdapter(var list:MutableList<Data>): RecyclerView.Adapter<ListAdapter.ViewHolderAdapter>() {
    var onItemClick : ((Data)-> Unit)? = null

    inner class ViewHolderAdapter(val binding:ListItemBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolderAdapter(binding)
    }
    fun onApplySearch(list: MutableList<Data>){
        this.list=list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        holder.binding.apply {

            tvTitle.text = list[position].title
            tvCode.text = list[position].code
        }
            holder.itemView.setOnClickListener(){
            onItemClick?.invoke(list[position])
        }

    }

}