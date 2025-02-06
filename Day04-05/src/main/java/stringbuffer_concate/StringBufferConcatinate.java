package stringbuffer_concate;



public class StringBufferConcatinate {


    public static StringBuffer convert(String value)
    {
        StringBuffer sb = new StringBuffer("");

        String [] array=value.split(" ");
        int i=0;
        while(i<array.length){
            sb.append(array[i]);
            sb.append(" ");
            i++;
        }
        return sb;

    }
    public static void main(String[] args) {

        System.out.println(convert( "Hello World" ));
    }
}
