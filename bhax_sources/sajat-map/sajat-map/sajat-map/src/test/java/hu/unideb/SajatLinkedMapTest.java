package hu.unideb;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SajatLinkedMapTest {
    private SajatLinkedMap<String, Integer> underTest;
    private static final String SAMPLE_KEY = "sample key";
    private static final Integer SAMPLE_VAL = 1;

    @Before
    public void init() {
        underTest = new SajatLinkedMap<>();
    }

    @Test
    public void sizeShouldBeZeroWhenNoEntriesWereAdded() {
        // Given, When & Then:
        assertEquals(0, underTest.size());
    }

    @Test
    public void sizeShouldReturnCorrectSizeWhenEntryWasAdded() {
        // Given & When
        underTest.put(SAMPLE_KEY, SAMPLE_VAL);

        // Then
        assertEquals(1, underTest.size());
    }

    @Test
    public void sizeShouldReturnCorrectSizeWhenEntryWasRemoved() {
        // Given
        underTest.put(SAMPLE_KEY, SAMPLE_VAL);

        // When
        underTest.remove(SAMPLE_KEY);

        // Then
        assertEquals(0, underTest.size());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenNoEntriesWereAdded() {
        // Given, When & Then:
        assertTrue(underTest.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnFalseWhenEntriesWereAdded() {
        // Given & When
        underTest.put(SAMPLE_KEY, SAMPLE_VAL);

        // Then
        assertFalse(underTest.isEmpty());
    }

    @Test
    public void isEmptyShouldReturnTrueWhenEntriesWereRemoved() {
        // Given
        underTest.put(SAMPLE_KEY, SAMPLE_VAL);

        // When
        underTest.remove(SAMPLE_KEY);

        // Then
        assertTrue(underTest.isEmpty());
    }

    @Test
    public void putShouldPlaceEntryIntoTheMap() {
        // Given & When
        underTest.put(SAMPLE_KEY, SAMPLE_VAL);

        // Then
        assertEquals(SAMPLE_VAL, underTest.get(SAMPLE_KEY));
    }

    @Test
    public void getShouldRetrieveTheValueInsertedIntoTheMap() {
        // Given & When
        underTest.put(SAMPLE_KEY, SAMPLE_VAL);

        // Then
        assertEquals(SAMPLE_VAL, underTest.get(SAMPLE_KEY));
    }
}
