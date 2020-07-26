package it.iquii.test.reddit.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import coil.api.load
import dagger.hilt.android.AndroidEntryPoint
import it.iquii.test.reddit.databinding.FragmentPhotoBinding

/**
 * Fragment for showing the photo in full screen. To avoid problem and eartning time I choose to use PhotoView image view which is a Chris Bane
 * library. I decided to use it first because it's extremly lightweighted and second because its author is a very famous Google developer.
 *
 * */

@AndroidEntryPoint
class PhotoFragment : Fragment() {
    private var binding: FragmentPhotoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotoBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.takeIf {
            it.containsKey("photoUrl")
        }?.apply {
            binding?.fullScreenPhoto?.load(this.get("photoUrl").toString())

        }
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onResume() {
        super.onResume()
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

    override fun onPause() {
        super.onPause()
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        activity?.window?.decorView?.systemUiVisibility = 0
    }

}