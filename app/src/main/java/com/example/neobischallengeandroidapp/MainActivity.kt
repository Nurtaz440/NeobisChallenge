package com.example.neobischallengeandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.WindowManager
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
    }
//    navController!!.addOnDestinationChangedListener { _, destination, _ ->
//
//        if (destination.id == R.id.welcomFragment || destination.id == R.id.exploreFragment
//            || destination.id == R.id.gameFragment || destination.id == R.id.favouriteFragment
//        ) {
//            binding.appBarLayout.visibility = View.VISIBLE
//            binding.navView.visibility = View.VISIBLE
//        } else if (destination.id == R.id.liveFragment) {
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
//override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//    menu!!.clear()
//    menuInflater.inflate(R.menu.action_bar, menu)
//    return super.onPrepareOptionsMenu(menu)
//}
//
//override fun onDestroy() {
//    super.onDestroy()
//    _binding = null
//}
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