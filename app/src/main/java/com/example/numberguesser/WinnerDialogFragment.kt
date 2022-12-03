package com.example.numberguesser

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.DialogFragment


class WinnerDialogFragment: DialogFragment(R.layout.fragment_winner_dialog){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val retryBtn:Button = view.findViewById(R.id.retryBtn)
        retryBtn.setOnClickListener {
            val m1:MainActivity = activity as MainActivity;
            m1.generateNew()
            dismiss()
        }
        super.onViewCreated(view, savedInstanceState)
    }
}