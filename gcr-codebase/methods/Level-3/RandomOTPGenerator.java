public class RandomOTPGenerator {

    public static void main(String[] args) {

        int[] otpArray = new int[10];

        // Generate OTPs 10 times
        for (int i = 0; i < otpArray.length; i++) {
            otpArray[i] = generateOTP();
        }

        // Display generated OTPs
        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.print(otp + " ");
        }
        System.out.println();

        // Check uniqueness
        boolean isUnique = areOTPsUnique(otpArray);
        System.out.println("Are all OTPs unique? " + isUnique);
    }

    // Method to generate a 6-digit OTP using Math.random()
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

    // Method to check if all OTPs are unique
    public static boolean areOTPsUnique(int[] otpArray) {
        for (int i = 0; i < otpArray.length; i++) {
            for (int j = i + 1; j < otpArray.length; j++) {
                if (otpArray[i] == otpArray[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}