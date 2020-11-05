package ui;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import command.Command;
import parser.CommandFlag;

/**
 * This class manages the output of text.
 */
public final class Printer {
    private boolean isDisplayingHelpMessages = true;

    private static final String LINE = "----------------------------------------------------------------"
            + "----------------------------------------";
    private static final String NEWLINE = System.lineSeparator();

    public ConsoleColorsEnum textColor;
    public ConsoleColorsEnum favColor;
    public ConsoleColorsEnum logoColor;
    public ConsoleColorsEnum nameColor;
    public ConsoleColorsEnum subjectColor;
    public ConsoleColorsEnum detailsColor;
    public ConsoleColorsEnum alertColor;
    public ConsoleColorsEnum reset;

    public Printer() {
        textColor = ConsoleColorsEnum.WHITE_TEXT;
        favColor = ConsoleColorsEnum.BRIGHT_YELLOW_TEXT;
        logoColor = ConsoleColorsEnum.BRIGHT_CYAN_TEXT;
        nameColor = ConsoleColorsEnum.BRIGHT_CYAN_TEXT;
        subjectColor = ConsoleColorsEnum.BRIGHT_BLUE_TEXT;
        detailsColor = ConsoleColorsEnum.WHITE_TEXT;
        alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
        reset = ConsoleColorsEnum.WHITE_TEXT;
    }

    public void print(Object obj) {
        System.out.println(obj);
    }

    public void printWelcomeScreen() {
        print(logoColor
                + " ________  ___  ___  _______   ________  _________  ________  "
                + "___  ___  _______   _______  _________" + NEWLINE
                + "|\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\   __  \\|\\___   ___\\"
                + "\\   ____\\|\\  \\|\\  \\|\\  ___ \\ |\\  ___ \\|\\___   ___\\" + NEWLINE
                + "\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\  \\|\\  \\|___ \\  "
                + "\\_\\ \\  \\___|\\ \\  \\\\\\  \\ \\   __/|\\ \\   __/\\|___ \\  \\_|" + NEWLINE
                + " \\ \\  \\    \\ \\   __  \\ \\  \\_|/_\\ \\   __  \\   \\ \\  \\ "
                + "\\ \\_____  \\ \\   __  \\ \\  \\_|/_\\ \\  \\_|/__  \\ \\  \\" + NEWLINE
                + "  \\ \\  \\____\\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\ \\  \\   \\ \\  "
                + "\\ \\|____|\\  \\ \\  \\ \\  \\ \\  \\_|\\ \\ \\  \\_|\\ \\  \\ \\  \\" + NEWLINE
                + "   \\ \\_______\\ \\__\\ \\__\\ \\_______\\ \\__\\ \\__\\   \\ \\__"
                + "\\  ____\\_\\  \\ \\__\\ \\__\\ \\_______\\ \\_______\\  \\ \\__\\" + NEWLINE
                + "    \\|_______|\\|__|\\|__|\\|_______|\\|__|\\|__|    \\|__| |\\____"
                + "_____\\|__|\\|__|\\|_______|\\|_______|   \\|__|" + NEWLINE
                + "                                      ___       ________  ________" + NEWLINE
                + "                                     |\\  \\     |\\   __  \\|\\   ____\\" + NEWLINE
                + "                                     \\ \\  \\    \\ \\  \\|\\  \\ \\  \\___|" + NEWLINE
                + "                                      \\ \\  \\    \\ \\  \\\\\\  \\ \\  \\  ___" + NEWLINE
                + "                                       \\ \\  \\____\\ \\  \\\\\\  \\ \\  \\|\\  \\" + NEWLINE
                + "                                        \\ \\_______\\ \\_______\\ \\_______\\" + NEWLINE
                + "                                         \\|_______|\\|_______|\\|_______|" + NEWLINE
                + LINE + NEWLINE
                + "Welcome to CheatLogs, the one stop cheat sheet management systems" + NEWLINE
                + "Your CAP is our upmost priority"
                + reset
        );
    }

