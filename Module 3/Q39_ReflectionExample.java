import java.lang.reflect.*;

class Person {
    private String name;

    public Person() {
        this.name = "Default Name";
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Q39_ReflectionExample {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("Person");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method: " + method.getName());
            for (Class<?> paramType : method.getParameterTypes()) {
                System.out.println("  Param: " + paramType.getName());
            }
        }

        for (Method method : methods) {
            if (method.getName().equals("setName")) {
                method.invoke(obj, "Alice");
            } else if (method.getName().equals("sayHello")) {
                method.invoke(obj);
            }
        }
    }
}
