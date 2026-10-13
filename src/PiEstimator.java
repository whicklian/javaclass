public class PiEstimator {
    public static void main(String[] args) {
        int n = 20;
        double pi = 0.0;

        for (int i = 0; i < n; i++) {
            double denominator = 2 * i + 1;

            // Alternate signs: even indices add, odd indices subtract
            if (i % 2 == 0) {
                pi += 4.0 / denominator;
            } else {
                pi -= 4.0 / denominator;
            }
        }

        System.out.println("Estimated Pi (n = " + n + ") = " + pi);
    }
}