    public void printExitLogo() {
        print(logoColor
                + " ________  ________  ________  ________  ________      ___    ___ _______" + NEWLINE
                + "|\\   ____\\|\\   __  \\|\\   __  \\|\\   ___ \\|\\   __  "
                + "\\    |\\  \\  /  /|\\  ___ \\" + NEWLINE
                + "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\_|\\ \\ \\  "
                + "\\|\\ /_   \\ \\  \\/  / | \\   __/|" + NEWLINE
                + " \\ \\  \\  __\\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\ \\\\ \\ "
                + "\\   __  \\   \\ \\    / / \\ \\  \\_|/__" + NEWLINE
                + "  \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\_\\\\ \\"
                + " \\  \\|\\  \\   \\/  /  /   \\ \\  \\_|\\ \\" + NEWLINE
                + "   \\ \\_______\\ \\_______\\ \\_______\\ \\_______\\ \\_______\\"
                + "__/  / /      \\ \\_______\\" + NEWLINE
                + "    \\|_______|\\|_______|\\|_______|\\|_______|\\|_______|\\___"
                + "/ /        \\|_______|" + NEWLINE
                + "                                                     \\|___|/" + NEWLINE
                + reset
        );
    }

    public void printUserInputPrompt() {
        print(LINE + "" + NEWLINE + NEWLINE + "Please enter a Command:");
    }

    public void printHelpSheet() {
        print(ConsoleColorsEnum.BOLD + "" + logoColor + "/add /n <CHEAT_SHEET_NAME> /s <SUBJECT>"
                + reset + NEWLINE
                + "\tAdds a new cheat sheet to the application and prompts user to include data" + NEWLINE
                + "\tinto the cheat sheet." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/clear"
                + reset + NEWLINE
                + "\tClears all entries from the cheat sheet." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/delete /i <CHEAT_SHEET_INDEX>"
                + reset + NEWLINE
                + ConsoleColorsEnum.BOLD + "" + favColor + "/delete /n <CHEAT_SHEET_NAME>"
                + reset + NEWLINE
                + "\tTo be used after using /list, Deletes the cheat sheet at INDEX items down the list." + NEWLINE
                + "\tThe first cheat sheet has an index of 1." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/edit /i <CHEAT_SHEET_INDEX>"
                + reset + NEWLINE
                + ConsoleColorsEnum.BOLD + "" + favColor + "/edit /n <CHEAT_SHEET_NAME>"
                + reset + NEWLINE
                + "\tEdits the details/content of the cheat sheet." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/exit"
                + reset + NEWLINE
                + "\tExits the application." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/fav /i <CHEAT_SHEET_INDEX>"
                + reset + NEWLINE
                + ConsoleColorsEnum.BOLD + "" + favColor + "/fav /n <CHEAT_SHEET_NAME>"
                + reset + NEWLINE
                + "\tMarks the cheat sheet as favourite." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/find /s <SUBJECT> /k <KEYWORD>"
                + reset + NEWLINE
                + "\tFinds a cheat sheet whose names contain any of the given keywords." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/help"
                + reset + NEWLINE
                + "\tDisplays this help message." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/list"
                + reset + NEWLINE
                + "\tLists all the possible commands that can be executed in the application." + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/set /c <OPTION_NUMBER>"
                + reset + NEWLINE
                + "\tChanges the color scheme of the application. Available options: 1 - 3."
                + "Type 0 to reset to default color scheme" + NEWLINE

                + ConsoleColorsEnum.BOLD + "" + logoColor + "/view /i <CHEAT_SHEET_INDEX>"
                + reset + NEWLINE
                + ConsoleColorsEnum.BOLD + "" + favColor + "/view /n <CHEAT_SHEET_NAME>"
                + reset + NEWLINE
                + "\tView the contents of a cheat sheet either by the name or index." + NEWLINE);
    }

    public void printCheatSheet(CheatSheet cheatSheet) {
        print(nameColor + "\tName: " + cheatSheet.getName() + NEWLINE
                + subjectColor + "\tSubject: " + cheatSheet.getSubject() + NEWLINE
                + detailsColor + "\tDetails: " + cheatSheet.getWrappedDetails()
                + reset);
    }

    public void printCheatSheetSize(CheatSheetList cheatSheetList) {
        print(textColor + "Now you have " + cheatSheetList.getSize() + " cheatsheet(s)" + reset);
    }

    public void printAddNewCheatSheetMessage(CheatSheet cheatSheet, CheatSheetList cheatSheetList) {
        print(textColor + "Added new cheat sheet:" + reset);
        printCheatSheet(cheatSheet);
        print(textColor + LINE + reset);
        printCheatSheetSize(cheatSheetList);
    }

