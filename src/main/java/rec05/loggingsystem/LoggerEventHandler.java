package rec05.loggingsystem;

public interface LoggerEventHandler {
    void onStart(String startMessage);

    void onWriteDebug(String bugMessage);

    void onWriteError(String errorMessage);

    void onClose(String closeMessage);
}
