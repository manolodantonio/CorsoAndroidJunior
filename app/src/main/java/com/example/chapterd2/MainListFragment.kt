package com.example.chapterd2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.chapterd2.data.Repository
import com.example.chapterd2.databinding.FragmentMainListBinding


class MainListFragment : Fragment(R.layout.fragment_main_list) {

    private val repository = Repository
    val dataset = repository.dataset

    private val mainListAdapter = MainListAdapter(dataset) {
        val action = MainListFragmentDirections.actionMainListFragmentToMainDetailFragment(
            it.id.toString(), it.imageUrl
        )
        findNavController().navigate(action)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        FragmentMainListBinding.bind(view).run {
            mainListRv.adapter = mainListAdapter

            mainRefreshFab.setOnClickListener {
                repository.regenerateDataset()
                mainListAdapter.notifyDataSetChanged()
            }
        }

    }


}