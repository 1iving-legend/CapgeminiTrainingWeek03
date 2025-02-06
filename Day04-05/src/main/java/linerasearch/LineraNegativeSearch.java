package linerasearch;

public class LineraNegativeSearch {

    public static int IsNegative(int [] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]<0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int [] arr={1,78,96,-5,6,7,-7};
        System.out.println(IsNegative(arr));
    }

}
