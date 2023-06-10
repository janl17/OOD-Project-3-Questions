package questions;

import java.util.Arrays;

/**
 * Jiachen Liang
 * This class represents a Multiple Select question on a computer-based test.
 */
public class MultipleSelect implements Question{
    private String options[];
    private String text;
    private String answer;
    public MultipleSelect(String text,String answer,String... options) throws IllegalArgumentException{
        if ((options.length < 3) || (options.length > 8)) {
            throw new IllegalArgumentException("Number of options must be between 3 and 8.");
        }
        this.options= options;
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
        String[] splitUserInput = answer.split(" ");
        Arrays.sort(splitUserInput);
        String[] splitAnswer = this.answer.split(" ");
        Arrays.sort(splitAnswer);
        if (Arrays.equals((splitUserInput), splitAnswer)) { //change to answer=string[] by split to Arrays.sort(answer)
            return CORRECT;
        }
        else {
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
     * compare question text to a Likert or MultipleSelect question
     *
     * @param o the question to compare with
     * @return a negative number, 0 or a positive number when comparing two MultipleSelect questions
     * and return -1 when comparing to Likert questions
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof Likert) {
            return -1;
        }
        if (o instanceof MultipleSelect) {
            return this.getText().compareTo(o.getText());
        }
        return 1;
    }

}