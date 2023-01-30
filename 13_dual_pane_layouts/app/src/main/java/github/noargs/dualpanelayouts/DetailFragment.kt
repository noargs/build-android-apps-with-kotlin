package github.noargs.dualpanelayouts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class DetailFragment : Fragment() {

    private val starSign: TextView?
        get() = view?.findViewById(R.id.star_sign)

    private val symbol: TextView?
        get() = view?.findViewById(R.id.symbol)

    private val dateRange: TextView?
        get() = view?.findViewById(R.id.date_range)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    // TODO: add all the start signs here
    fun setStarSignData(starSignId: Int) {

        when (starSignId) {
            R.id.aquarius -> {
                starSign?.text = getString(R.string.aquarius)
                symbol?.text = getString(R.string.symbol, R.string.symbol_aquarius.toString())
                dateRange?.text = getString(R.string.date_range, R.string.date_aquarius.toString() )
            }
        }
    }



}