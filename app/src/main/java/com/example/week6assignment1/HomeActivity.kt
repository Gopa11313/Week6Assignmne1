package com.example.week6assignment1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.example.week6assignment1.Fragments.AddStudentFragment
import com.example.week6assignment1.Fragments.HomeFragment
import com.example.week6assignment1.object2.users
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    private lateinit var frameLayout:FrameLayout;
    private lateinit var bottmNavigation:BottomNavigationView;
    private val home=HomeFragment();
    private val addstudent=AddStudentFragment();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        users.loadvalue();
        frameLayout=findViewById(R.id.frameLayout)
        bottmNavigation=findViewById(R.id.bottom_navigation)
        replaceFragment(home)
        bottmNavigation.setOnNavigationItemSelectedListener(){
            when(it.itemId){
                R.id.ic_home-> {
                    replaceFragment(home)
                    true
                }
                R.id.ic_add_student->{
                    replaceFragment(addstudent)
                    true
                }
                R.id.ic_about->{
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://softwarica.edu.np/")))
                    true
                }
                else->false
            }
            true;
        }
    }
    fun replaceFragment(fragment:Fragment){
        if(fragment!=null){
            val transaction=supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout,fragment)
            transaction.commit()
        }
    }

}