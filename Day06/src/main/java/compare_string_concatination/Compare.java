package compare_string_concatination;



public class Compare {

    public static void stringConcatination(String value, int it)
    {
        String res="";
        for(int i=0;i<it;i++)
        {
            res.concat(value);
        }
    }
    public static void stringBufferConcatination(String value, int it)
    {
        StringBuffer br= new StringBuffer();
        for(int i=0;i<it;i++)
        {
            br.append(value);
        }
    }
    public static void stringBuilderConcatination(String value, int it)
    {
        StringBuilder br= new StringBuilder();
        for(int i=0;i<it;i++)
        {
            br.append(value);
        }
    }


    public static void main(String[] args) {



        double stringtime, buffertime,buildertime;

        long sf=System.nanoTime();
        stringConcatination("hello",100);
        long sl=System.nanoTime();
        stringtime=sl-sf;

        long bf=System.nanoTime();
        stringBufferConcatination("hello",100);
        long bl=System.nanoTime();
        buffertime=bl-bf;

        long buf=System.nanoTime();
        stringBuilderConcatination("hello",100);
        long bul=System.nanoTime();
        buildertime=bul-buf;

        System.out.println("for 100 iteration");
        System.out.println("Time taken by string :"+ stringtime);
        System.out.println("Time taken by stringbuffer :"+ buffertime);
        System.out.println("Time taken by stringbuilder :"+ buildertime);



         sf=System.nanoTime();
        stringConcatination("hello",1000);
         sl=System.nanoTime();
        stringtime=sl-sf;

        bf=System.nanoTime();
        stringBufferConcatination("hello",1000);
        bl=System.nanoTime();
        buffertime=bl-bf;

         buf=System.nanoTime();
        stringBuilderConcatination("hello",1000);
        bul=System.nanoTime();
        buildertime=bul-buf;

        System.out.println("for 1000 iteration");
        System.out.println("Time taken by string :"+ stringtime);
        System.out.println("Time taken by stringbuffer :"+ buffertime);
        System.out.println("Time taken by stringbuilder :"+ buildertime);


        sf=System.nanoTime();
        stringConcatination("hello",100000);
        sl=System.nanoTime();
        stringtime=sl-sf;

        bf=System.nanoTime();
        stringBufferConcatination("hello",100000);
        bl=System.nanoTime();
        buffertime=bl-bf;

        buf=System.nanoTime();
        stringBuilderConcatination("hello",100000);
        bul=System.nanoTime();
        buildertime=bul-buf;

        System.out.println("for 100000 iteration");
        System.out.println("Time taken by string :"+ stringtime);
        System.out.println("Time taken by stringbuffer :"+ buffertime);
        System.out.println("Time taken by stringbuilder :"+ buildertime);

    }

}
