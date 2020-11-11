public class ReverseString {

    public static void main(String [] args){
        /*
        Testing conditions to ensure the methods are working correctly.


        System.out.println(reverseString_two("candy"));
        System.out.println(reverseString_three("lollipop"));
        System.out.println(reverseString_one("apple"));
        System.out.println(isPalindrome("dog"));
        System.out.println(isPalindrome("mom"));
        */

    }

    public static String reverseString_one(String reverseMe){

        String result = "";
        int length = reverseMe.length();

        for(int i = length -1; i >=0; i--){
            result = result + reverseMe.charAt(i);
        }


        return result;}

    public static String reverseString_two(String reverseMe){
        StringBuilder sb = new StringBuilder();

        for(int i =reverseMe.length()-1;i>=0;i--){
            sb.append(reverseMe.charAt(i));
        }
    return sb.toString();}


    public static String reverseString_three(String reverseMe){
        StringBuilder sb = new StringBuilder(reverseMe);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String toCompare){

        String reversed = reverseString_one(toCompare);

        return reversed.equals(toCompare);
    }
}
