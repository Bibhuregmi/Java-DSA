package String;

public class string {

    public static void main(String[] args) {

        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            series += ch;
            // System.out.println(ch);
        }
        System.out.println(series);

    }

    /*
     * Here while printing the series a new object is created in each iteration of
     * the loop. Eg. first series = "" and "a" is added to it and the "b" added to
     * "a" to get "ab" then "c" is added to it. Here in each iteration of the for
     * loop new
     * objects are been created beacuse Strings are immutable. Here reference var.
     * string will be pointing to new object which will create a new space in the
     * memory and in each iteration these objects will have no reference var.
     * pointing towards them Eg. ["a", "ab", "abc", "abcd",
     * "abcde"......"abcdefghij.......y"] here all these objects are causing a loss
     * of memory and extra space.
     * Each iteration is on O(N^2)
     * Once a object is created in String we cannot modify that object.
     */

    /*
     * Now comes the concept of the StringBuilder, it is a separate class in Java
     * that is similar to String but it is mutable. It has many methods associated
     * with it which help to mutate the object.
     */

    public static void Sb() {
        StringBuilder series = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            series.append(ch);
        }
    }
}

/*
 * Here StringBuilder is mutable meaning it can be manipulated without creating
 * new object as in of Array. Since, no new objects are been created this
 * apporach is more suitable when especially when concatenating many strings or
 * characters, because it avoids the overhead of creating multiple intermediate
 * string objects.
 */