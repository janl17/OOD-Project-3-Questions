package questions;
import java.util.Arrays;
/**
 * Jiachen Liang
 * This class represents a Likert question on a computer-based test.
 */

public class Likert implements Question {

    private final String text;
    private final String[] options;

    public Likert(String text) {
        this.text = text;
        this.options = new String[]{"1", "2", "3", "4", "5"};
    }

    /**
     * Determines if the answer is correct for a given question. If the answer is
     * correct, this method returns "Correct"; and "Incorrect" otherwise.
     *
     * @param answer the answer given
     * @return "Correct" or "Incorrect"
     */
    @Override
    public String answer(String answer) {
        for (String option : this.options) {
            if (option.equals(answer)) {//==: check exact ones(objects) stored in memories instead of values
                return CORRECT;
            }
        }
        return INCORRECT;
    }

    /**
     * Returns the text of the question.
     *
     * @return the text
     */
    public String getText() {
        return this.text;
    }

    /**
     * compare question text to a Likert question
     *
     * @param o the question to compare with
     * @return a negative number, 0 or a positive number
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof Likert) {
            return this.getText().compareTo(o.getText());
        }
        return 1;
    }
}
