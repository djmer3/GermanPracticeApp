package xyz.dmercer.myapplication.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import xyz.dmercer.myapplication.persistence.QuestionDAO

class PrepositionQuizViewModel(private val questionDAO: QuestionDAO) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is preposition quiz starter"
    }
    val text: LiveData<String> = _text

    val question = questionDAO.getById(1)
}