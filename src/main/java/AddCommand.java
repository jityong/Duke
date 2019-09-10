/**
 * Adds a Task to the TaskList.
 */
public class AddCommand extends Command {

    private Actions action;

    /**
     * Constructs a new AddCommand object.
     *
     * @param input  input from the user.
     * @param action action to be performed.
     */
    public AddCommand(String input, Actions action) {
        super(input);
        this.action = action;
    }

    /**
     * Executes the action to be performed.
     *
     * @param tasks   current list of tasks.
     * @param ui      Ui object.
     * @param storage Storage object to save and load files.
     */
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        int num;
        String desc;
        Task task = null;
        String[] inputArr = input.split(" ");
        switch (action) {
        case TODO:
            //trim so that cannot pass with just spaces
            desc =input.substring(4).trim();
            if (desc.equals("")) {
                Duke.print("☹ OOPS!!! The description of a todo cannot be empty.");
                return "☹ OOPS!!! The description of a todo cannot be empty.";
            } else {
                task = new Todo(desc);
            }
            break;
        case DEADLINE:
            num = input.indexOf("/by");
            //length == 1 means only has 'deadline', and temp[1] equal /by means no desc as well
            if (inputArr.length == 1 || inputArr[1].equals("/by")) {
                Duke.print("☹ OOPS!!! The description of a deadline cannot be empty.");
                return("☹ OOPS!!! The description of a deadline cannot be empty.");
            } else if (num == -1) { //-1 means /by is not found
                Duke.print("☹ OOPS!!! Please type /by before inputting the deadline.");
                return("☹ OOPS!!! Please type /by before inputting the deadline.");
            } else {
                desc = input.substring(9, num);
                //trim so that cannot pass with just spaces
                String by = input.substring(num + 3).trim();
                //no input time after /by
                if (by.equals("")) {
                    Duke.print("☹ OOPS!!! Please input a deadline after /by");
                    return("☹ OOPS!!! Please input a deadline after /by");
                } else {
                    task = new Deadline(desc, by);
                }
            }
            break;
        case EVENT:
            num = input.indexOf("/at");
            //length == 1 means only has 'event', and temp[1] equal /at means no desc as well
            if (inputArr.length == 1 || inputArr[1].equals("/at")) {
                Duke.print("☹ OOPS!!! The description of a event cannot be empty.");
                return("☹ OOPS!!! The description of a event cannot be empty.");
            } else if (num == -1) { //-1 means /at is not found
                return("☹ OOPS!!! Please type /at before inputting the time.");
            } else {
                desc = input.substring(6, num);
                //trim so that cannot pass with just spaces
                String at = input.substring(num + 3).trim();
                //no input time after /at
                if (at.equals("")) {
                    Duke.print("☹ OOPS!!! Please input a time after /at");
                    return("☹ OOPS!!! Please input a time after /at");
                } else {
                    task = new Event(desc, at);
                }
            }
            break;
        default:
            break;
        }
        // if task is still null do nothing
        if (task != null) {
            tasks.addTask(task);
            Duke.print("Got it. I've added this task:\n"
                    +
                    "       " + task + "\n"
                    +
                    "     Now you have " + tasks.getSize() + " tasks in the list.");
            return ("Got it. I've added this task:\n"
                    +
                    "       " + task + "\n"
                    +
                    "     Now you have " + tasks.getSize() + " tasks in the list.");
        } else {
            return null;
        }
    }


}
