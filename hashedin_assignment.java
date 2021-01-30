// "static void main" must be defined in a public class.
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str1 = "abcc";
        String str2 = "abbc";
        
        System.out.println(checkAnagram(str1,str2));
        
    }
    public static boolean checkAnagram(String str1, String str2) {
        if(str1.length() != str2.length())
            return false;
        
        else {
            int n = str1.length();
            int[] arr = new int[256];
            for(int i=0; i<n; i++) {
                arr[str1.charAt(i)]++;
                arr[str2.charAt(i)]--;
            }
            
        for(int i=0; i<256; i++) {
            if(arr[i] != 0) {
                return false;
            }
        }
           return true; 
        }
    }
}