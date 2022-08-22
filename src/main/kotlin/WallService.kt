object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
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

    fun createComment(comment: Comment) {
        for (post in posts) {
            if (comment.id == post.id) {
                comments += comment
                return
            }
        }
        throw PostNotFoundException("not comments")
    }
}