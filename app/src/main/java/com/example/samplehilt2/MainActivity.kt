package com.example.samplehilt2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.samplehilt2.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setupActionBarWithNavController(findNavController(R.id.fragmentContainerView2))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragmentContainerView2)
        return navController.navigateUp() || super.onSupportNavigateUp()

    }


}