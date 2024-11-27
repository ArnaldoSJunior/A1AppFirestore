package br.edu.up.rgm33436886.viewmodel

import androidx.lifecycle.ViewModel
import br.edu.up.rgm33436886.Filters

class MainActivityViewModel : ViewModel() {

    var isSigningIn: Boolean = false
    var filters: Filters = Filters.default
}
