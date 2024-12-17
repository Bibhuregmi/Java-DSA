package string;
public class tries {
    public class TrieNode{
        TrieNode[] children = new TrieNode[26]; //Creating a trienode that contains array of lower case character with index respctive to 'a' =0, 'b'=1,...'z'='25'
        boolean flag = false; //flag to mark the end of the string true if the string has ended. 

        boolean containsCharacter(char ch){
            return children[ch - 'a'] != null; //check if character is present in the node or not. 
        }

        void put(char ch, TrieNode node){
            children[ch - 'a'] = node; //new reference node for the character will be created  
        }

        TrieNode get(char ch){
            return children[ch - 'a']; 
        }

        boolean isEnd(){
           return flag; 
        }

        boolean setEnd(){
            return flag =true; 
        }
    }
    private TrieNode root = new TrieNode(); 
    //constructor to construct a trie
    public tries() {
        root = new TrieNode(); //creating a empty root trieNode at initial.
    }
    //inserting the string in the trie 
    public void insert(String word){
        TrieNode node = root; 
        for(int i=0; i<word.length(); i++){
            if(!node.containsCharacter(word.charAt(i))){
                node.put(word.charAt(i), new TrieNode()); 
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd(); 
    }
    //checking if the string exists in the trie
    public boolean search(String word){
        TrieNode node = root; 
        for(int i=0; i<word.length(); i++){
            if(!node.containsCharacter(word.charAt(i))){
                return false; 
            }
            node = node.get(word.charAt(i));
        }
        return node.isEnd(); //it will return true only if the string is complete, meaning it has reached to the end of the chain of the node references 
    }
    //checking if there are ceratin characters in the string
    public boolean startsWith(String prefix){
        TrieNode node = root; 
        for(int i=0; i<prefix.length(); i++){
            if(!node.containsCharacter(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true; 
    }

    public static void main(String[] args) {
        tries Trie = new tries(); 
        Trie.insert("apple");
        Trie.insert("elephant");
        Trie.insert("toronto");
        System.out.println(Trie.search("appl"));
        System.out.println(Trie.startsWith("ele"));
    }
}