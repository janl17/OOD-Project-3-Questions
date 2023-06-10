package questions;

/**
 * Jiachen Liang
 * This class represents a Multiple Choice question on a computer-based test.
 */
public class MultipleChoice implements Question {
    private String[] options;
    private String text;
    private String answer;
    public MultipleChoice(String text, String answer, String... options) throws IllegalArgumentException{
        //text,options(hashset),answer
        if ((options.length < 3) || (options.length > 8)) { //refer to parameter
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
        if (answer.equals(this.answer)) {
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
     * compare question text to a Likert, MultipleChoice or MultipleSelect question
     *
     * @param o the question to compare with
     * @return a negative number, 0 or a positive number when comparing two MultipleChoice questions
     * and return -1 when comparing to Likert or MultipleSelect questions
     */
    @Override
    public int compareTo(Question o) {
        if (o instanceof Likert || o instanceof MultipleSelect) {
            return -1;
        }
        if (o instanceof MultipleChoice) {
            return this.getText().compareTo(o.getText());
        }
        return 1;
    }



}