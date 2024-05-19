package com.example.firebasetrivia

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.firebasetrivia.databinding.ActivityMainBinding

// Main activity for the app that hosts the navigation graph
// It also listens for destination changes to update the action bar
class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding
    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment_content_main) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Add a listener to the navigation controller for destination changes
        navController.addOnDestinationChangedListener(this)

    }

    override fun onStart() {
        super.onStart()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val navDestination =
            navController.currentDestination ?: return super.onPrepareOptionsMenu(menu)
        // Hide the logout button if the current destination is different than Profile screen
        menu?.findItem(R.id.logout)?.isVisible = navDestination.id == R.id.profileFragment
        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        return when (item.itemId) {
            R.id.logout ->  {

                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        // Disable the back arrow in the action bar
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        invalidateOptionsMenu()
    }

}
