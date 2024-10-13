package test;

import main.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WithoutDuplicatesTest {
    @Test
    public void ascendingArrayWithNoDuplicatesStaysTheSame() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {1, 2, 3};

        assertArrayEquals(array1, Main.withoutDuplicates(array1));
        assertArrayEquals(array2, Main.withoutDuplicates(array2));
    }

    @Test
    public void descendingArrayWithNoDuplicatesStaysTheSame() {
        int[] array1 = {5, 4, 3, 2, 1};
        int[] array2 = {3, 2, 1};

        assertArrayEquals(array1, Main.withoutDuplicates(array1));
        assertArrayEquals(array2, Main.withoutDuplicates(array2));
    }

    @Test
    public void emptyArrayStaysTheSame() {
        int[] array = { };

        assertArrayEquals(array, Main.withoutDuplicates(array));
    }

    @Test
    public void randomArrayWithoutDuplicatesStaysTheSame() {
        int[] randomValues = {27, 94, 12, 57, 86, 34, 65, 4, 73, 19};

        assertArrayEquals(
                randomValues, Main.withoutDuplicates(randomValues),
                "Removing duplicates should be a stable operation"
        );
    }

    @Test
    public void arraysWithJustOneRepeatingElementAreReducedToSingleElement() {
        int[] array1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] array2 = {2, 2, 2, 2};

        assertArrayEquals(new int[]{1}, Main.withoutDuplicates(array1));
        assertArrayEquals(new int[]{2}, Main.withoutDuplicates(array2));
    }
}
