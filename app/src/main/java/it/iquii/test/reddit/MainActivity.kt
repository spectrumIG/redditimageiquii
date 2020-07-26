package it.iquii.test.reddit

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import it.iquii.test.reddit.databinding.ActivityMainBinding
import it.iquii.test.reddit.photogrid.OnFilterListener
import it.iquii.test.reddit.photogrid.PhotoGridFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import reactivecircus.flowbinding.android.widget.afterTextChanges

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    lateinit var listener: OnFilterListener
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.searchText.afterTextChanges().debounce(1000).onEach {

            val filter = binding.searchText.text

            if(filter!!.isNotBlank()) {
                (listener as PhotoGridFragment).fragmentBindings!!.progressBar.visibility = View.VISIBLE
                (listener as PhotoGridFragment).fragmentBindings!!.noItemText.visibility = View.GONE
                listener.filterSent(filter.toString())
            }

        }.launchIn(CoroutineScope(Dispatchers.Main))
    }
}
