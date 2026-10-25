package com.example.tenantmanagementsystem

import androidx.navigation.ui.setupWithNavController
import android.content.Intent
import android.view.MenuItem
import androidx.navigation.ui.onNavDestinationSelected
import android.view.Menu
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding
import com.example.tenantmanagementsystem.databinding.NavHeaderBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // The "driver" that switches Fragments inside the NavHost
    private lateinit var navController: NavController
    // Tells the App Bar which screens are top-level (no back arrow)
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TENANT_LIFECYCLE", "MainActivity: onCreate")
        // Create the views from activity_main.xml (Toolbar + NavHost)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. Use our Toolbar as the App Bar
// toolbar ← android:id="@+id/toolbar" in activity_main.xml
        setSupportActionBar(binding.toolbar)

        // 2. Get the NavController from the NavHost
// nav_host_fragment ← android:id="@+id/nav_host_fragment"
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        // 3. Connect the App Bar to navigation:
// the title comes from each destination's android:label
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.dashboardFragment, R.id.addTenantFragment, R.id.viewTenantsFragment),
            binding.drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        val email = intent.getStringExtra("EMAIL")
        val headerBinding = NavHeaderBinding.bind(binding.navView.getHeaderView(0))
        headerBinding.headerEmailTextView.text = email ?: "Signed in"
    }

    // 4. Make the App Bar's back arrow work
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    // Turn main_menu.xml into menu items in the App Bar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
    // What happens when a menu item is tapped
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            return true
        }
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    // Called when the activity becomes visible to the user
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart called")
    }

    // Called when the activity starts interacting with the user
    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume called")
    }

    // Called when the activity is about to lose focus
    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause called")
    }

    // Called when the activity is no longer visible to the user
    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop called")
    }

    // Called when the stopped activity is about to start again
    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart called")
    }

    // Called before the activity is destroyed
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy called")
    }
}