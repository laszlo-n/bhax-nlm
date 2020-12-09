package hu.unideb.prog2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerStorageTest {
    private IntegerStorage underTest;

    //region add() tests
    @Test
    public void testAddShouldWorkOnceNormally() {
        // Given
        underTest = new IntegerStorage(1);

        // When
        underTest.add(1);

        // Then
        assertArrayEquals(underTest.getIntStore(), new int[]{1});
    }

    @Test
    public void testAddShouldWorkMultipleTimesNormally() {
        // Given
        underTest = new IntegerStorage(2);

        // When
        underTest.add(1);
        underTest.add(2);

        // Then
        assertArrayEquals(underTest.getIntStore(), new int[]{1, 2});
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddShouldntAddToFullStorage() {
        // Given
        underTest = new IntegerStorage(new int[1]);

        // When
        underTest.add(1);

        // Then
        // ...throws
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddShouldntAddToFullStorage2() {
        // Given
        underTest = new IntegerStorage(1);

        // When
        underTest.add(1);
        underTest.add(2);

        // Then
        // ...throws
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddShouldntAddToZeroSizedStorage() {
        // Given
        underTest = new IntegerStorage(new int[0]);

        // When
        underTest.add(1);

        // Then
        // ...throws
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testAddShouldntAddToZeroSizedStorage2() {
        // Given
        underTest = new IntegerStorage(0);

        // When
        underTest.add(1);

        // Then
        // ...throws
    }
    //endregion

    //region contains() tests
    @Test
    public void testContainsShouldReturnFalseOnEmpty() {
        // Given
        underTest = new IntegerStorage(0);

        // When
        boolean result = underTest.contains(3);

        // Then
        assertFalse(result);
    }

    @Test
    public void testContainsShouldReturnFalseOnEmpty2() {
        // Given
        underTest = new IntegerStorage(new int[0]);

        // When
        boolean result = underTest.contains(3);

        // Then
        assertFalse(result);
    }

    @Test
    public void testContainsShouldWorkNaively() {
        // Given
        underTest = new IntegerStorage(new int[]{1, 2, 3});

        // When
        boolean result = underTest.contains(2);

        // Then
        assertTrue(result);
    }
    //endregion

    @Test
    public void testSortShouldReturnCorrectOrderWhenOddNumberOfValuesPassed() {
        underTest = new IntegerStorage(new int[]{2, 3, 1, 4});

        underTest.sort();

        assertArrayEquals(underTest.getIntStore(), new int[]{1, 2, 3, 4});
    }
}
