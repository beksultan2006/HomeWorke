package com.example.homeworke1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.homeworke1.databinding.ItemImageBinding

class MainAdapter(private var imgList : ArrayList<ImageModel>, private val context : Context, private val listener: SelectedListener) : Adapter<MainAdapter.MainViewHolder>() {


    @SuppressLint("NotifyDataSetChanged")
    fun setList(imgList: ArrayList<ImageModel>){
        this.imgList = imgList
        notifyDataSetChanged()
    }

   inner class MainViewHolder( val binding: ItemImageBinding) : ViewHolder(binding.root) {
        fun onBind(img: ImageModel) {
            Glide.with(context).load(img.url).into(binding.itemImg)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(ItemImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.onBind(imgList[position])
        holder.itemView.setOnLongClickListener{
            holder.binding.itemImg.alpha = 0.5f
            listener.select(imgList[position])
            true
        }
    }

    interface SelectedListener {
        fun select(selectImg: ImageModel)
    }
}