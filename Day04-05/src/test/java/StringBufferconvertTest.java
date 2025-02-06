import org.junit.jupiter.api.Test;
import stringbuffer_concate.StringBufferConcatinate;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class StringBufferconvertTest {

    StringBufferConcatinate sbc = new StringBufferConcatinate();
    @Test
    public void test2()
    {
        assertNotEquals("abc", sbc.convert("abc"));
    }
}
