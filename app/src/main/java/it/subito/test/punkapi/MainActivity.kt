package it.subito.test.punkapi

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import dagger.hilt.android.AndroidEntryPoint
import it.subito.test.punkapi.beerslist.BeersListViewModel
import it.subito.test.punkapi.databinding.ActivityMainBinding
import timber.log.Timber
import java.net.URLEncoder

/**
 *  Main Activity. I stick with Google Single Activity pattern since with Navigation components I found to be a good solution.
 * */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: BeersListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.searchBrewedAfter.editText!!.doOnTextChanged { text, _, _, _ ->
            binding.searchButton.isEnabled = text!!.isNotEmpty()
        }
        binding.searchBrewedBefore.editText!!.doOnTextChanged { text, start, before, count ->
            binding.searchButton.isEnabled = text!!.isNotEmpty()
        }

        binding.searchButton.setOnClickListener {
            Timber.i("Clicked MAIN BUTTON ")
            viewModel.fetchBeersPaginatedAndWithFilterDate(page = 1, URLEncoder.encode(binding.brewedBefore.text.toString(), "utf-8"), URLEncoder
                .encode(binding.brewedAfter.text.toString(), "utf-8"))
        }

    }
}
