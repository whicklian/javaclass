import java.security.SecureRandom;

public class OTPGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();

        // Generates a random 6-digit number between 100000 and 999999
        int otp = 100000 + random.nextInt(900000);

        System.out.println("Your One-Time Password (OTP) is: " + otp);
    }
}