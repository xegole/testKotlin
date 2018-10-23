package com.bigthinkapps.calculator.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigthinkapps.calculator.R
import com.bigthinkapps.calculator.entity.GetAllCommercesResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_page2.*


class Page2Fragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val image = arguments?.getInt(ARG_SECTION_NUMBER)
        if (image != null) {
            imageViewPage.setImageResource(image)
        }

        button.setOnClickListener { finishActivity() }
    }

    private fun finishActivity(){
        activity!!.finish()
    }


    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): Page2Fragment {
            val fragment = Page2Fragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}