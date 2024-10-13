package test;

import main.Main;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


public class ChunkTest {
    @Test
    public void stringsThatCanBeSplitPerfectlyAreCorrectlySplit() {
        assertArrayEquals(new String[]{"Easi", "ly s", "plit"}, Main.chunk("Easily split", 3));
        assertArrayEquals(new String[]{"Hello", "There"}, Main.chunk("HelloThere", 2));
    }

    @Test
    public void splittingIntoOneStringReturnsTheOriginalString() {
        assertArrayEquals(new String[]{"Whole text"}, Main.chunk("Whole text", 1));
        assertArrayEquals(new String[]{""}, Main.chunk("", 1));
    }

    @Test
    public void splittingEmptyStringIntoFewChunksShouldReturnThatManyEmptyStrings() {
        assertArrayEquals(new String[]{""}, Main.chunk("", 1));

        assertArrayEquals(new String[]{"", "", ""}, Main.chunk("", 3));

        assertArrayEquals(IntStream.rangeClosed(0, 99).mapToObj(_ -> "").toArray(), Main.chunk("", 100));
    }

    @Test
    public void splittingStringIntoZeroElementsShouldReturnZeroLengthArray() {
        assertEquals(0, Main.chunk("some random text", 0).length);

        assertEquals(0, Main.chunk("", 0).length);
    }

    @Test
    public void splittingStringIntoNegativeNumberOfChunksThrowsIllegalArgumentException() {
        Exception exception;

        exception = assertThrows(IllegalArgumentException.class, () -> Main.chunk("", -1));
        assertTrue(exception.getMessage().contains("-1"));

        exception = assertThrows(IllegalArgumentException.class, () -> Main.chunk("random text", -1));
        assertTrue(exception.getMessage().contains("-1"));

        exception = assertThrows(IllegalArgumentException.class, () -> Main.chunk("", -2137));
        assertTrue(exception.getMessage().contains("-2137"));

        exception = assertThrows(IllegalArgumentException.class, () -> Main.chunk("random text", -2137));
        assertTrue(exception.getMessage().contains("-2137"));
    }

    @Test
    public void stringsSplitUnevenlyHaveLastElementPaddedWithSpaces() {
        assertArrayEquals(new String[]{"Hel", ("lo" + " ")}, Main.chunk("Hello", 2));

        assertArrayEquals(new String[]{"He", "ll", ("o" + " ")}, Main.chunk("Hello", 3));
    }

    @Test
    public void splittingStringIntoMoreChunksThanItHasLettersProducesEmptyStringsAtTheEndOfTheArray() {
        assertArrayEquals(new String[]{"h", "e", "l", "l", "o", "", ""}, Main.chunk("hello", 7));

        assertArrayEquals(new String[]{"", "", "", "", "", "", ""}, Main.chunk("", 7));
    }
}
