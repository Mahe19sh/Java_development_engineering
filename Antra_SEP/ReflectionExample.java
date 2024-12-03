import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
        //Reflection in Java is a powerful feature that allows a program to inspect and manipulate the internal properties of classes, methods, fields, and constructors at runtime. It’s part of the java.lang.reflect package.
        try {
            // Obtain Class object for String class
            Class<?> clazz = Class.forName("java.lang.String");
            
            // Get all methods of the class
            Method[] methods = clazz.getDeclaredMethods();
            
            // Print method names
            for (Method method : methods) {
                System.out.println(method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}