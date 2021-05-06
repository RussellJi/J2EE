package sort;

import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        int [] arr2 = {1,3,5,2,5};
        BubbleSort.sort_up(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
