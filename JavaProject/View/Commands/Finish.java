package JavaProject.View.Commands;

import JavaProject.View.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Finish";
    }

    public void execute(){
        consoleUI.finish();
    }
}
