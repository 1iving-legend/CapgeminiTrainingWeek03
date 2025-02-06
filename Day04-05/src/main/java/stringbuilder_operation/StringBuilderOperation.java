package stringbuilder_operation;

public class StringBuilderOperation {

    public static String perform(){
        StringBuilder sb = new StringBuilder("");
        String value = "hello";
        sb.append(value);
        System.out.println(sb);
        sb.reverse();
        value=sb.toString();
        return value;
    }
    public static void main(String[] args) {

        System.out.println(perform());

    }
}
