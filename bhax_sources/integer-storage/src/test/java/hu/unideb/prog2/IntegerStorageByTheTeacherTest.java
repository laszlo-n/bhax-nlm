package hu.unideb.prog2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerStorageByTheTeacherTest {
    private IntegerStorageByTheTeacher underTest = new IntegerStorageByTheTeacher(1);

    @Test
    public void testAddShouldAddTheGivenInputWhenTheInputIsValid() {
        // Given
        IntegerStorageByTheTeacher expected = new IntegerStorageByTheTeacher(new int[]{3});
        Integer input = 3;

        // When
        underTest.add(input);

        // Then
        assertEquals(expected, underTest);
    }
}
