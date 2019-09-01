/**
 * Event task that inherits from Task.
 */
public class Event extends Task {

    public String dateTime;

    /**
     * Constructs a new Event object.
     *
     * @param task     description of task.
     * @param dateTime date and time of task.
     */
    public Event(String task, String dateTime) {
        super(task);
        this.dateTime = Duke.toDateString(dateTime);
    }

    /**
     * Returns a string representation of an Event object.
     *
     * @return a string representation of an Event object.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + this.dateTime + ")";
    }
}
