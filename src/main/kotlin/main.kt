fun main() {
    val posts = WallService
    val post1 = posts.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, true, true, true,
        true, true, true, 1 ))
    val post2 = posts.update(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, true, true, true,
        true, true, true, 1 ))
    print(post1)
    println(post2)
}
