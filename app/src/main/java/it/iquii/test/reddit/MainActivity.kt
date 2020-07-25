package it.iquii.test.reddit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import it.iquii.test.reddit.databinding.ActivityMainBinding
import it.iquii.test.reddit.photogrid.OnFilterListener

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var listener: OnFilterListener
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onStart() {
        super.onStart()

        binding.button.setOnClickListener {
            listener.filterSent(binding.searchText.text.toString())
        }
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
    }
}