    public void printClearCheatSheetMessage(int number) {
        print(textColor + "Cleared total of " + number + " cheat sheets");
        print(LINE);
        print("Now you have no cheatsheets" + reset);
    }

    public void printDeleteConfirmation(CheatSheet cheatSheet) {
        print(alertColor + "Are you sure to delete the" + cheatSheet.getName() + " cheatsheet?" + NEWLINE
                + "Type Y or Yes to confirm, or any other character to cancel" + reset);
    }

    public void printDeleteCheatSheetMessage(CheatSheet cheatSheet, CheatSheetList cheatSheetList) {
        print(textColor + "This cheat sheet has been deleted: " + reset);
        printCheatSheet(cheatSheet);
        print(textColor + LINE + reset);
        printCheatSheetSize(cheatSheetList);
    }

    public void printViewCheatSheetMessage(CheatSheet cheatSheet) {
        print(textColor + "This is your content for " + cheatSheet.getName() + ": " + reset);
        printCheatSheet(cheatSheet);
    }

    public void printFavouritedCheatSheetMessage(CheatSheet cheatSheet) {
        print(textColor + "This cheat sheet has been favourited: " + reset);
        printCheatSheet(cheatSheet);
    }

    public void printAlternativeArgumentPrompt(Command command) {
        print(NEWLINE);
        System.out.print(ConsoleColorsEnum.RED_TEXT + "Please enter at least ONE of these: ");
        for (CommandFlag arg : command.getAlternativeArguments()) {
            System.out.print(arg + " ");
        }
        print(reset);
        print(NEWLINE);
    }

    public void printMissingArgument(CommandFlag curArg) {
        System.out.print(textColor + "Please input " + curArg.name() + ": " + reset);
    }

    public void setColor(int option) {
        switch (option) {
        case 1:
            textColor = ConsoleColorsEnum.WHITE_TEXT;
            favColor = ConsoleColorsEnum.BRIGHT_GREEN_TEXT;
            logoColor = ConsoleColorsEnum.BRIGHT_GREEN_TEXT;
            nameColor = ConsoleColorsEnum.BRIGHT_MAGENTA_TEXT;
            subjectColor = ConsoleColorsEnum.BOLD_MAGENTA_TEXT;
            detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        case 2:
            textColor = ConsoleColorsEnum.WHITE_TEXT;
            favColor = ConsoleColorsEnum.BRIGHT_BLUE_TEXT;
            logoColor = ConsoleColorsEnum.BRIGHT_BLUE_TEXT;
            nameColor = ConsoleColorsEnum.BRIGHT_RED_TEXT;
            subjectColor = ConsoleColorsEnum.BOLD_YELLOW_TEXT;
            detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        case 3:
            textColor = ConsoleColorsEnum.WHITE_TEXT;
            favColor = ConsoleColorsEnum.BOLD_WHITE_TEXT;
            logoColor = ConsoleColorsEnum.WHITE_TEXT;
            nameColor = ConsoleColorsEnum.BOLD_WHITE_TEXT;
            subjectColor = ConsoleColorsEnum.WHITE_TEXT;
            detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        default:
            textColor = ConsoleColorsEnum.WHITE_TEXT;
            favColor = ConsoleColorsEnum.BRIGHT_YELLOW_TEXT;
            logoColor = ConsoleColorsEnum.BRIGHT_CYAN_TEXT;
            nameColor = ConsoleColorsEnum.BRIGHT_CYAN_TEXT;
            subjectColor = ConsoleColorsEnum.BRIGHT_BLUE_TEXT;
            detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        }
        if (option < 0 || option > 3) {
            print("Invalid option " + option + ". Changed color scheme to default colors:\n"
                    + favColor + "\tColor 1\n"
                    + nameColor + "\tColor 2\n"
                    + subjectColor + "\tColor 3\n"
                    + reset);
        } else {
            print("Changed color scheme to option " + option + ":\n"
                    + favColor + "\tColor 1\n"
                    + nameColor + "\tColor 2\n"
                    + subjectColor + "\tColor 3\n"
                    + reset);
        }
    }

