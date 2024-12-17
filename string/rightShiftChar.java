//this question was asked in Amazon OA, question seen in reddit and the objective is to right shift the charcter given in the string by 1. 

package string;

public class rightShiftChar {
    
    public static String rightShift(String string, int index){
        if (string.length() == 0 || index >= string.length() || index < 0){
            return ("Invalid operation!!"); 
        }

        char[] characters = string.toCharArray(); 
        if (index == string.length()-1){
            char lastChar = characters[index];
            for(int i = index; i>0; i--){
                characters[i] = characters[i-1]; 
            }
            characters[0] = lastChar;
        }else{
            char currentChar = characters[index]; 
            for(int i=index; i<string.length()-1; i++){
                characters[i] = characters[i + 1]; 
            }
            characters[string.length()- 1] = currentChar;
        }
        return new String(characters); 
    }
    public static void main(String[] args) {
        String string = "hello"; 
        int index = 5; 
        String result = rightShift(string, index);
        System.out.println("Original String: "+ string);
        System.out.println("Right Shift string: " + result);
    }
}