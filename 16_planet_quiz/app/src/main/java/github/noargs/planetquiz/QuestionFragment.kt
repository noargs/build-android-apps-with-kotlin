package github.noargs.planetquiz

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.RuntimeException

interface AnswersListener {
    fun onSelected(questionId: Int)
}

class QuestionFragment : Fragment(), View.OnClickListener {

    private lateinit var answersListener: AnswersListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AnswersListener) {
            answersListener = context
        } else {
            throw RuntimeException("Must implement AnswersListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val planets = listOf<View>(
            view.findViewById(R.id.largest_planet),
            view.findViewById(R.id.most_moons),
            view.findViewById(R.id.side_spinning)
        )

        planets.forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        view?.let { question ->
            answersListener.onSelected(question.id)
        }
    }


}