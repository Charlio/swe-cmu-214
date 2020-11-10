package rec05.loggingsystem;

public class ConsoleListener implements LoggerEventHandler {
    @Override
    public void onStart(String startMessage) {
        System.out.println(startMessage);
    }

    @Override
    public void onWriteDebug(String bugMessage) {
        System.out.println(bugMessage);
    }

    @Override
    public void onWriteError(String errorMessage) {
        System.out.println(errorMessage);
    }

    @Override
    public void onClose(String closeMessage) {
        System.out.println(closeMessage);
    }
}
