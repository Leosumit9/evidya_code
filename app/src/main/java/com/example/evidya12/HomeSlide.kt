package com.example.evidya12

import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.evidya12.databinding.ActivityHomeSlideBinding
import com.example.evidya12.databinding.FragmentHomeBinding


class HomeSlide : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityHomeSlideBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeSlideBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel("https://res.cloudinary.com/dhhxxs2pb/image/upload/v1740234713/Screenshot_2025-02-22_194522_o97fhe.png", "Your Image Title"))
        imageList.add(SlideModel("https://res.cloudinary.com/dhhxxs2pb/image/upload/v1740235456/Screenshot_2025-02-22_201347_dmlglc.png", "My Second Image"))
        imageList.add(SlideModel("https://res.cloudinary.com/dhhxxs2pb/image/upload/v1740237120/Screenshot_2025-02-22_204138_p8qcs1.png", "My Third Image"))




        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)




        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        supportActionBar?.title = ""  // This removes the title
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}