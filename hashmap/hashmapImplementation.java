import java.util.*;

public class hashmapImplementation {
    
    static class Hashmap<K,V> {
        private class Node{
            K key;
            V value; 

            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;  //this is the total number of elements stored in hashmap
        private int N; //this is the size of the array
        private LinkedList<Node>[] buckets; //buckets array storing linkedlist for the chaining purpose

        @SuppressWarnings("unchecked") //Java doesn't allow to create a generic array directly, so have to create a raw array and cast it to generic type, causing the warning
        public Hashmap(){
            this.N = 4; //initial size of the array
            this.buckets = new LinkedList[4]; //initial size of the bucket
            //initializing each index with empty linkedlist
            for(int i =0; i<buckets.length; i++){
                this.buckets[i] = new LinkedList<>(); 
            }
        }

        //creating a hashcode for each object in the array
        private int hashFunction(K key){
            int hashCode = key.hashCode();
            return Math.abs(hashCode) % buckets.length;
        }
        //searcing for a key in the linkedlist of a specific bucket. 
        private int searchinLinkedList(K key, int bucketIndex){
            LinkedList<Node> linkedlist = buckets[bucketIndex]; //gives linkedlist at the given bucket index
            for(int i =0; i < linkedlist.size(); i++){
                Node node = linkedlist.get(i);
                if (node.key.equals(key)){
                    return i; 
                }
            }
            return -1; 
        }

        //rehashing is a method of increasing the size of the hashmap one it exceeds the certain threshold of load factor
        @SuppressWarnings ("unchecked")
        private void rehash(){
            LinkedList<Node>[] oldBuckets = buckets; 
            buckets = new LinkedList[N * 2]; //doubling the size of the array containing linkedlist
            N = 2 *N; //updating the value of N for new number of buckets 

            for (int i =0; i < buckets.length; i++){
                buckets[i] = new LinkedList<>(); //initializing new buckets that contain linkedlist
            }

            //resetting element count in the array
            n = 0; 

            //adding all the element form the old bucket to new bucket
            for (int i =0; i< oldBuckets.length; i++){
                LinkedList<Node> LL = oldBuckets[i];
                for (Node node : LL){
                    put(node.key, node.value);
                }
            }
        }

        //method to add or update values to the hashmap
        public void put(K key, V value){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex); //searching if the key already exists in the bucket

            //if the key is found, get node and update the value with the new given value else, create a new node in that index and increase the number of element 
            if (dataIndex != -1){
                Node currentNode = buckets[bucketIndex].get(dataIndex);
                currentNode.value = value;
            }else{
                buckets[bucketIndex].add(new Node(key, value));
                n++; 
            }
            //loadfactor tells how full is the hashmap, if the threshold of the loadFactor exceeds, rehashing is required
            //loadfactor is the ratio of number of elements to the number of buckets
            double loadFactor = (double) n / N;

            if (loadFactor > 1.5){
                rehash();
            }
        }

        //method to check if the the  key is in the hashmap or not
        public boolean containsKey(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);

            return dataIndex != -1; //if key matches with the key present returns true
        }

        //method to get the value of the given key
        public V get(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex); 

            if (dataIndex != -1){
                Node currNode = buckets[bucketIndex].get(dataIndex); 
                return currNode.value;
            }else{
                return null; 
            }
        }

        //method to remove the value of the given key
        public V remove(K key){
            int bucketIndex = hashFunction(key);
            int dataIndex = searchinLinkedList(key, bucketIndex);

            if (dataIndex != -1){
                Node currentNode = buckets[bucketIndex].remove(dataIndex);
                n--;
                return currentNode.value;
            }else{
                return null; 
            }
        }

        //method to retrive the keys present in the hashmap
        public ArrayList<K> keySet(){
            ArrayList<K> keys = new ArrayList<>();
            for (int i =0; i< buckets.length; i++){
                LinkedList<Node> LL = buckets[i];
                for (Node node : LL){
                    keys.add(node.key);
                }
            }
            return keys; 
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Bibhushit", 100);
        map.put("Shishir", 200);
        map.put("Raj", 300);
        map.put("Suman", 400);
        map.put("Pramod", 500);

        ArrayList<String> keys = new ArrayList<>(map.keySet());
        System.out.println(keys);
    }
}