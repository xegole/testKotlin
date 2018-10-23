package com.bigthinkapps.calculator.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bigthinkapps.calculator.DetailImageActivity
import com.bigthinkapps.calculator.R
import kotlinx.android.synthetic.main.fragment_page.*


class PageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val image = arguments?.getInt(ARG_SECTION_NUMBER)
        if (image != null) {
            imageViewPage.setImageResource(image)
        }

        button.setOnClickListener{goToActivityDetailImage()}
    }

    private fun goToActivityDetailImage(){
        val intent = Intent(context, DetailImageActivity::class.java)
        startActivity(intent)
    }


    companion object {
        private const val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(sectionNumber: Int): PageFragment {
            val fragment = PageFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}