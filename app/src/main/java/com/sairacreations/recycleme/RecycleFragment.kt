package com.sairacreations.recycleme

import android.content.Intent
import android.graphics.Camera
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sairacreations.recycleme.databinding.FragmentSecondBinding



/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class RecycleFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
        binding.buttonAi.setOnClickListener {
           // findNavController().navigate(R.id.action_SecondFragment_to_CameraFragment)
           val myIntent = Intent(activity?.applicationContext , CameraActivity::class.java)
            //val myIntent = Intent(activity?.applicationContext, CameraActivity)
            requireActivity().startActivity(myIntent)
        }
        binding.buttonManual.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_manualEntryFragment)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}