    // prints all colors, for debugging purposes only
    public void printColors() {
        print(ConsoleColorsEnum.BLACK_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_BLACK_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_BLACK_TEXT + "TEST\n" + reset);

        print(ConsoleColorsEnum.WHITE_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_WHITE_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_WHITE_TEXT + "TEST\n" + reset);

        print(ConsoleColorsEnum.BLUE_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_BLUE_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_BLUE_TEXT + "TEST\n" + reset);

        print(ConsoleColorsEnum.RED_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_RED_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_RED_TEXT + "TEST\n" + reset);

        print(ConsoleColorsEnum.CYAN_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_CYAN_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_CYAN_TEXT + "TEST\n" + reset);

        print(ConsoleColorsEnum.YELLOW_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_YELLOW_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_YELLOW_TEXT + "TEST\n" + reset);

        print(ConsoleColorsEnum.GREEN_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_GREEN_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_GREEN_TEXT + "TEST\n" + reset);

        print(ConsoleColorsEnum.MAGENTA_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BRIGHT_MAGENTA_TEXT + "TEST\n" + reset);
        print(ConsoleColorsEnum.BOLD_MAGENTA_TEXT + "TEST\n" + reset);
    }

    public void printStartHelpMessage() {
        print(NEWLINE + "Here are some basics commands to get you started: "
            + NEWLINE + "\t\"/add\": Add your own cheat sheet"
            + NEWLINE + "\t\"/list\": List all cheat sheet you currently own, including those we preloaded for you"
            + NEWLINE + "\t\"/view\": View the contents of a specific cheat sheet, we recommend you to use the list "
            + "command before this. " + NEWLINE + "\t\t\t You can view the contents using cheat sheet index or name."
            + NEWLINE + "Enter \"/help\" to see the details of all commands");
    }

    private void printRepeatedHelpMessagePartOne(String commandType) {
        print("The " + commandType + " does not work alone."
            + NEWLINE + "We need some necessary information from you before we could add your cheat sheet."
            + NEWLINE + "Don't worry, you do not have to enter the command again."
            + NEWLINE + "We would prompt you to enter the necessary information, one by one.");
    }

    private void printRepeatedHelpMessagePartTwo() {
        print("You also could enter the full command next time if you do not wish to be prompted to enter fields "
            + "one by one" + NEWLINE + "\"/help\" to see more details on the structure of full command."
            + NEWLINE + "To stop messages like this from appearing again, input this command: \"/set /m remove\"");
    }

    public void printAddCommandHelpMessage() {
        printRepeatedHelpMessagePartOne("ADD");
        print("NAME is necessary while SUBJECT isn't. <<enter>> to skip field."
            + NEWLINE + "We will automatically assign \"Unsorted\" as subject if no subject is provided." + NEWLINE);
        printRepeatedHelpMessagePartTwo();
    }

    public void printClearCommandHelpMessage() {
        print("The CLEAR command clears ALL cheat sheets except for those that are preloaded."
            + NEWLINE + "Please consider twice before proceeding");
    }

    public void printDeleteCommandHelpMessage() {
        print("The DELETE command deletes a cheatsheet you specifies. Please consider twice before proceeding");
        printRepeatedHelpMessagePartOne("DELETE");
        print("We need you to either input NAME or INDEX. <<enter>> to skip field.");
        printRepeatedHelpMessagePartTwo();
    }

    public void printEditCommandHelpMessage() {
        print("The EDIT command edits an existing cheat sheet.");
        printRepeatedHelpMessagePartOne("EDIT");
        print("We need you to input either NAME or INDEX. <<enter>> to skip field.");
        printRepeatedHelpMessagePartTwo();
    }

    public void printFindCommandHelpMessage() {
        print("The EDIT command finds an existing cheat sheet based on information provided.");
        printRepeatedHelpMessagePartOne("FIND");
        print("We need you to input NAME, SUBJECT, or KEYWORD in cheatsheet or any combinations of these fields."
            + "<<enter>> to skip field.");
        printRepeatedHelpMessagePartTwo();
    }

    public void printListCommandHelpMessage() {
        print("The LIST command lists all current existing cheat sheets."
            + NEWLINE + "You could also sort the cheat sheets according to name or subject alphabetical order"
            + NEWLINE + "To stop messages like from appearing again, input this command: \"/set /m remove\"");
    }

    public void setDisplayingHelpMessages(boolean isDisplayingHelpMessages) {
        this.isDisplayingHelpMessages = isDisplayingHelpMessages;
    }

    public boolean getDisplayingHelpMessages() {
        return this.isDisplayingHelpMessages;
    }

}
