package questions;

/**
 * Jiachen Liang
 * This class represents a True/False question on a computer-based test.
 */
public class TrueFalse implements Question{
    private String text;
    private String answer;
    public TrueFalse (String text, String answer) {
        this.text = text;
        this.answer = answer;
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
       if (answer.equals(this.answer)) {
           return CORRECT;
        } else {
            return INCORRECT;
        }
    }

    /**
     * Returns the text of the question.
     *
     * @return the text
     */
    @Override
    public String getText() {
        return text;
    }

    /**
     * compare question text to a Likert, MultipleChoice, MultipleSelect or TrueFalse question
     *
     * @param o the question to compare with
     * @return a negative number, 0 or a positive number when comparing two TrueFalse questions
     * and return -1 when comparing to Likert, MultipleChoice, or MultipleSelect
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof Likert || o instanceof MultipleChoice || o instanceof MultipleSelect) {
            return -1;
        }
        if (o instanceof TrueFalse) {
            return this.getText().compareTo(o.getText());
        }
        return 1;
    }
}
