package sort;
import java.util.Arrays;
/**
 * 冒泡排序
 * 
 */
public class BubbleSort{

    /**
     * 冒泡排序：升序
     * @param arr 
     */
    public static void sort_up(int [] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    /**
     * 冒泡排序：降序
     * @param arr
     */
    static void sort_down(int [] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }    
    public static void main(String[] args){
        int [] arr1 = {1,2,3,5,4};
        System.out.println(Arrays.toString(arr1));

        sort_up(arr1);
        // 输出数组，需要引入java.util.Arrays
        System.out.println(Arrays.toString(arr1));

        sort_down(arr1);

        System.out.println(Arrays.toString(arr1));
    }
}