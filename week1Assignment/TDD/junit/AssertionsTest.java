import org.junit.Test;
import static org.junit.Assert.*;

public class AssertionsTest {

    @Test
    public void testAssertions() {

        // Assert Equals
        assertEquals(10, 5 + 5);

        // Assert True
        assertTrue(10 > 5);

        // Assert False
        assertFalse(5 > 10);

        // Assert Null
        String str1 = null;
        assertNull(str1);

        // Assert Not Null
        String str2 = "JUnit";
        assertNotNull(str2);

        // Assert Same
        String s1 = "Java";
        String s2 = s1;
        assertSame(s1, s2);

        // Assert Not Same
        String s3 = new String("Java");
        assertNotSame(s1, s3);
    }
}