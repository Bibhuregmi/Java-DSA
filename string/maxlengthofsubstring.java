//Leetcode Medium Question 3
//Need to find the length of the longest substring without the repeating characters
package string;

import java.util.HashSet;

public class maxlengthofsubstring {

    static int lengthofSubstring(String s){                                            
        int maxLength = 0;                                                                                       
        for(int i=0; i<s.length(); i++){
            for(int j= i+1; j<s.length(); j++){
                String subString = s.substring(i, j); 
                if (hasuniquechar(subString)){
                    maxLength = Math.max(maxLength, subString.length()); 
                }
            }
        } 
        return maxLength; 
    }

    static boolean hasuniquechar(String s){
        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    return false; 
                }
            }
        }
        return true; 
    }  
    //THIS IS THE BRUTE-FORCE SOLUTION COMING WITH THE TIME-COMPLEXITY OF O(N^4) WHICH IS REALLY BADDDDDDD. 
    //HERE IS THE OPTIMIZED SOLUTION TO THE PROBLEM USING HASHSET AND SLIDING WINDOW
    
    static int lengthofsubString(String s){
        int maxLength = 0; 
        HashSet<Character> set = new HashSet<>();
        int left = 0; 
        int right = 0; 

        while( right < s.length()){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++; 
                maxLength = Math.max(maxLength, right - left); 
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength; 
    }
    //SO THE INUTTION ON SOLVING THE OPTIMIZED SOLUTION IS THAT WE WILL ADD ALL THE CHARACTERS IN THE HASHSET AND CREATE A WINDOW, IF A RIGHT POINTERS FINDS ANY DUPLICATE VALUE 
    //WE WILL MOVE THE LEFT POINTER AND REMOVE THE CHARACTER AT LEFT POINTER FROM THE HASHSET. 
    public static void main(String[] args) {
        String s = "abcabcbb";
        int ans = lengthofsubString(s);
        int sna = lengthofSubstring(s);
        System.out.println(ans);
        System.out.println(sna);

    }
}