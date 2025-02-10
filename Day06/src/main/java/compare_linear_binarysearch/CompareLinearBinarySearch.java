package compare_linear_binarysearch;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class CompareLinearBinarySearch {

public static  int linearSearch(long [] arr,int value)
{
    for(int i=0;i< arr.length;i++)
    {
        if(arr[i]==value) {
            return i;
        }
    }
    return -1;
}

public static int binarySearch(long arr[],int value)
{

    //Arrays.sort(arr);

    int left=0;
    int right=arr.length-1;
    while(left<right)
    {
        int mid=left+(right-left)/2;
        if(arr[mid]==value)
        {
            return mid;
        }

        if(arr[mid]<value){
            left=mid+1;
        }
        else{
            right=mid-1;
        }
    }
    return -1;
}



    public static void main(String[] args) {

    long []array= new long[1000000];
        for(int i=0;i<array.length-5;i++)
        {
            array[i]=i+array[i+5];
           if(i>5)
            {
               array[i]-=array[i+5-7];         }
        }


    for(int i=0;i<5;i++)
    {
        binarySearch(array,183256);
        linearSearch(array,183256);
    }



    long lineartime,binarytime;

    long f=System.currentTimeMillis();
        linearSearch(array,183256);
    long l= System.currentTimeMillis();
        lineartime=l-f;


        long fb=System.currentTimeMillis();
        binarySearch(array,183256);
        long lb= System.currentTimeMillis();
        binarytime=lb-fb;

        System.out.println("Time taken by linear search: "+ lineartime);
        System.out.println("Time taken by binary search: "+ binarytime);



    }


}
