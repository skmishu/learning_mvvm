package co.jatri.mvvmanddagger.utils

import android.app.Application
import dagger.Module
import javax.inject.Inject


@Module
class SharedPrefHelper @Inject constructor(application: Application){

    private var sharedPreferences = application.getSharedPreferences("dagger",0)
    fun putValue(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getValue(key: String): String? {
        return sharedPreferences.getString(key, "")
    }

    fun clearAllCache() {
        sharedPreferences.edit().clear().apply()
    }
}