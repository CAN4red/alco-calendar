package com.example.alcocalendar.features.session_manage.media.domain.model

data class MediaModel(
    val name: String,
    val content: ByteArray,
    val path: String,
    val type: MediaType,
    val timeStamp: Long,
) {
    // Generated Code
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MediaModel

        if (timeStamp != other.timeStamp) return false
        if (name != other.name) return false
        if (!content.contentEquals(other.content)) return false
        if (path != other.path) return false
        if (type != other.type) return false

        return true
    }

    // Generated Code
    override fun hashCode(): Int {
        var result = timeStamp.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + content.contentHashCode()
        result = 31 * result + path.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}
