public class Event extends Task {
    public String time;
    public Event(String task, String time){
        super(task);
        this.time = Duke.toDateString(time);
//        this.time = time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + this.time + ")";
    }
}
