package com.sairacreations.recycleme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sairacreations.recycleme.databinding.FragmentFirstBinding
import com.sairacreations.recycleme.databinding.FragmentManualEntryBinding
import com.sairacreations.recycleme.databinding.FragmentSecondBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ManualEntryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ManualEntryFragment : Fragment() {

    private var _binding: FragmentManualEntryBinding? = null

    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentManualEntryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     //   val dbHelper = activity?.let { it1 -> DBHelper(it1.baseContext,null) }
       // dbHelper?.addValues("testing","can","Aluminum",2,1.0)
        binding.save.setOnClickListener {
            findNavController().navigate(R.id.action_manualEntryFragment_to_FirstFragment)
          /*  if(binding.editTextNumber.text.isNotEmpty()) {
                Toast.makeText(
                    context,
                    "Congrats on saving " + dbHelper?.getName().toString(),

                    Toast.LENGTH_SHORT
                ).show()

            }*/

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}