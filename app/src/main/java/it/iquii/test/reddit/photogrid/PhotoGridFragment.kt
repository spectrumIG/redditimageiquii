package it.iquii.test.reddit.photogrid

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import it.iquii.test.reddit.R
import it.iquii.test.reddit.databinding.PhotoGridFragmentBinding

@AndroidEntryPoint
class PhotoGridFragment : Fragment(R.layout.photo_grid_fragment) {

    private var fragmentBindings : PhotoGridFragmentBinding? = null
    private val viewModel : PhotoGridViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentBindings = PhotoGridFragmentBinding.bind(view)
        val grid = fragmentBindings!!.mainGridRecycler
        grid.apply {
            layoutManager =GridLayoutManager(requireContext(),4)

        }

    }
}