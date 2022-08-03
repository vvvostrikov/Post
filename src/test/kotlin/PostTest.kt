import org.junit.Test

import org.junit.Assert.*

class PostTest {

        @Test
        fun addTest() {
            val service = WallService
            val video = AttachmentVideo( "Как пожарить сыр на сковородке")
            val text = AttachmentText("Всего 2 минуты в день и вы забудете о боли..")
            val photo = AttachmentPhoto("запомни и забудь")
            val link = AttachmentLink("https://netology.ru/")
            val arrayOfAttachments = arrayOf(video, text, photo, link)
            var result = service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, 1, true, true,
                true, true, true, true, 1, null, arrayOfAttachments)).id



            assertNotEquals(0, result)
        }

        @Test
        fun updateTestTrue() {
            val service = WallService
            val video = AttachmentVideo( "Как пожарить сыр на сковородке")
            val text = AttachmentText("Всего 2 минуты в день и вы забудете о боли..")
            val photo = AttachmentPhoto("запомни и забудь")
            val link = AttachmentLink("https://netology.ru/")
            val arrayOfAttachments = arrayOf(video, text, photo, link)
            service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, 1, true, true,
                true, true, true, true, 1, null, arrayOfAttachments))
            service.add(Post(2, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, 1, true, true,
                true, true, true, true, 1, null, arrayOfAttachments))
            val update = Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, 1, true, true,
                true, true, true, true, 1,  null,arrayOfAttachments)
            val result = service.update(update)
            assertTrue(result)
        }

        @Test
        fun updateTestFalse() {
            val service = WallService
            val video = AttachmentVideo( "Как пожарить сыр на сковородке")
            val text = AttachmentText("Всего 2 минуты в день и вы забудете о боли..")
            val photo = AttachmentPhoto("запомни и забудь")
            val link = AttachmentLink("https://netology.ru/")
            val arrayOfAttachments = arrayOf(video, text, photo, link)
            service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, 1, true, true,
                true, true, true, true, 1,null, arrayOfAttachments))
            service.add(Post(2, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, 1, true, true,
                true, true, true, true, 1,null, arrayOfAttachments))
            val update = Post(3, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, 1, true, true,
                true, true, true, true, 1,  null,arrayOfAttachments)
            val result = service.update(update)
            assertFalse(result)
        }
    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {

        var arrayOfAttachments = emptyArray<Attachment>()
        val video = AttachmentVideo("Как пожарить сыр на сковородке")
        arrayOfAttachments += video
        val comment = Comment(
            500, 500, 1, 1, "1", 1, 1, 1, video , arrayOfAttachments, 1
        )
        val post1 = WallService.add(
            Post(
                0,
                1,
                1,
                1,
                1,
                "1",
                1,
                1,
                true,
                1,
                1,
                1,
                1,
                1,
                "1",
                1,
                true,
                1,
                true,
                true,
                true,
                true,
                true,
                true,
                1,
                null,
                arrayOfAttachments
            )
        )
        WallService.createComment(comment)
    }

    @Test
    fun createCommentTest() {
        var arrayOfAttachments = emptyArray<Attachment>()
        val video = AttachmentVideo("Как пожарить сыр на сковородке")
        arrayOfAttachments += video
        val post1 = WallService.add(
            Post(
                1,
                1,
                1,
                1,
                1,
                "1",
                1,
                1,
                true,
                1,
                1,
                1,
                1,
                1,
                "1",
                1,
                true,
                1,
                true,
                true,
                true,
                true,
                true,
                true,
                1,
                null,
                arrayOfAttachments
            )
        )
        val comment = Comment(
            1, 500, 1, 1, "1", 1, 1, 1, video , arrayOfAttachments, 1
        )
        WallService.createComment(comment)
    }
}