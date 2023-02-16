package duke.commands;

import duke.DukeException;
import duke.Storage;
import duke.TaskList;

/**
 * A command type that the chatting bot can read.
 */
public class MarkCommand extends Command {

    private int markNumber;

    /**
     * The constructor of this class.
     *
     * @param markNumber
     */
    public MarkCommand(int markNumber) {
        this.markNumber = markNumber;
    }

    /**
     * The method that includes the execution of the command.
     *
     * @param list
     * @param store
     */
    @Override
    public String execute(TaskList list, Storage store) {
        if (markNumber < 1 || markNumber > list.size()) {
            return "This task number is invalid. Use 'list' to check how many tasks you have.";
        }
        list.stream().filter(x -> list.indexOf(x) == markNumber - 1).forEach(y -> y.setStatus(true));
        store.save(list);
        String response = "Okay, I've marked this task as done:\n";
        response += list.get(markNumber - 1).toString();
        return response;
    }

    /**
     * The method to see if the programme should exit.
     *
     * @return a boolean value stating the bot should not exit
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
