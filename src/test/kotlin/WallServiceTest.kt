import org.junit.Test

import org.junit.Assert.*

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService
        val result = service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1 ))



        assertNotEquals(0, result.id)
    }

    @Test
        fun updateTestTrue() {
            val service = WallService
            service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, true, true, true,
                true, true, true, 1 ))
            service.add(Post(0, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, true, true, true,
                true, true, true, 1 ))
            val update = Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
                1, 1, "1", 1, true, true, true, true,
                true, true, true, 1)
            val result = service.update(update)
            assertTrue(result)
        }
    @Test
    fun updateTestFalse() {
        val service = WallService
        service.add(Post(1, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1 ))
        service.add(Post(2, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1 ))
        val update = Post(3, 1, 1, 1, 1, "1",1, 1, true ,1,1,1,
            1, 1, "1", 1, true, true, true, true,
            true, true, true, 1)
        val result = service.update(update)
        assertFalse(result)
    }
}