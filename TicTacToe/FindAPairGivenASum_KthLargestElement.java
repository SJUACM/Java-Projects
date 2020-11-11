import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindAPairGivenASum_KthLargestElement {

    public static void main(String[] args) {

        int [] test_array = {5,3,2,9,4};
        sumPair2Pointers(test_array,9);
        sumPairBruteForce(test_array,9);
        sumPairMapping(test_array,9);

        System.out.println(Arrays.toString(test_array));
        System.out.println(kthSmallestElement(test_array,4));


    }

    public static void sumPair2Pointers(int [] array, int sum){
        Arrays.sort(array);

        int left =0;
        int right = array.length-1;

        while(left<right){
            if(array[left]+array[right]==sum){
                System.out.println("Pair found at index "+ left+" and "+ right);
                System.out.println("Dont forget we sorted the array");
                System.out.println(Arrays.toString(array));
            }
            if(array[left]+array[right]<sum){
                left++;
            } else{
                right--;
            }
        }

    }


    public static void sumPairBruteForce(int [] array, int sum) {
        for(int i=0;i<array.length;i++){
            for(int k=1;k<array.length;k++){
                if(array[i]+array[k]==sum){
                    System.out.println("Pair found at index "+ i+" and "+ k);
                    System.out.println(Arrays.toString(array));
                    return;
                }
            }
        }


    }

    public static void sumPairMapping(int [] array, int sum){
        Map<Integer,Integer> mapping = new HashMap<>();
        int temp = 0;

        for(int i=0; i<array.length;i++){
            temp = sum - array[i];

            if(mapping.containsKey(temp)){
                System.out.println("Pair found at "+ i+ " and "+ mapping.get(temp));
                System.out.println(Arrays.toString(array));
            }else{
                mapping.put(array[i],i);
            }

        }

    }


    public static int kthSmallestElement(int [] array, int index){
        Arrays.sort(array);
        return array[index-1];

    }










}


