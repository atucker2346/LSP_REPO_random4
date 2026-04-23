package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 tests for {@link GradeCalculator}.
 */
public class GradeCalculatorTest {

    private GradeCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new GradeCalculator();
    }

    @Test
    void average_returnsMeanOfThreeValidScores() {
        assertEquals(85.0, calculator.average(80, 85, 90), 0.0001);
    }

    @Test
    void letterGrade_returnsB_forAverageInBRange() {
        assertEquals("B", calculator.letterGrade(85.0));
    }

    @Test
    void isPassing_returnsTrue_whenAverageAtLeast60() {
        assertTrue(calculator.isPassing(60.0));
    }

    @Test
    void boundary_letterGrade_returnsA_atExactly90() {
        assertEquals("A", calculator.letterGrade(90.0));
    }

    @Test
    void boundary_letterGrade_returnsB_justBelowA_at89Point99() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    void average_throwsIllegalArgument_whenScoreNegative() {
        assertThrows(IllegalArgumentException.class, () -> calculator.average(-1, 50, 50));
    }

    @Test
    void average_throwsIllegalArgument_whenScoreAbove100() {
        assertThrows(IllegalArgumentException.class, () -> calculator.average(50, 50, 101));
    }
}
