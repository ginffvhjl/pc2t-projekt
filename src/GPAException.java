public class GPAException extends Exception {
    public GPAException() {
        super("Nebyl zadán průměr");
    }

    public GPAException(float average) {
        super(ConsoleColours.RED + "Průměr nebyl zadán v intervalu <1,5>" + ConsoleColours.RESET);
    }
}
