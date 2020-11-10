package rec05.loggingsystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileListener implements LoggerEventHandler {
    private final PrintWriter fileOut;

    public FileListener(String logFileName) {
        try {
            fileOut = new PrintWriter(new File(logFileName));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onStart(String startMessage) {
        fileOut.println(startMessage);
    }

    @Override
    public void onWriteDebug(String bugMessage) {
        fileOut.println(bugMessage);
    }

    @Override
    public void onWriteError(String errorMessage) {
        fileOut.println(errorMessage);
    }

    @Override
    public void onClose(String closeMessage) {
        fileOut.println(closeMessage);
        fileOut.close();
    }
}
