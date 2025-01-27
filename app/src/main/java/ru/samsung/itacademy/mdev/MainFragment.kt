package ru.samsung.itacademy.mdev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import ru.samsung.itacademy.mdev.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        binding.buttonBack.setOnClickListener {
            activity.finish()
        }
        binding.buttonInfo.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_infoFragment)
        }
        binding.buttonRecord.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_recordFragment)
        }
        binding.buttonExit.setOnClickListener {
            activity.finishAffinity()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}