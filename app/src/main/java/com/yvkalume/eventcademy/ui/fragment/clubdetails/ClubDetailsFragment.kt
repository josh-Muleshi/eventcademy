package com.yvkalume.eventcademy.ui.fragment.clubdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.viewbinding.library.fragment.viewBinding
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import com.airbnb.mvrx.*
import com.yvkalume.data.model.EventUiModel
import com.yvkalume.eventcademy.*
import com.yvkalume.eventcademy.R
import com.yvkalume.eventcademy.databinding.FragmentClubDetailsBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class ClubDetailsFragment : Fragment(R.layout.fragment_club_details) , MavericksView{
    private val binding by viewBinding<FragmentClubDetailsBinding>()
    private val viewModel: ClubDetailsViewModel by fragmentViewModel()
    private val args by navArgs<ClubDetailsFragmentArgs>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getClubEvents(args.club.uid)
    }

    private fun populateData(events: List<EventUiModel>) {
        binding.rV.withModels {
            clubDetail {
                id("detail")
                club(args.club)
            }
            header {
                id("events")
                text("Evenements")
            }
            for (event in events) {
                eventHorizontal {
                    id(event.uid)
                    event(event)
                }
            }
        }
    }

    override fun invalidate() = withState(viewModel) {
        binding.progress.isVisible = it.events is Loading
        when(it.events) {
            is Success -> {
                populateData(it.events.invoke())
                Timber.d("${it.events.invoke()}")
            }

            is Fail -> {
                Toast.makeText(requireContext(),"Une erreur s'est produite", Toast.LENGTH_SHORT).show()
            }
        }
    }
}