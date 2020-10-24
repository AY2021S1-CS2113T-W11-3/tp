package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import parser.CommandFlag;
import ui.Printer;

public class AddCommand extends Command {
    private final Editor editor;

    public static final String invoker = "/add";


    public AddCommand(Printer printer, Editor editor) {
        super(printer);
        this.editor = editor;

        flagToDescription.put(CommandFlag.NAME, null);
        flagToDescription.put(CommandFlag.SUBJECT, null);
        alternativeArguments.add(CommandFlag.NAME);
    }

    @Override
    public void execute() throws CommandException {
        String name = flagToDescription.get(CommandFlag.NAME);
        if (CheatSheetList.exists(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }

        String subject = flagToDescription.get(CommandFlag.SUBJECT);
        if (subject != null) {
            subject = convertToPascalCaseNoSpace(subject);
        }

        callContentEditor();
        String description = editor.getContent();

        CheatSheet cheatSheet = new CheatSheet(name, subject, description);
        CheatSheetList.add(cheatSheet);
        printer.printAddNewCheatSheetMessage(cheatSheet);
    }

    private void callContentEditor() {
        editor.open();
        editor.waitForClose();
    }

    private String convertToPascalCaseNoSpace(String input) {
        String[] splitInput = input.split("\\p{IsWhite_Space}+");
        for (int i = 0; i < splitInput.length; i++) {
            splitInput[i] = splitInput[i].substring(0, 1).toUpperCase() + splitInput[i].substring(1).toLowerCase();
        }

        return String.join("", splitInput);
    }
}
