import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.stage.Stage;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "    ____________________________________________________________\n" +
                "     Hello! I am Duke\n" +
                "     What can I do for you?\n" +
                "    ____________________________________________________________\n");
        String input = "";
        ArrayList<Task> tasks = new ArrayList<>();
        while (!input.equals("bye")) {
            input = sc.nextLine();
            String[] temp = input.split(" ");
            if (input.equals("list")) {
                int size = tasks.size();
                //may have to catch error if no items in list
                System.out.println("    ____________________________________________________________");
                for (int i = 0; i < size; i++) {
                    System.out.println("     "+(i+1)+". " +tasks.get(i));
                }
                System.out.println("    ____________________________________________________________\n");

            } else if(input.equals("bye")) {
                System.out.println(
                                "    ____________________________________________________________\n" +
                                "     Bye. Hope to see you again soon!\n" +
                                "    ____________________________________________________________\n");
            }else if (temp[0].equals("done")) {
                int num = Integer.parseInt(temp[1]) -1 ;
                tasks.get(num).markAsDone();

            }else {
                Task task = null;
                if(temp[0].equals("todo")){
                    task = new Todo(input.substring(5));

                } else if (temp[0].equals("deadline")) {
                    int num = input.indexOf("/by");
                    task = new Deadline(input.substring(9,num),input.substring(num+4));
                } else if (temp[0].equals("event")) {
                    int num = input.indexOf("/at");
                    task = new Event(input.substring(6, num), input.substring(num + 4));
                }
                tasks.add(task);
                System.out.println(
                                "    ____________________________________________________________\n" +
                                "     Got it. I've added this task: \n" +
                                "       " + task + "\n" +
                                "     Now you have " + tasks.size() + " tasks in the list.\n" +
                                "    ____________________________________________________________\n"
                );

            }
        }

    }
//    @Override
//    public void start(Stage stage) {
//        String logo = " ____        _        \n"
//                + "|  _ \\ _   _| | _____ \n"
//                + "| | | | | | | |/ / _ \\\n"
//                + "| |_| | |_| |   <  __/\n"
//                + "|____/ \\__,_|_|\\_\\___|\n";
//        Label label = new Label(logo); // Creating a new Label control
//        Scene scene = new Scene(label); // Setting the scene to be our Label
//
//        stage.setScene(scene); // Setting the stage to show our screen
//        stage.show(); // Render the stage.
//    }
}
