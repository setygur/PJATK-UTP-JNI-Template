package test;

import main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    @Test
    public void arbitraryPalindromesAreReportedAsSuch() {
        assertTrue(Main.isPalindrome("racecar"));
        assertTrue(Main.isPalindrome("madam"));
    }

    @Test
    public void emptyStringIsAPalindrome() {
        assertTrue(Main.isPalindrome(""));
    }

    @Test
    public void nullIsNotAPalindrome() {
        assertFalse(Main.isPalindrome(null));
    }
}
