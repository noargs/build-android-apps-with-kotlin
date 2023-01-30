package github.noargs.dynamicfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val starSignId = arguments?.getInt(STAR_SIGN_ID, 0) ?: 0
        setStarSignData(starSignId)
    }

    private fun setStarSignData(starSignId: Int) {

        when (starSignId) {
            R.id.aquarius -> {
                starSign?.text = getString(R.string.aquarius)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_aquarius))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_aquarius) )
            }
            R.id.pisces -> {
                starSign?.text = getString(R.string.pisces)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_pisces))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_pisces))
            }
            R.id.aries -> {
                starSign?.text = getString(R.string.aries)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_aries))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_aries))
            }
            R.id.taurus -> {
                starSign?.text = getString(R.string.taurus)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_taurus))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_taurus))
            }
            R.id.gemini -> {
                starSign?.text = getString(R.string.gemini)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_gemini))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_gemini))
            }
            R.id.cancer -> {
                starSign?.text = getString(R.string.cancer)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_cancer))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_cancer))
            }
            R.id.leo -> {
                starSign?.text = getString(R.string.leo)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_leo))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_leo))
            }
            R.id.virgo -> {
                starSign?.text = getString(R.string.virgo)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_virgo))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_virgo))
            }
            R.id.libra -> {
                starSign?.text = getString(R.string.libra)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_libra))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_libra))
            }
            R.id.scorpio -> {
                starSign?.text = getString(R.string.scorpio)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_scorpio))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_scorpio))
            }
            R.id.sagittarius -> {
                starSign?.text = getString(R.string.sagittarius)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_sagittarius))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_sagittarius))
            }
            R.id.capricorn -> {
                starSign?.text = getString(R.string.capricorn)
                symbol?.text = getString(R.string.symbol, getString(R.string.symbol_capricorn))
                dateRange?.text = getString(R.string.date_range, getString(R.string.date_capricorn))
            }
            else -> {
                Toast.makeText(context, getString(R.string.unknown_star_sign), Toast.LENGTH_LONG)
                    .show();
            }

        }
    }

    companion object {
        private const val STAR_SIGN_ID = "STAR_SIGN_ID"

        fun newInstance(starSignId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(STAR_SIGN_ID, starSignId)
                }
        }
    }



}