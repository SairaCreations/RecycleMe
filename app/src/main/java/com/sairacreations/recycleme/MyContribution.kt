package com.sairacreations.recycleme

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sairacreations.recycleme.databinding.FragmentMyContributionBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MyContribution.newInstance] factory method to
 * create an instance of this fragment.
 */

class MyContribution : Fragment() {


    private var _binding: FragmentMyContributionBinding? = null
    private val binding get() = _binding!!
    private  lateinit var imageView: ImageView

    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?




    ): View? {


        _binding = FragmentMyContributionBinding.inflate(inflater, container, false)
        //val view:View = container?.rootView ?:
        imageView = binding.imageView2
        return binding.root
       // imageView.visibility = View.INVISIBLE
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.returnButton.setOnClickListener {
            findNavController().navigate(R.id.action_myContribution_to_FirstFragment)


        }
      //  binding.imageView2.x = 10.0f
       // binding.imageView2.y = 12.0f
        val imageView : ImageView = ImageView(context)
        imageView.setImageResource(R.drawable.treetop)
        imageView.x = 10.0f
        imageView.y = 12.0f
        imageView.visibility = View.VISIBLE

        val displaymetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displaymetrics)
        val height = displaymetrics.heightPixels
        val width = displaymetrics.widthPixels
        val number = 6

        //binding.imageView2.visibility = View.VISIBLE


    }
}