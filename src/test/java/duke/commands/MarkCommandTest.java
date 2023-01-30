package duke.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import duke.DukeException;
import duke.Parser;
import duke.Storage;
import duke.Task;
import duke.TaskList;
import duke.Ui;

/**
 * The class to test MarkCommand class.
 */
public class MarkCommandTest {

    /**
     * The test method to test the execute method.
     */
    @Test
    public void executeTest() {
        Ui ui = new Ui();
        Storage storage = new Storage();
        TaskList tasks = new TaskList();
        try {
            String fullCommand = "deadline return book /by 2023-01-25 18:59";
            Command c = Parser.parse(fullCommand);
            c.execute(tasks, storage, ui);
            String fullCommand2 = "mark 1";
            Command c2 = Parser.parse(fullCommand2);
            c2.execute(tasks, storage, ui);
        } catch (DukeException e) {
            ui.showMessage(e.getMessage());
        }
        System.out.println(tasks.size());
        Task test = tasks.get(0);
        assertEquals(test.toString(), "[D][X] return book (by: Jan 25 2023 18:59)");
    }
}
