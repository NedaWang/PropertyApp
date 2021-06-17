package com.neda.propertyapp.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

// adapter for ViewPager
class ImageAdapter(val context: Context, val imageURLs: List<String>) : PagerAdapter() {

    override fun getCount() = imageURLs.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view==`object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView= ImageView(context)
        Glide.with(context).load(imageURLs.get(position)).centerCrop().into(imageView)
        container.addView(imageView)
        return imageView
    }
}