package com.example.neobischallengeandroidapp

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.neobischallengeandroidapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!
    private var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // Set the status bar background color to white
            window.statusBarColor = ContextCompat.getColor(this, R.color.white)

            // Set the status bar text color to dark
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarLayout)
        val navHost =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHost.navController


        val bottomNav = binding.navView
        bottomNav.setupWithNavController(navController!!)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.basketFragment,
                R.id.historyFragment,
                R.id.infoFragment
            )
        )
        binding.appBarLayout.setupWithNavController(navController!!, appBarConfiguration)

        navController!!.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.infoFragment ) {
                binding.appBarLayout.visibility = View.GONE
                binding.navView.visibility = View.VISIBLE
            }else if (destination.id == R.id.detailFragment) {
                binding.appBarLayout.visibility = View.GONE
                binding.navView.visibility = View.GONE
            }else{
                binding.appBarLayout.visibility = View.VISIBLE
                binding.navView.visibility = View.VISIBLE
            }
        }
    }
    //else if (destination.id == R.id.liveFragment) {
//            binding.appBarLayout.visibility = View.GONE
//            binding.navView.visibility = View.VISIBLE
//        } else if (destination.id == R.id.countryDetailFragment || destination.id == R.id.favouriteFragment) {
//            binding.appBarLayout.visibility = View.VISIBLE
//            binding.navView.visibility = View.GONE
//        } else {
//            binding.appBarLayout.visibility = View.GONE
//            binding.navView.visibility = View.GONE
//        }
//
//        if (destination.id == R.id.welcomFragment || destination.id == R.id.exploreFragment) {
//            binding.tvMainName.text = getString(R.string.app_name)
//        } else if (destination.id == R.id.liveFragment) {
//            binding.tvMainName.text = getString(R.string.live)
//        } else if (destination.id == R.id.gameFragment) {
//            binding.tvMainName.text = getString(R.string.game)
//        } else if (destination.id == R.id.favouriteFragment) {
//            binding.tvMainName.text = getString(R.string.favourite)
//        }
//    }
//}
//
//
//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        menu!!.clear()
//        menuInflater.inflate(R.menu.bottom_menu, menu)
//        return super.onPrepareOptionsMenu(menu)
//    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
//
//@Deprecated("Deprecated in Java")
//override fun onBackPressed() {
//    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
//    if (navController!!.currentDestination!!.id == R.id.welcomFragment){
//        finish()
//    }else{
//        super.onBackPressed()
//    }
//}
}