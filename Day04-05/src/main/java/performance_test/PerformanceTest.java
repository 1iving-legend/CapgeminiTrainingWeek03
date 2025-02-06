package performance_test;

public class PerformanceTest {
    public static void main(String[] args) {
        long startTime, endTime;

        // Warm up JVM
        for (int i = 0; i < 5; i++) {
            testStringBuilder();
            testStringBuffer();
        }

        System.out.println("Final Performance Comparison:");

        // Testing StringBuilder Performance
        startTime = System.nanoTime();
        testStringBuilder();
        endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) + " ns");

        // Testing StringBuffer Performance
        startTime = System.nanoTime();
        testStringBuffer();
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) + " ns");
    }

    private static void testStringBuilder() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 100000; i++) {
            sb.append("hello");
        }
    }

    private static void testStringBuffer() {
        StringBuffer sbf = new StringBuffer("");
        for (int i = 0; i < 100000; i++) {
            sbf.append("hello");
        }
    }
}
