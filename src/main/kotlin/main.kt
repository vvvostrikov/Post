fun main() {
    val posts = WallService
    var arrayOfAttachments = emptyArray<Attachment>()
    val video = AttachmentVideo( "Как пожарить сыр на сковородке")
    val text = AttachmentText("Всего 2 минуты в день и вы забудете о боли..")
    val photo = AttachmentPhoto("запомни и забудь")
    val link = AttachmentLink("https://netology.ru/")

    arrayOfAttachments += video
    arrayOfAttachments += text
    arrayOfAttachments += photo
    arrayOfAttachments += link
    val post1 = posts.add(Post(1, 1, 1, 1, 1, "65",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, 1, true, true, true,
        true, true, true, 1, null, arrayOfAttachments))
    val post2 = posts.update(Post(1, 1, 1, 1, 1, "32",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, 1, true, true,
        true, true, true, true, 1, null, arrayOfAttachments))
    println(post1.id)
    println(post2)
}
data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String?,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Any,
    val copyright: Any,
    val likes: Any,
    val reposts: Any,
    val views: Any,
    val postType: String?,
    val postSource: Any,
    val geo: Any,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAdds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int,
    val copy_history: Array<Post>?,
    val attachment: Array<Attachment>)
object WallService {
    private var posts = emptyArray<Post>()
    private var postId = 1

    fun add(post: Post): Post {

        post.copy(id = postId)
        posts += post
        postId++
        return posts.last()
    }
    fun update(post: Post): Boolean {
        for ((index, post1) in posts.withIndex()) {
            return if (post1.id == post.id) {
                posts[index] = post.copy(
                    ownerId = post.ownerId + 1,
                    fromId = post.fromId + 1,
                    createdBy = post.createdBy + 1,
                    replyOwnerId = post.replyOwnerId + 1,
                    replyPostId = post.replyPostId + 1,
                    signerId = post.signerId + 1,
                    postponedId = post.postponedId + 1
                )
                true
            } else {
                false
            }
        }
        return false
    }
}
