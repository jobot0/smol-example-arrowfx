package to.jobo.arrowavatarish.core

import arrow.fx.IO

interface AvatarRepository {
    fun getAvatarFromName(name: String): IO<Avatar?>

}
