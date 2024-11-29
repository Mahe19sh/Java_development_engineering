import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) {
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