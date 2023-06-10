import org.junit.jupiter.api.Test;
import questions.Likert;
import questions.MultipleChoice;
import questions.Question;

import static org.junit.jupiter.api.Assertions.*;
import static questions.Question.CORRECT;
import static questions.Question.INCORRECT;

class MultipleChoiceTest{

    private Question answer1;
    private Question answer2;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.answer1 = new MultipleChoice("QuestionText", "1", "1", "2", "3", "4");
        this.answer2 = new MultipleChoice("QuestionText", "2", "1", "2", "3", "4");
    }

    @Test
    public void exception() {
        assertThrows(IllegalArgumentException.class, () -> new MultipleChoice("QuestionText", "1", "1", "2"));
    }

    @Test
    public void answerTest() {
        assertEquals(CORRECT, answer1.answer("1"));
        assertEquals(INCORRECT, answer2.answer("3"));
    }

    @Test
    public void getTextTest() {
        assertEquals("QuestionText",answer1.getText());
    }
    @Test
    public void CompareToTest() {
        MultipleChoice MC1 = new MultipleChoice("Question 1", "1", "2", "3", "4", "5");
        MultipleChoice MC2 = new MultipleChoice("Question 1", "1", "2", "3", "4", "5");

        // Test equal text
        assertEquals(0, MC1.compareTo(MC2));

        // Test different text
        MC2 = new MultipleChoice("PP", "1", "2", "3", "4", "5");
        assertEquals(1, MC1.compareTo(MC2));
    }

}