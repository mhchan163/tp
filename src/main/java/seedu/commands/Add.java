package seedu.commands;

import seedu.data.TaskList;
import seedu.exceptions.InvalidCommandException;
import seedu.exceptions.InvalidDatetimeException;
import seedu.exceptions.InvalidPriorityException;
import seedu.task.Task;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static seedu.messages.Messages.ADD_MESSAGE;

public class Add extends Command {
    public static final String COMMAND_WORD = "add";
    // Default date: day that the task is created, default priority: 0 (low to high: 0 - 2)
    private static final Pattern COMMAND_PATTERN = Pattern.compile(
            "^add (?<description>(\\w+\\s*)+\\w*)"
                    + "( d/(?<date>\\d{2}-\\d{2}-\\d{4}))?"
                    + "( st/(?<st>\\d{4}))?"
                    + "( et/(?<et>\\d{4}))?"
                    + "( p/(?<priority>\\d))?$");
    private final String description;
    private final String date;
    private final String startTime;
    private final String endTime;
    private final String priority;

    public Add(String rawInput) throws InvalidCommandException {
        Matcher matcher = COMMAND_PATTERN.matcher(rawInput);
        if (matcher.find()) {
            description = matcher.group("description");
            date = matcher.group("date");
            startTime = matcher.group("st");
            endTime = matcher.group("et");
            priority = matcher.group("priority");
        } else {
            throw new InvalidCommandException();
        }
    }

    @Override
    public CommandResult execute(TaskList tasks) throws InvalidPriorityException, InvalidDatetimeException {
        Task task = new Task(description, date, startTime, endTime, priority);
        tasks.addTask(task);
        // task arg not in used, in case want change display message.
        return new CommandResult(ADD_MESSAGE, tasks, task);
    }
}
