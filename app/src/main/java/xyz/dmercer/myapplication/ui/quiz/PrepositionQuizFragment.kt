package xyz.dmercer.myapplication.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import xyz.dmercer.myapplication.R

class PrepositionQuizFragment : Fragment() {

    //private lateinit var prepositionQuizViewModel: PrepositionQuizViewModel
    private lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: PrepositionQuizViewModel by viewModels { viewModelFactory }
    private val disposable = CompositeDisposable()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        //prepositionQuizViewModel =
        //        ViewModelProvider(this).get(PrepositionQuizViewModel::class.java).
        val root = inflater.inflate(R.layout.fragment_preposition_quiz, container, false)
        viewModelFactory = ViewModelFactory(this.requireContext())


        val textView: TextView = root.findViewById(R.id.text_gallery)
        disposable.add(viewModel.question
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ textView.text = it.question },
                { error ->  }))
        /*viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = "Quiz"
        })*/
        return root
    }
}
