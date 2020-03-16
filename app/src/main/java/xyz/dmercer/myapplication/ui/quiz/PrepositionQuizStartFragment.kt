package xyz.dmercer.myapplication.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import xyz.dmercer.myapplication.R

class PrepositionQuizStartFragment : Fragment() {

    private lateinit var prepositionQuizViewModel: PrepositionQuizViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val viewModelFactory = ViewModelFactory(this.requireContext())
        prepositionQuizViewModel =
            ViewModelProvider(this, viewModelFactory).get(PrepositionQuizViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_preposition_quiz_start, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        prepositionQuizViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        root.findViewById<Button>(R.id.btnStartQuiz).setOnClickListener {
            findNavController().navigate(R.id.action_nav_preposition_quiz_start_to_nav_preposition_quiz)
        }
        return root
    }



}
