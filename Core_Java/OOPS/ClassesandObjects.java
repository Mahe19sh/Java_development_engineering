package Core_Java.OOPS;

public class ClassesandObjects {
    //A class is a blueprint or prototype from which objects are created. It defines the structure (fields/variables) and behavior (methods) that the objects of the class will have.

    String color; // fields of a class 
    int size; // class variables and also global variables.
    static int count = 0; // It's a static variable and belongs to class structure rather than to objects of this class type.

    // Constructor doesn't return anything so, the return type is always void. Mainly useful for initializing fields of the object instance.
    // default constructor. provided automatically if no constructor is defined.
    void ClassesandObjects(){
        color = "black";
        size = 2;
        System.out.println("Default Constructor & can print this message whenever object of this type is instantiated"); 
    }

    // This a parametrized constructor and only called when you pass the argument while instantiating object.
    void ClassesandObjects(int size){
        this.size = size; // The this keyword is used here to refer the current object instance.
    }

    //Copy Constructor : A user defined constructor creates a new object as a copy of an existing object.
    void ClassesandObjects(ClassesandObjects obj2){
        this.color = obj2.color;
        this.size = obj2.size;
    }

    // static method,  only static variables are accessible here.
    static void DisplayCount(){
        System.out.println("print count" + count);
    }

    // Method of a class
    public void DisplayDetails(){
        System.out.println("This is a method in OOPS terms it is a behavior of the object or state of object");
    }

    /* The 'this' keyword can be used in 5 main ways:
     * - Used to differentiate between instance variables and local variables when they have the same name.
           class Car {
                String model;
    
                Car(String model) {
                this.model = model;  // Refers to the instance variable
                }
            }
        - Used to call another method within the same class.
            class Car {
                void displayModel() {
                System.out.println("Car model displayed");
                }
    
                void start() {
                this.displayModel();  // Calls displayModel() method
                }
            }
        - 
     */

}

