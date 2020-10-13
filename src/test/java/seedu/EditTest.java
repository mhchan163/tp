package seedu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.commands.Command;
import seedu.data.TaskList;
import seedu.exceptions.InvalidCommandException;
import seedu.exceptions.InvalidPriorityException;
import seedu.exceptions.InvalidTaskNumberException;
import seedu.exceptions.UnknowCommandException;
import seedu.task.Task;
import seedu.parser.Parser;
import seedu.commands.CommandResult;

import static org.junit.jupiter.api.Assertions.*;

class EditTest {
    private TaskList tasks;

    private Task meeting;
    private Task reading;
    private Task lecture;
    private Task tutorial;
    private Parser parser;
    private final String EDIT_STRING = "Tutorial 22-10-2020 1900 2000";
    private final String EDIT_STRING_INPUT =  "edit 2 des/Tutorial d/22-10-2020 st/1900 et/2000";
    private Command command;
    private CommandResult result;

    @BeforeEach
    public void setup() throws InvalidPriorityException {
        parser = new Parser();
        tasks = new TaskList();
        meeting = new Task("meeting", "13-10-2020", "2000", "2200", "2");
        reading = new Task("reading", "21-10-2020", null, null, null);
        lecture = new Task("lecture", "20-10-2020", "1800", null, null);
        tutorial = new Task("tutorial", "19-10-2020", "1500", null, "1");
    }

    @Test
    void editTask() throws
            UnknowCommandException, InvalidCommandException,
            InvalidPriorityException, InvalidTaskNumberException {
        tasks.addTask(meeting);
        tasks.addTask(lecture);
        command = parser.processRaw(EDIT_STRING_INPUT);
        result = command.execute(tasks);
        //assertFalse(tasks.get(1).toString().equals(EDIT_STRING));
        //assertEquals(lecture.getDescription(),beforeEdit.getDescription());
        //assertEquals(lecture.getDate(),tasks.get
        //assertFalse(tasks.get(1).getDate().equals("20-10-2020"));
        //assertFalse(tasks.get(1).getEndTime().equals("1900"));
        assertTrue(tasks.contains(meeting));

    }

}