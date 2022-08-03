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
    val post1 = posts.add(Post(0, 1, 1, 1, 1, "65",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, 1, true, true, true,
        true, true, true, 1, null, arrayOfAttachments))
    val post2 = posts.update(Post(1, 1, 1, 1, 1, "32",1, 1, true ,1,1,1,
        1, 1, "1", 1, true, 1, true, true,
        true, true, true, true, 1, null, arrayOfAttachments))

    val comment = Comment(
        1, 1, 1, 1, "1", 1, 1, 1, video, arrayOfAttachments, 1
    )

    WallService.createComment(comment)

    println(post1.id)
    println(post2)
    println(comment)


}