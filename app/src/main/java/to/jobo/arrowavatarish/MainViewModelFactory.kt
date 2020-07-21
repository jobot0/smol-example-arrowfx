package to.jobo.arrowavatarish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import to.jobo.arrowavatarish.core.AvatarRepository

class MainViewModelFactory(private val avatarRepository: AvatarRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        MainViewModel(avatarRepository) as T

}