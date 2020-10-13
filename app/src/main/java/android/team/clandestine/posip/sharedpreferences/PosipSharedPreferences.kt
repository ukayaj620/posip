package android.team.clandestine.posip.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object PosipSharedPreferences {

    private const val LOGIN = "has_login"

    private fun getPosipPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    fun setLogin(login: Int, context: Context) {
        getPosipPreferences(context).edit().putInt(LOGIN, login).apply()
    }

    fun getLogin(context: Context): Int {
        return getPosipPreferences(context).getInt(LOGIN, 0)
    }

    fun signUp(username: String, password: String, role: Int, context: Context) {
        getPosipPreferences(context).edit().putString(username, password).apply()
        getPosipPreferences(context).edit().putInt(username+"role", role).apply()
    }

    fun signIn(username: String, password: String, context: Context): Boolean {
        if (getPosipPreferences(context).getString(username, "") == password) {
            setLogin(getPosipPreferences(context).getInt(username+"role", 0), context)
            return true
        }
        return false
    }
}