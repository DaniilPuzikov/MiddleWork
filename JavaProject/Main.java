package JavaProject;

import JavaProject.View.ConsoleUI;
import JavaProject.View.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}
