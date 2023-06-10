import org.junit.jupiter.api.Test;
import questions.MultipleSelect;
import questions.Question;
import questions.TrueFalse;

import static org.junit.jupiter.api.Assertions.*;
import static questions.Question.CORRECT;
import static questions.Question.INCORRECT;

class TrueFalseTest {

    private Question answer1;
    private Question answer2;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.answer1 = new TrueFalse("QuestionText","True");
        this.answer2 = new TrueFalse("QuestionText","False");

}
    @Test
    public void answerTest() {
        assertEquals(CORRECT,answer1.answer("True"));
        assertEquals(INCORRECT,answer2.answer("oi;sh"));
    }

    @Test
    public void getTextTest() {
        assertEquals("QuestionText",answer1.getText());
    }

    @Test
    public void CompareToTest() {
        TrueFalse TF1 = new TrueFalse("Question 1", "True");
        TrueFalse TF2 = new TrueFalse("Question 1", "True");

        // Test equal text
        assertEquals(0, TF1.compareTo(TF2));

        // Test different text
        TF2 = new TrueFalse("PP", "False");
        assertEquals(1, TF1.compareTo(TF2));
    }
}