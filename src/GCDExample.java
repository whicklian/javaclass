public class GCDExample {

    public static int gcd(int n1, int n2) {
        int gcd = 1; // Initial gcd is 1[cite: 4]
        int k = 2;   // Possible gcd[cite: 4]

        while (k <= n1 && k <= n2) {
            if (n1 % k == 0 && n2 % k == 0)
                gcd = k; // Update gcd[cite: 4]
            k++;
        }
        return gcd; // Return gcd[cite: 4]
    }

    public static void main(String[] args) {
        System.out.println("The GCD of 24 and 36 is " + gcd(24, 36));
        System.out.println("The GCD of 125 and 252 is " + gcd(125, 252));
    }
}
