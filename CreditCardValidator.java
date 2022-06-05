import java.util.Scanner;

public class CreditCardValidator {
    private static final long BASE_16_DIGIT = 1000000000000000L;
    private static final long BASE_15_DIGIT = 100000000000000L;
    private static final long BASE_14_DIGIT = 10000000000000L;
    private static final long BASE_13_DIGIT = 1000000000000L;
    private static final int FIRST_DIGIT_AMERICAN = 3;
    private static final int FIRST_DIGIT_MASTER = 5;
    private static final int FIRST_DIGIT_VISA = 4;
    private static final int MAX_CARD_DIGITS = 16;
    private static final int BASE_10 = 10;
    private static final int BASE_2 = 2;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Credit card: ");
        long card = input.nextLong();
        if (isAmericanExpress(card)) {
            System.out.println("American Express");
            System.out.println("Valid card: " + isValidCard(card));
        } else if (isMasterCard(card)) {
            System.out.println("Master Card");
            System.out.println("Valid card: " + isValidCard(card));
        } else if (isVisa(card)) {
            System.out.println("Visa");
            System.out.println("Valid card: " + isValidCard(card));
        } else
            System.out.println("Unknown card");
        input.close();
    }

    public static boolean isAmericanExpress(long card) {
        int firstDigit = (int)(card / BASE_15_DIGIT);
        card %= BASE_15_DIGIT;
        int secondDigit = (int)(card / BASE_14_DIGIT);
        return firstDigit == FIRST_DIGIT_AMERICAN && (secondDigit == 4 || secondDigit == 7);
    }

    public static boolean isMasterCard(long card) {
        int firstDigit = (int)(card / BASE_16_DIGIT);
        card %= BASE_16_DIGIT;
        int secondDigit = (int)(card / BASE_15_DIGIT);
        return firstDigit == FIRST_DIGIT_MASTER &&
                (secondDigit == 1 || secondDigit == 2 || secondDigit == 3 || secondDigit == 4 || secondDigit == 5);
    }

    public static boolean isVisa(long card) {
        return card / BASE_13_DIGIT == FIRST_DIGIT_VISA || card / BASE_16_DIGIT == FIRST_DIGIT_VISA;
    }

    /*
     * Luhn's Algorithm
     */
    public static boolean isValidCard(long card) {
        int digit;
        int sumEven = 0;
        int sumOdd = 0;
        for (long i = 1; i <= MAX_CARD_DIGITS; i++) {
            digit = (int) (card % BASE_10);
            card /= BASE_10;
            if (i % BASE_2 == 0) {  // Even
                digit *= BASE_2;
                if (digit >= BASE_10) {
                    sumEven += digit / BASE_10;
                    sumEven += digit % BASE_10;
                } else {
                    sumEven += digit;
                }
            } else {  // Odd
                sumOdd += digit;
            }
        }
        return (sumEven + sumOdd) > 0 && (sumEven + sumOdd) % BASE_10 == 0;
    }
}
