package org.example.lesson20;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailUtilTest {
    // mk@mail.ru -> true
    // 20:20
    @Test
    public void normalEmailTest() {
        // EmailUtil.isEmail("mk@mail.ru")
//        assertEquals(
//            true,
//            EmailUtil.isEmail("mk@mail.ru")
//        );
        assertTrue("mk@mail.ru is email",
                EmailUtil.isEmail("mk@mail.ru"));

        assertFalse(
                "mmk is not a email",
                EmailUtil.isEmail("mmk")
        );

        assertFalse("null is not email",
                EmailUtil.isEmail(null));

        assertFalse("misha@golubkov@mail.ru is not email",
                EmailUtil.isEmail("misha@golubkov@mail.ru"));
    }
}
