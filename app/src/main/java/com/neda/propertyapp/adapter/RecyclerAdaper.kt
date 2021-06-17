package com.neda.propertyapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.neda.propertyapp.DetailActivity
import com.neda.propertyapp.MainActivity
import com.neda.propertyapp.R
import com.neda.propertyapp.model.PropertiesData
import com.neda.propertyapp.model.Property
import de.hdodenhof.circleimageview.CircleImageView

class RecyclerAdaper(val context: Context) : RecyclerView.Adapter<RecyclerAdaper.ViewHolder>() {

    public var propertiesData: PropertiesData = PropertiesData(listOf())

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val property_image: ImageView
        val profile_image: CircleImageView
        val agent_name: TextView
        val address: TextView
        var bed_count: TextView
        var bath_count: TextView
        var car_park_count: TextView

        init {
            property_image = itemView.findViewById(R.id.property_image)
            profile_image = itemView.findViewById(R.id.profile_image)
            agent_name = itemView.findViewById(R.id.agent_name)
            address = itemView.findViewById(R.id.address)
            bed_count = itemView.findViewById(R.id.bed_count)
            bath_count = itemView.findViewById(R.id.bath_count)
            car_park_count = itemView.findViewById(R.id.car_park_count)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = propertiesData.data[position]
        holder.agent_name.text = property.agent.first_name + " " +property.agent.last_name
        holder.address.text = property.location.address
        holder.bed_count.text = property.bedrooms.toString()
        holder.bath_count.text = property.bathrooms.toString()
        holder.car_park_count.text = property.carspaces.toString()
        Glide.with(context).load(propertiesData.data[position].property_images[0].attachment.large.url).fitCenter()
            .error(R.drawable.image_not_available).into(holder.property_image)
        Glide.with(context).load(propertiesData.data[position].agent.avatar.medium.url)
            .error(R.drawable.image_not_available).into(holder.profile_image)
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent: Intent = Intent(context,DetailActivity::class.java).apply {
                putExtra("id",property.id)
            }
            context.startActivity(intent)
        })

    }

    override fun getItemCount() = propertiesData.data.size
}