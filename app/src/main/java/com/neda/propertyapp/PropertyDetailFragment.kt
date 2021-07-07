package com.neda.propertyapp

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.neda.propertyapp.databinding.FragmentPropertyDetailBinding
import com.neda.propertyapp.model.Property
import com.neda.propertyapp.vm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.File

@AndroidEntryPoint
class PropertyDetailFragment : Fragment(R.layout.fragment_property_detail) {

    private val viewModel: MainViewModel by activityViewModels()
    val args: PropertyDetailFragmentArgs by navArgs()
    private var _binding: FragmentPropertyDetailBinding? = null
    private val binding get() = _binding!!
    lateinit var property: Property
    var image_height: Int = 0
    var image_width: Int = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View{

        _binding = FragmentPropertyDetailBinding.inflate(inflater,container,false)


        var propertyID = args.propertyID.toInt()

        viewModel.propertiesLiveData.observe(getViewLifecycleOwner()){
            property = it.data[propertyID]
            //binding.textView.text = property.id
            binding.apply {

                // attributes
                address.text = property.location.address
                saleType.text = property.sale_type
                price.text = property.display_price
                bedCount.text = property.bedrooms.toString()
                bathCount.text = property.bathrooms.toString()
                carParkCount.text = property.carspaces.toString()
                description.text = property.description


                // property images
                val imageList = ArrayList<SlideModel>()
                for (image in property.property_images){
                    // add images for slider
                    imageList.add(SlideModel(image.attachment.large.url, ScaleTypes.CENTER_CROP))
                    // add images in content
                    var newView: ImageView = ImageView(context)
                    context?.let { it1 ->
                        Glide.with(it1).load(image.attachment.large.url)
                            .error(R.drawable.image_not_available).into(newView)
                    }
                    addImage(linearLayout,newView)

                }
                propertyImageSlider.setImageList(imageList)

            }
        }

        binding.root.setOnTouchListener(View.OnTouchListener{ view: View, motionEvent: MotionEvent ->
            val action = motionEvent.action

            var pDownX=0
            var pDownY=0
            var pUpX=0
            var pUpY=0

            when(action){
                MotionEvent.ACTION_DOWN -> {
                    pDownX= motionEvent.x.toInt()
                    pDownY= motionEvent.y.toInt()
                }

                MotionEvent.ACTION_UP -> {
                    pUpX= motionEvent.x.toInt()
                    pUpY= motionEvent.y.toInt()

                    // swipe left
                    if ((pUpX- pDownX) > 300 && Math.abs(pUpY - pDownY) < 50) {

                    } else if (Math.abs(pDownX- pUpX) > 300 && (pUpX > pDownX) && Math.abs(pUpY - pDownY) < 50) {
                        //swipe to right
                    }
                }

                else ->{
                    false
                }
            }
            false
        })

        return binding.root
    }

    fun addImage(layout: LinearLayout,imageView: ImageView){
        var layoutParam : LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT)
        layoutParam.setMargins(20,20,20,0)
        imageView.layoutParams = layoutParam
        imageView.setScaleType(ImageView.ScaleType.CENTER)
        layout.addView(imageView)
    }


}