package rec05.loggingsystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Supports writing of debug and error messages (with different prefixes) to
 * either the console or an output file. Configurable via constant fields within
 * the class.
 * 
 */
public class Logger {

	private final List<LoggerEventHandler> listeners;

	private static final String DEBUG_PREFIX = "[Debug]";
	private static final String ERROR_PREFIX = "[Error]";
	private static final String LOGGER_STARTED_UP = "Logger started up.";
	private static final String LOGGER_SHUTTING_DOWN = "Logger shutting down.";


	public Logger() {
		listeners = new ArrayList<>();
	}

	public void addListener(LoggerEventHandler listener) {
		listeners.add(listener);
	}

	public void start() {
		for (LoggerEventHandler listener : listeners) {
			listener.onStart(LOGGER_STARTED_UP);
		}
	}

	/**
	 * Writes a debug message to the logging system.
	 * 
	 * @param message The debug message to write.
	 */
	public void writeDebug(String message) {
		String logLine = DEBUG_PREFIX + " " + message;
		for (LoggerEventHandler listener : listeners) {
			listener.onWriteDebug(logLine);
		}
	}

	/**
	 * Writes an error message to the logging system.
	 * 
	 * @param error The error message to write.
	 */
	public void writeError(String error) {
		String logLine = ERROR_PREFIX + " " + error;
		for (LoggerEventHandler listener : listeners) {
			listener.onWriteError(logLine);
		}
	}

	/**
	 * Shuts down the logging system. After this method is called, the logger
	 * should not be used.
	 */
	public void close() {
		for (LoggerEventHandler listener : listeners) {
			listener.onClose(LOGGER_SHUTTING_DOWN);
		}
	}

}
