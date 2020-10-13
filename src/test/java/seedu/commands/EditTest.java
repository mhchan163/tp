package seedu.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.data.TaskList;
import seedu.exceptions.InvalidCommandException;
import seedu.exceptions.InvalidDatetimeException;
import seedu.exceptions.InvalidPriorityException;
import seedu.exceptions.UnknowCommandException;
import seedu.exceptions.InvalidTaskNumberException;
import seedu.task.Task;
import seedu.parser.Parser;

import java.time.LocalDate;
import java.time.LocalTime;
import seedu.task.Priority;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EditTest {
    private TaskList tasks;
    private LocalTime endTime;
    private LocalTime startTime;
    private LocalDate date;
    private Priority priority;
    private Task meeting;
    private Task lecture;
    private Parser parser;
    private final String EDIT_STRING =  "edit 2 des/Tutorial d/22-10-2020 st/1900 et/2000";
    private Command command;
    private CommandResult result;

    @BeforeEach
    public void setup() throws InvalidPriorityException, InvalidDatetimeException {
        parser = new Parser();
        tasks = new TaskList();
        date = LocalDate.of(2020,10,22);
        startTime = LocalTime.of(19,00);
        endTime = LocalTime.of(20,00);
        priority = Priority.LOW;
        meeting = new Task("meeting", "13-10-2020", "2000", "2200", "2");
        lecture = new Task("lecture", "20-10-2020", "1800", null, null);
    }

    @Test
    void editTask() throws
            UnknowCommandException, InvalidCommandException,
            InvalidPriorityException, InvalidTaskNumberException,
            InvalidDatetimeException {
        tasks.addTask(meeting);
        tasks.addTask(lecture);
        command = parser.processRaw(EDIT_STRING);
        result = command.execute(tasks);
        assertEquals(lecture.getDescription(),"Tutorial");
        assertEquals(lecture.getDate(),date);
        assertEquals(lecture.getStartTime(),startTime);
        assertEquals(lecture.getEndTime(),endTime);
        assertEquals(lecture.getPriority(),priority);
        assertTrue(tasks.contains(meeting));

    }

}