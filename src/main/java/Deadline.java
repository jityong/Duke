/**
 * Deadline task that inherits from Task.
 */
public class Deadline extends Task {

    public String dateTime;

    /**
     * Constructs a new Deadline object.
     *
     * @param task     description of task.
     * @param dateTime date and time of task.
     */
    public Deadline(String task, String dateTime) {
        super(task);
        this.dateTime = Duke.toDateString(dateTime);
    }

    /**
     * Returns a string representation of a Deadline object in the in the format of [D][✗] task (by: dateTime).
     *
     * @return a string representation of a Deadline object.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + this.dateTime + ")";
    }
}
