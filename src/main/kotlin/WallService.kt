object WallService {
    private var posts = emptyArray<Post>()
    var postId = 1

    fun add(post: Post): Post {
        post.copy(id = postId)
        posts += post
        postId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, originalPost) in posts.withIndex()) {
            return if (post.id == originalPost.id) {
                posts[index] = post.copy(ownerId = post.ownerId, date = post.date)
                true
            } else {
                false
            }
        }
        return false
    }
}