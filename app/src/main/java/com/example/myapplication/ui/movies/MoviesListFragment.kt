package com.example.myapplication.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.movie.MoviesListAdapter
import com.example.myapplication.databinding.FragmentMoviesListBinding
import com.example.myapplication.models.Movie
import com.example.myapplication.ui.viewModels.MoviesViewModel
import com.example.myapplication.utils.observe
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.activityViewModel
import timber.log.Timber


class MoviesListFragment : Fragment() {

    private lateinit var binding: FragmentMoviesListBinding
    private lateinit var mAdapter: MoviesListAdapter
    private val viewModel : MoviesViewModel by activityViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesListBinding.bind(inflater.inflate(R.layout.fragment_movies_list, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.observeViewModel()
        viewModel.doGetMovies()
    }

    private fun doPopulateMovies(result: ArrayList<Movie>) {
        Timber.d("response of user service :  %s", result)
        mAdapter = MoviesListAdapter(result, onItemClicked = {
            // navigate to selected movie detail

            val action = MoviesListFragmentDirections
                    .actionMoviesListFragmentToMovieDetailFragment(it)
            view?.findNavController()?.navigate(action)

        } ,requireContext())
        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.adapter = mAdapter

        // save movies in database
        viewModel.persistMovies(result)
    }


    private fun observeViewModel(){
        observe(viewModel._movies){
            this@MoviesListFragment.doPopulateMovies(it)
        }
    }

    companion object {


        @JvmStatic
        fun newInstance() =
            MoviesListFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}