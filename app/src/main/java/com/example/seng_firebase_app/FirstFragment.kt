package com.example.android_firebase

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_firebase.databinding.FragmentFirstBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var databaseRef: DatabaseReference
    val db = FirebaseFirestore.getInstance()


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //create a map

        binding.btnSave.setOnClickListener {


            val firstName=binding.txtFirstName.text.toString()
            val lastName=binding.txtLastName.text.toString()
            val age=binding.txtAge.text.toString().toInt()

            val user= mapOf("firstName" to firstName,"lastName" to lastName,"age" to 21)
            db.collection("userCollection").document("User").set(user)
            

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}