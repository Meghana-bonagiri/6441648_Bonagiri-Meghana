public class Q8_OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        int result2 = (10 + 5) * 2;
        int result3 = 100 / 10 + 4 * 3;
        int result4 = 100 / (10 + 5) * 3;

        System.out.println("Result 1 (10 + 5 * 2): " + result1);  // 10 + (5 * 2) = 20
        System.out.println("Result 2 ((10 + 5) * 2): " + result2); // (10 + 5) * 2 = 30
        System.out.println("Result 3 (100 / 10 + 4 * 3): " + result3); // (100 / 10) + (4 * 3) = 10 + 12 = 22
        System.out.println("Result 4 (100 / (10 + 5) * 3): " + result4); // (100 / 15) * 3 = 6 * 3 = 18
    }
}
