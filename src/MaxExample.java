public class MaxExample {
    // Defining the method
    public static int max(int num1, int num2) {
        int result;
        if (num1 > num2)
            result = num1;
        else
            result = num2;

        return result;
    }

    public static void main(String[] args) {
        int x = 15;
        int y = 22;

        // Invoking the method with actual parameters (arguments)
        int z = max(x, y);

        System.out.println("The maximum of " + x + " and " + y + " is " + z);
    }
}
