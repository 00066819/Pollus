package com.groupproject.pollusapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.groupproject.pollusapp.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var toogle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toogle = ActionBarDrawerToggle(this,drawerLayout,R.string.navigation_drawer_open,R.string.close_drawer)

        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        nav_view.setNavigationItemSelectedListener{
        when(it.itemId){

            R.id.nav_home ->{

                supportFragmentManager.beginTransaction().apply {
                    replace(androidx.fragment.R.id.fragment_container_view_tag, HomeFragment)
                    commit()
                }
            }


            R.id.nav_gallery ->{

                supportFragmentManager.beginTransaction().apply {
                    replace(androidx.fragment.R.id.fragment_container_view_tag, HomeFragment)
                    commit()
                }
            }


            R.id.nav_view ->{

                supportFragmentManager.beginTransaction().apply {
                    replace(androidx.fragment.R.id.fragment_container_view_tag, HomeFragment)
                    commit()
                }
            }
        }
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }

        getSupportActionBar()?.hide()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}