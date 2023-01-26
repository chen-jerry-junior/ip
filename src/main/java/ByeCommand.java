public class ByeCommand extends Command {

    @Override
    public void execute(TaskList list, Storage store, Ui ui) throws DukeException {
        ui.showMessage("Bye. Hope to see you again soon!");
        return;
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
