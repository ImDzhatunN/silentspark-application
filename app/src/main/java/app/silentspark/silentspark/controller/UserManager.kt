package app.silentspark.silentspark.controller

import android.content.Context
import androidx.datastore.preferences.createDataStore
import androidx.datastore.preferences.edit
import androidx.datastore.preferences.preferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager(context: Context) {

    // Create the dataStore and give it a name same as shared preferences
    private val dataStore = context.createDataStore(name = "user_prefs")

    // Create some keys we will use them to store and retrieve the data
    companion object {
        val ACCESS_TOKEN = preferencesKey<String>("ACCESS_TOKEN")
    }

    // Store user data
    // refer to the data store and using edit
    // we can store values using the keys
    suspend fun saveToken(token: String) {
        dataStore.edit {
            it[ACCESS_TOKEN] = token
        }
    }

    // Create an age flow to retrieve age from the preferences
    // flow comes from the kotlin coroutine
    val AcessTokenFlow: Flow<String> = dataStore.data.map {
        it[ACCESS_TOKEN] ?: ""
    }

}
