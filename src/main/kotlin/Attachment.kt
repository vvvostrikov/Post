sealed class Attachment(val type: String) {

}

data class AttachmentVideo(val videoName: String) : Attachment("video") {

}

data class AttachmentPhoto(val photoName: String): Attachment("photo") {

}

data class AttachmentText(val textName: String): Attachment("text") {
}

data class AttachmentLink(val linkName: String): Attachment("link") {

}