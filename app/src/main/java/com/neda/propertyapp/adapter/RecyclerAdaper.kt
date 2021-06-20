package com.neda.propertyapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.neda.propertyapp.DetailActivity
import com.neda.propertyapp.R
import com.neda.propertyapp.databinding.ActivityDetailBinding
import com.neda.propertyapp.databinding.CardBinding
import com.neda.propertyapp.model.PropertiesData
import de.hdodenhof.circleimageview.CircleImageView

// adapter for RecyclerView
class RecyclerAdaper(val context: Context, var propertiesData: PropertiesData) : RecyclerView.Adapter<RecyclerAdaper.ViewHolder>() {

    inner class ViewHolder(val binding: CardBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
//        return ViewHolder(view)
        return ViewHolder(CardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val property = propertiesData.data[position]
        holder.binding.apply {
            agentName.text = property.agent.first_name + " " +property.agent.last_name
            address.text = property.location.address
            bedCount.text = property.bedrooms.toString()
            bathCount.text = property.bathrooms.toString()
            carParkCount.text = property.carspaces.toString()

            // property images
            val imageList = ArrayList<SlideModel>()
            for (image in property.property_images){
                imageList.add(SlideModel(image.attachment.large.url,ScaleTypes.CENTER_CROP))
            }
            propertyImage.setImageList(imageList)

            // avater
            Glide.with(context).load(propertiesData.data[position].agent.avatar.medium.url)
                .error(R.drawable.image_not_available).into(profileImage)
        }
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(context,DetailActivity::class.java).apply {
                putExtra("id",property.id)
            }
            context.startActivity(intent)
        })
    }

    override fun getItemCount() = propertiesData.data.size

    fun setProperties(newData: PropertiesData){
        propertiesData = newData
        notifyDataSetChanged()
    }
}