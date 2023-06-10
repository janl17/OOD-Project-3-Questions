import org.junit.jupiter.api.Test;
import questions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static questions.Question.CORRECT;
import static questions.Question.INCORRECT;

public class QuestionTest {
    private Question likert;
    //don't like to share implementation details
    //code reuse
    private Question MC;
    private Question MS;
    private Question TF;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        likert = new Likert("Question 1");
        MC = new MultipleChoice("Question 1", "1", "2", "3", "4", "5");
        MS = new MultipleSelect("Question 1", "1", "2", "3", "4", "5");
        TF = new TrueFalse("Question 1", "True");

    }

    @Test
    public void LikertCompareToTest() {
        assertTrue(likert.compareTo(MC)>0);
         assertTrue(likert.compareTo(MS)>0);
        assertTrue(likert.compareTo(TF)>0);
    }

    @Test
    public void MCCompareToTest() {
        assertEquals(-1, MC.compareTo(likert));
        assertEquals(-1, MC.compareTo(MS));
        assertEquals(1, MC.compareTo(TF));
    }
    @Test
    public void MSCompareToTest() {
        assertEquals(-1, MS.compareTo(likert));
        assertEquals(1, MS.compareTo(MC));
        assertEquals(1, MS.compareTo(TF));
    }
    @Test
    public void TFCompareToTest() {
        assertEquals(-1, TF.compareTo(likert));
        assertEquals(-1, TF.compareTo(MC));
        assertEquals(-1, TF.compareTo(MS));
    }
}
