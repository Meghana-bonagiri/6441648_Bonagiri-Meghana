public class Q7_TypeCastingExample {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int castedInt = (int) myDouble;
        System.out.println("Original double value: " + myDouble);
        System.out.println("Double casted to int: " + castedInt);

        int myInt = 25;
        double castedDouble = (double) myInt;
        System.out.println("Original int value: " + myInt);
        System.out.println("Int casted to double: " + castedDouble);
    }
}
