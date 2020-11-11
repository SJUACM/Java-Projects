import java.util.HashSet;

public class IsUnique {
    public static void main(String [] args){

    }

     /*  1.1 Is Unique:
    Implement an algorithm to determine if a String has all unique characters. What if you cannot use additional data structures?
            */

    public static boolean IsUniqueSet(String s) {
        boolean result;
        HashSet<Character> hashSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            hashSet.add(s.charAt(i));
        }

        if (s.length() == hashSet.size()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    //Not allowed to use another data structure
    public static boolean IsUniqueBruteForce(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int k = i + 1; k < s.length(); k++) {
                if (s.charAt(i) == s.charAt(k)) {
                    return false;
                }
            }
        }

        return true;
    }

    //Solve it Using ASCII Codes

    public static boolean IsUniqueAscii(String s){
        int [] symbols = new int[128];
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i);
            if(symbols[val] >=1){
                return false;
            } else{
                symbols[val]++;
            }
        }
        return true;}
}
