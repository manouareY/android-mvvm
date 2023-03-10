package com.example.myapplication.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMovieDetailBinding


class MovieDetailFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    val args: MovieDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieDetailBinding.bind(inflater.inflate(R.layout.fragment_movie_detail, container, false))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.name.text =  String.format(resources.getString(R.string.movie_name_detail_screen), args.movie?.title ?:  "", args.movie?.year ?:  "")
        binding.director.text =  String.format(resources.getString(R.string.movie_director_detail_screen), args.movie?.director ?:  "")
        args.movie?.posterUrl?.let {
            Glide.with(requireActivity()).load(it).into(binding.poster);
        }?: kotlin.run {
            Toast.makeText(requireContext(), "Oups .. cant load image from giving URL", Toast.LENGTH_LONG).show()
        }

    }

    companion object {


        @JvmStatic
        fun newInstance() =
            MovieDetailFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}