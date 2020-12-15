package it.subito.test.punkapi.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import dagger.hilt.android.AndroidEntryPoint
import it.subito.test.punkapi.BaseFragment
import it.subito.test.punkapi.MainActivity
import it.subito.test.punkapi.R
import it.subito.test.punkapi.databinding.DetailSwipeFragmentBinding
import it.subito.test.punkapi.library.android.entity.PhotosMetaDataHolder

@AndroidEntryPoint
class DetailSwipeFragment : BaseFragment(R.layout.detail_swipe_fragment) {

    val args: DetailSwipeFragmentArgs by navArgs()


    private lateinit var viewPager: ViewPager2
    private lateinit var viewAdapter: PhotoAdapter
    private var fragmentBindings: DetailSwipeFragmentBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragmentBindings = DetailSwipeFragmentBinding.bind(view)
        (activity as MainActivity).binding.appBar.visibility = View.GONE

        viewPager = fragmentBindings!!.viewpagerPhotos
        viewAdapter = PhotoAdapter(this).apply {
            this.itemUrl = args.photosArray.toList()
            this.currentItemIndex = args.index
        }
        viewPager.adapter = viewAdapter
        viewPager.currentItem = args.index

    }

    override fun onPause() {
        (activity as MainActivity).binding.appBar.visibility = View.VISIBLE
        super.onPause()
    }

    override fun onDestroyView() {
        fragmentBindings = null
        super.onDestroyView()
    }
}

class PhotoAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    var itemUrl: List<PhotosMetaDataHolder> = emptyList()
    var currentItemIndex: Int = 0

    override fun getItemCount(): Int = itemUrl.size

    override fun createFragment(position: Int): Fragment {

        val fragment = PhotoFragment()
        fragment.arguments = Bundle().apply {
            putString("photoUrl", itemUrl[position].url)
        }
        return fragment
    }

}