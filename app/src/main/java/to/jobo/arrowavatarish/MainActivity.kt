package to.jobo.arrowavatarish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import to.jobo.arrowavatarish.data.RestAvatarRepository

class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val avatarRepository = RestAvatarRepository(application)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(avatarRepository)).get(MainViewModel::class.java)

        mainViewModel.viewState.observe(this, Observer { updateView(it) })

    }

    private fun updateView(viewState: MainViewModel.ViewState) {
        when(viewState) {
            MainViewModel.ViewState.Error -> Log.d("TODO", "IMPLEMENT ERROR")
            is MainViewModel.ViewState.Success -> Log.d("TODO", "IMPLEMENT SUCCESS")
        }
    }
}