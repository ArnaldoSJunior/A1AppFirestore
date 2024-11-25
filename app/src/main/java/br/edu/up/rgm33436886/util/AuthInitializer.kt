package br.edu.up.rgm33436886.util

import android.content.Context

class AuthInitializer : Initializer<FirebaseAuth> {
    // The host '10.0.2.2' is a special IP address to let the
    // Android emulator connect to 'localhost'.
    private val AUTH_EMULATOR_HOST = "10.0.2.2"
    private val AUTH_EMULATOR_PORT = 9099

    override fun create(context: Context): FirebaseAuth {
        val firebaseAuth = Firebase.auth
        // Use emulators only in debug builds
        if (BuildConfig.DEBUG) {
            firebaseAuth.useEmulator(AUTH_EMULATOR_HOST, AUTH_EMULATOR_PORT)
        }
        return firebaseAuth
    }

    // No dependencies on other libraries
    override fun dependencies(): MutableList<Class<out Initializer<*>>> = mutableListOf()
}