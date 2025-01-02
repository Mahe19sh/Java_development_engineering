package The_Java_Language.Basics;

import java.lang.String;
import java.lang.StringBuilder;
import java.lang.StringBuffer;
import java.lang.StringTemplate;
import java.lang.StringIndexOutOfBoundsException;

class StringMastery{
    /*
     * Part of "Java.lang" package.
     * Immutable class -> any modification to an object in turn creates a new object.
     * String pool -> a special memory in heap region which stores string literals which allows java to optimize memory usage by reusing instances.
     * Implements -> String class implements Serializable, Comparable<String> , CharSequesnce interfaces.
     * 
     * --------------------Constructor ways to create instances------------------------
     * 1. From a literal -> String str = "Hello"
     * 2. From a character array -> char[] charArr = new char{'H','e','l','l','o'}; String str = new String(charArr);
     * 3. From a byte array -> byte[] byteArr = new byte{72,101,108,108,111} (ASCII values of H,e,l,l,o); String str = new String(byteArr);
     * 4. From another string -> String str = new String("Hello");
     * , etc. (In practical string class provides 10 different constructors which include above to create string instances for different scenarios).
     * --------------------------------------------------------------------------------
     * 
     */
    String str1 = "Hello";
    String str2 = "Hello";

    //------------------------------Key methods of string class grouped by functionality------------------------------------
    //Character retrieval
    public void charRetr(int index){
        char idx_val = str1.charAt(index);
        int unicode_val = str1.codePointAt(index);
    }

    //Length of given string
    public int Length(){
        return str1.length();
    }

    
}
