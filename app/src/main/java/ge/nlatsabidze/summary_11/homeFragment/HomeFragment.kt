package ge.nlatsabidze.summary_11.homeFragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ge.nlatsabidze.summary_11.BaseFragment
import ge.nlatsabidze.summary_11.adapter.InformationAdapter
import ge.nlatsabidze.summary_11.databinding.HomeFragmentBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding>(HomeFragmentBinding::inflate) {

    private lateinit var userItemAdapter: InformationAdapter
    private val userViewModel: HomeViewModel by viewModels()

    override fun start() {

        userItemAdapter = InformationAdapter()
        userViewModel.setResult()
        initRecycler()
    }

    private fun initRecycler() {

        binding.rvItems.apply {
            adapter = userItemAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        lifecycleScope.launch {
            userViewModel.userInfo.collect {
                userItemAdapter.user = it
            }
        }
    }
}