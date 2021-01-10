package com.example.week6assignment1.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.week6assignment1.R
import com.example.week6assignment1.model.user
import com.example.week6assignment1.object2.users
//import com.example.week6assignment1.object2.users.loadvalue

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class AddStudentFragment : Fragment() {
    private lateinit var name:EditText
    private lateinit var age:EditText
    var gender=""
    private lateinit var male:RadioButton
    private lateinit var female:RadioButton
    private lateinit var others:RadioButton
    private lateinit var address:EditText
    private lateinit var img:EditText
    private lateinit var save:Button
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_add_student, container, false)
        return rootView
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            AddStudentFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name=view.findViewById(R.id.name)
        age=view.findViewById(R.id.age)
        male=view.findViewById(R.id.male)
        female=view.findViewById(R.id.female)
        others=view.findViewById(R.id.other)
        address=view.findViewById(R.id.address)
        img=view.findViewById(R.id.img)
            if(male.isChecked){
                gender="Male"
            }
            else if(female.isChecked){
                gender="Female"
            }
            else if(others.isChecked){
                gender="other"
            }
            save=view.findViewById(R.id.save)
        save.setOnClickListener(){
            users.listUSer.add(user(img.text.toString(),name.text.toString(),age.text.toString(),address.text.toString(),gender))
            name.setText("")
            age.setText("")
            male.isChecked=false
            female.isChecked=false
            others.isChecked=false
            img.setText("")
            address.setText("")

        }

    }

}