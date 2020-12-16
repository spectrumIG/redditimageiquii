package it.subito.test.punkapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import it.subito.test.punkapi.beerslist.OnFilterListener
import it.subito.test.punkapi.databinding.ActivityMainBinding

/**
 *  Main Activity. I stick with Google Single Activity pattern since with Navigation components I found to be a good solution.
 *  Unfortunatly, I had some problem with ViewBinding so I had to put a listener here to send the filter string to Fragment
 * */

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val TIMEOUT_FOR_REQUEST: Long = 1000
    lateinit var listener: OnFilterListener
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.searchText.afterTextChanges().debounce(TIMEOUT_FOR_REQUEST).onEch {
//            hideKeyboard(binding.searchText)
//            val filter = binding.searchText.text
//
//            if(filter!!.isNotBlank()) {
//                (listener as PhotoGridFragment).fragmentBindings!!.progressBar.visibility = View.VISIBLE
//                (listener as PhotoGridFragment).fragmentBindings!!.noItemText.visibility = View.GONE
//                listener.filterSent(filter.toString())
//            }
//
//        }.launchIn(CoroutineScope(Dispatchers.Main))
    }
}
