
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.GridLayoutManager
import com.kotlin.example.mypet.Adapters.PetAdapters
import com.kotlin.example.mypet.PetViewModel
import com.kotlin.example.mypet.R
import com.kotlin.example.mypet.databinding.FragmentFavoritBinding
import com.kotlin.example.mypet.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentFavorite.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentFavorite : Fragment() {
    private val petViewModel : PetViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentFavoritBinding.bind(view)

        val adapter = PetAdapters{}
        binding.favoritePets.adapter = adapter
        binding.favoritePets.layoutManager = GridLayoutManager(this.context, 1)
        adapter.submitList(petViewModel.getSavedPet())
    }
}