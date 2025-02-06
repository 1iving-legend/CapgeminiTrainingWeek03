
import org.junit.jupiter.api.Test;
import stringbuilder_operation.StringBuilderOperation;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringBuilderTest {

    static StringBuilderOperation sb=new StringBuilderOperation();
    String val=sb.perform();

    @Test
    public void test1()
    {
         assertEquals("olleh",val);
    }

}
