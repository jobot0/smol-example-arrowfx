package to.jobo.arrowavatarish.core

import arrow.fx.IO

class GetAvatarFromNameUseCase(private val avatarRepository: AvatarRepository) {
    fun execute(name: String): IO<Avatar?> {
        return avatarRepository.getAvatarFromName(name)
    }
}