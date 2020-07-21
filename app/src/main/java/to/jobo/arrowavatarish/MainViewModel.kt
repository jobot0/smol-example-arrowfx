package to.jobo.arrowavatarish

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import to.jobo.arrowavatarish.MainViewModel.ViewState.Error
import to.jobo.arrowavatarish.MainViewModel.ViewState.Success
import to.jobo.arrowavatarish.core.AvatarRepository
import to.jobo.arrowavatarish.core.GetAvatarFromNameUseCase

class MainViewModel(private val avatarRepository: AvatarRepository) : ViewModel() {
    private val getAvatarFromNameUseCase: GetAvatarFromNameUseCase =
        GetAvatarFromNameUseCase(avatarRepository)

    var viewState: MutableLiveData<ViewState> = MutableLiveData()

    init {
        getAvatarFromNameUseCase.execute("jordan").unsafeRunAsync { result ->
            result.fold(
                {
                    viewState.postValue(Error)
                },
                {
                    viewState.postValue(Success(it?.imagePath))
                }
            )
        }
    }

    sealed class ViewState {
        object Error: ViewState()
        data class Success(val imagePath: String?): ViewState()
    }

}