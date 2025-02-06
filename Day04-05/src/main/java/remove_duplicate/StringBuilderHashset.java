package remove_duplicate;

import java.util.HashSet;
import java.util.Iterator;

public class StringBuilderHashset {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder("");
        HashSet<String> set=new HashSet<String>();
        String value="The greatest glory in living lies not in never falling, but in rising every time we fall.";

        String [] words=value.split(" ");
        int i=0;
        while(i<words.length)
        {
            if(set.contains(words[i]))
            {
                i++;
            }
            else {
                set.add(words[i]);
                i++;
            }
        }
        Iterator<String> it=set.iterator();

        while(it.hasNext())
        {
            sb.append(it.next());
            sb.append(" ");
        }
        String result=sb.toString();
        System.out.println(sb);
        System.out.println(result);
    }
}
