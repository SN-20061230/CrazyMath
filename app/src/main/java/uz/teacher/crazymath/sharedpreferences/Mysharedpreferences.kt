package uz.teacher.crazymath.sharedpreferences

import android.content.Context
import android.content.SharedPreferences

class MySharedPreference {

    companion object {
        private var INSTANCE: SharedPreferences? = null


        fun getInstance(context: Context): SharedPreferences {
            if (INSTANCE == null) {
                INSTANCE = context.getSharedPreferences("records", Context.MODE_PRIVATE)
            }
            return INSTANCE!!
        }
    }


}