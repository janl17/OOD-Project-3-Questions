import org.junit.jupiter.api.Test;
import questions.MultipleChoice;
import questions.MultipleSelect;
import questions.Question;

import static org.junit.jupiter.api.Assertions.*;
import static questions.Question.CORRECT;
import static questions.Question.INCORRECT;
class MultipleSelectTest {
    private Question answer1;
    private Question answer2;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.answer1 = new MultipleSelect("QuestionText", "1 2", "1", "2", "3", "4");
        this.answer2 = new MultipleSelect("QuestionText", "1 2 3", "1", "2", "3", "4");
    }
    @Test
    public void exception() {
        assertThrows(IllegalArgumentException.class, () -> new MultipleSelect("QuestionText", "1", "1", "2", "3", "4","5","6","7","8","9"));
    }
    @Test
    public void answerTest() {
        assertEquals(CORRECT,answer1.answer("2 1"));
        assertEquals(INCORRECT,answer2.answer("3 2 1 4"));
    }
    @Test
    public void getTextTest() {
        assertEquals("QuestionText",answer1.getText());
    }
    @Test
    public void CompareToTest() {
        MultipleSelect MS1 = new MultipleSelect("Question 1", "1 2", "2", "3", "4", "5");
        MultipleSelect MS2 = new MultipleSelect("Question 1", "1 2", "2", "3", "4", "5");

        // Test equal text
        assertEquals(0, MS1.compareTo(MS2));

        // Test different text
        MS2 = new MultipleSelect("PP", "1", "2", "3", "4", "5");
        assertEquals(1, MS1.compareTo(MS2));
    }
}