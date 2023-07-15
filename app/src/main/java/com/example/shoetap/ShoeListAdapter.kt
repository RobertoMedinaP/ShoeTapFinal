package com.example.shoetap

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shoetap.databinding.ItemViewBinding
import com.example.shoetap.models.Shoe
import com.example.shoetap.models.ShoeProvider


class ShoeListAdapter (private val returnItemList: List<Shoe>?, passElementSelected: PassElementSelected) : RecyclerView.Adapter<ShoeListAdapter.ShoeListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeListViewHolder {
        val binding: ItemViewBinding =
            ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoeListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoeListViewHolder, position: Int) {
        val item = returnItemList!![position]
        Glide.with(holder.image_view).load(item.url).into(holder.image_view)
        holder.title_view.text = item.name.toString()
        holder.descript_view.text = item.description.toString()
        holder.price_view.text = item.price.toString()
    }

    override fun getItemCount(): Int = returnItemList!!.size

    class ShoeListViewHolder(binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.getRoot()) {

        var title_view: TextView
        var image_view: ImageView
        var descript_view: TextView
        var price_view: TextView

        init {
            image_view = binding.image
            title_view = binding.title
            descript_view = binding.description
            price_view = binding.price
        }

    }

    interface PassElementSelected {
        //esta interfaz guardara el string seleccionado
        fun passElement(url: String?, title: String?, description: String?, price: String?)
    }

    //el escuchador para la interfaz, estatico para que no modifique el dato
    private val listener: PassElementSelected? = null

}

