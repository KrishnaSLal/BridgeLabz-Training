import java.util.Scanner;

public class NumberChecker{

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        int digitCount = countDigits(number);
        int[] digits = storeDigits(number, digitCount);

        System.out.println("Count of digits = " + digitCount);

        System.out.print("Digits array: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.println("Is Duck Number = " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number = " + isArmstrong(number, digits));

        int[] largest = findLargestAndSecondLargest(digits);
        System.out.println("Largest = " + largest[0]);
        System.out.println("Second Largest = " + largest[1]);

        int[] smallest = findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest = " + smallest[0]);
        System.out.println("Second Smallest = " + smallest[1]);

        input.close();
    }

    // Method to find count of digits
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // Method to store digits in array
    public static int[] storeDigits(int number, int count) {
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // Method to check duck number using digits array
    public static boolean isDuckNumber(int[] digits) {
        for (int d : digits) {
            if (d != 0) {
                return true;
            }
        }
        return false;
    }

    // Method to check Armstrong number using digits array
    public static boolean isArmstrong(int number, int[] digits) {
        int sum = 0;
        int power = digits.length;

        for (int d : digits) {
            sum += Math.pow(d, power);
        }
        return sum == number;
    }

    // Method to find largest and second largest
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int d : digits) {
            if (d > largest) {
                secondLargest = largest;
                largest = d;
            } else if (d > secondLargest && d != largest) {
                secondLargest = d;
            }
        }
        return new int[] { largest, secondLargest };
    }

    // Method to find smallest and second smallest
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int d : digits) {
            if (d < smallest) {
                secondSmallest = smallest;
                smallest = d;
            } else if (d < secondSmallest && d != smallest) {
                secondSmallest = d;
            }
        }
        return new int[] { smallest, secondSmallest };
    }
}