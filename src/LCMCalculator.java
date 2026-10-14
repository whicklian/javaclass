public class LCMCalculator {

    public static int lcm(int n1, int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }

        // Find GCD to use in the formula: LCM = |n1 * n2| / GCD
        int gcd = GCDExample.gcd(n1, n2);

        return Math.abs(n1 * n2) / gcd;
    }

    public static void main(String[] args) {
        int num1 = 24;
        int num2 = 36;

        System.out.println("The LCM of " + num1 + " and " + num2 + " is " + lcm(num1, num2));
    }
}
