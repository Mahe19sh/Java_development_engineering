package The_Java_Language.Basics;

public class primitiveTypes {
    /*
     *  Java defines eight primitive types of data:	byte,	short,	int,	long,	char,	float,  double,	and	boolean.
     * 	And the data_types further classified into sub-categories ,
            Integers : byte, short, int, long. All are signed, positive and negative values. Java does not support unsigned positive integers only. 
                       The width and ranges of integer types vary widely. long(64 bits),int(32), short(16), byte(8). Variables of type 'int' are commonly employed to control loops and to 
                       index arrays. Well byte and short are also would be a choice , but when the expression is evaluated it promoted to type 'int' which is called type promotion.
            Floating_numbers : float(32), double(64) for real numbers and precision values.
            boolean : true(0), false(Non_zero integer)
            character storage : java uses unicode to represent characters in system & 'char' type can be used to declare a character variable. The widht is 16-bit type , which is suitable for Unicode.
                                The first 0 to 127 values of unicode chracter set are occupied by ASCII , so whenever you assign a integer value within this range or unicode range the java itself treats 
                                the value to be character which is associated with that value in ASCII or unicode.
                                Example : 
                                            char ch1 = 88 // ASCII code for X
                                            char ch2 = 'Y'

                                            print(ch1 + " " + ch2) - > prints 'X Y'.
                                Although 'char' is defined to hold unicode characters , it also can be used as integer type in which we can perform arthimetic operations like adding two characters 
                                together or incrementing a character value.
                                Example :
                                            char ch1;

                                            ch1 = 'X'

                                            print(ch1) - > prints X

                                            ch1++;

                                            print(ch1) - > prints Y
    
     *          
     */
    public static void main(String[] args){
        byte a = 123;

        int b = a; // Implicit type casting , the smaller data type can be automatically converted to larger one.

        System.out.println("Implicit type casting example , value of a is directly converted to int, which equals " + b);

        int c = 124;

        byte x = (byte) c; // Explicit type casting, the bigger type converted to smaller one manually.

        System.out.println("Explicit type casting example, value of c explicitly converted to byte type, which equals " + x);
 
    }
}
