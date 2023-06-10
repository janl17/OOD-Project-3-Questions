import org.junit.jupiter.api.Test;
import questions.Likert;
import questions.Question;

import static org.junit.jupiter.api.Assertions.*;
import static questions.Question.CORRECT;
import static questions.Question.INCORRECT;

class LikertTest {
    private Question answer1;
    private Question answer2;
    private Question text;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.answer1 = new Likert("questiontext");
        this.answer2 = new Likert("questiontext");
    }

    @Test
    public void answerTest() {
        assertEquals(CORRECT, answer1.answer("1"));
        assertEquals(INCORRECT, answer2.answer("9"));
    }

    @Test
    public void getTextTest() {
        assertEquals("questiontext",answer1.getText());
    }

        @Test
        public void CompareToTest() {
            Likert likert1 = new Likert("Question 1");
            Likert likert2 = new Likert("Question 1");

            // Test equal text
            assertEquals(0, likert1.compareTo(likert2));

            // Test different text
            likert2 = new Likert("Question 3");
            assertTrue(likert1.compareTo(likert2) < 0);
        }

    }
