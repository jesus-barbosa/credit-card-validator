import static org.junit.jupiter.api.Assertions.*;

class CreditCardValidatorTests {

    @org.junit.jupiter.api.Test
    void isAmericanExpressTest() {
        assertTrue(CreditCardValidator.isAmericanExpress(371449635398431L));   // american express
        assertTrue(CreditCardValidator.isAmericanExpress(378282246310005L));   // american express
        assertTrue(CreditCardValidator.isAmericanExpress(378734493671000L));   // american express
        assertFalse(CreditCardValidator.isAmericanExpress(-371449635398431L)); // negative number
        assertFalse(CreditCardValidator.isAmericanExpress(0));                 // zero
        assertFalse(CreditCardValidator.isAmericanExpress(5105105105105100L)); // mastercard
        assertFalse(CreditCardValidator.isAmericanExpress(4012888888881881L)); // visa
    }

    @org.junit.jupiter.api.Test
    void isMasterCardTest() {
        assertTrue(CreditCardValidator.isMasterCard(5555555555554444L));   // mastercard
        assertTrue(CreditCardValidator.isMasterCard(5105105105105100L));   // mastercard
        assertFalse(CreditCardValidator.isMasterCard(-5105105105105100L)); // negative number
        assertFalse(CreditCardValidator.isMasterCard(0));                  // zero
        assertFalse(CreditCardValidator.isMasterCard(371449635398431L));   // american express
        assertFalse(CreditCardValidator.isMasterCard(4012888888881881L));  // visa
    }

    @org.junit.jupiter.api.Test
    void isVisaTest() {
        assertTrue(CreditCardValidator.isVisa(4012888888881881L));   // visa
        assertTrue(CreditCardValidator.isVisa(4111111111111111L));   // visa
        assertTrue(CreditCardValidator.isVisa(4222222222222L));      // visa
        assertFalse(CreditCardValidator.isVisa(-4012888888881881L)); // negative number
        assertFalse(CreditCardValidator.isVisa(0));                  // zero
        assertFalse(CreditCardValidator.isVisa(371449635398431L));   // american express
        assertFalse(CreditCardValidator.isVisa(5105105105105100L));  // mastercard
    }

    @org.junit.jupiter.api.Test
    void isValidCardTest() {
        assertTrue(CreditCardValidator.isValidCard(4012888888881881L));   // visa
        assertFalse(CreditCardValidator.isValidCard(4012888888881882L));  // visa
        assertTrue(CreditCardValidator.isValidCard(4111111111111111L));   // visa
        assertTrue(CreditCardValidator.isValidCard(4222222222222L));      // visa
        assertTrue(CreditCardValidator.isValidCard(5555555555554444L));   // mastercard
        assertTrue(CreditCardValidator.isValidCard(5105105105105100L));   // mastercard
        assertFalse(CreditCardValidator.isValidCard(5105105105105101L));  // mastercard
        assertTrue(CreditCardValidator.isValidCard(371449635398431L));    // american express
        assertTrue(CreditCardValidator.isValidCard(378282246310005L));    // american express
        assertTrue(CreditCardValidator.isValidCard(378734493671000L));    // american express
        assertFalse(CreditCardValidator.isValidCard(378734493671001L));   // american express
        assertFalse(CreditCardValidator.isValidCard(-4012888888881881L)); // negative number
        assertFalse(CreditCardValidator.isValidCard(0));                  // zero
    }
}