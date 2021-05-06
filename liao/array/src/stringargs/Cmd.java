package stringargs;
import java.util.Arrays;
import sort.BubbleSort;

/**
 * 先编译，在执行的时候追加参数，通过foreach 可以捕获参数，如何解析参数需要程序自定义。
 * 
 */
public class Cmd {
    public static void main(String[] args){
        for(String arg : args){
            if("-version".equals(arg)){
                System.out.println("arg:"+arg);
                System.out.println("jdk11.0.11");
            }
            break;
        }
        int [] arr2 = {1,3,5,2,5};
        BubbleSort.sort_up(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}
