import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MissingNumber_Duplicates {

    public static void main(String [] args){

       /*
       These are here for testing purposes.

        int [] testArray = {1,2,4};
        System.out.println(sumMissingNumber(testArray,4));
        System.out.println(xorMissingNumber(testArray,4));

        int [] testArray2 = {1,1,3,3};
        System.out.println(setMissingNumbers(testArray2,4));

    */
    }

    public static int sumMissingNumber(int array [], int length){

        int result = 0;
        int expectedSum = length *(length+1)/2;
        int actualSum = 0;

        for(int i:array){
            actualSum +=i;
        }

        result =expectedSum - actualSum;


    return result;}

    public static int xorMissingNumber (int array [], int length){
        int result = 0;

        int rangeXor = 0;
        int actualXor = 0;

        for(int i =0; i<length+1 ;i++){
            rangeXor = rangeXor ^ i;
        }

        for(int i: array){
            actualXor = actualXor ^ i;
        }
    result = actualXor -rangeXor;
    return result;}

    public static Pair setMissingNumbers(int [] array, int length){
        List<Integer> duplicates = new ArrayList<Integer>();
        List<Integer> missingNumbers = new ArrayList<Integer>();
        List<Integer> copyOfArray = new ArrayList<Integer>();

        for( int i: array) {
            if (copyOfArray.contains(i)) {
                if (!duplicates.contains(i)) {
                    duplicates.add(i);
                    }
                } else {
                    copyOfArray.add(i);
                }
            }


        for(int i = 1; i <length+1; i++){
            if( !copyOfArray.contains(i)){
                missingNumbers.add(i);
            }
        }

return new Pair(duplicates,missingNumbers);}
}
