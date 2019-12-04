package hr.hep.tesla.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

public class TeslaException extends Exception {
	private static final long serialVersionUID = -543671475416882384L;

	protected List<MessageCode> messageCodes;

	public TeslaException() {
		super();
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public TeslaException(MessageCode messageCode) {
		super();
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public TeslaException(List<MessageCode> messageCodes) {
		super();
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public TeslaException(String message) {
		super(message);
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public TeslaException(String message, MessageCode messageCode) {
		super(message);
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public TeslaException(String message, List<MessageCode> messageCodes) {
		super(message);
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public TeslaException(Throwable cause) {
		super(cause);
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public TeslaException(Throwable cause, MessageCode messageCode) {
		super(cause);
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public TeslaException(Throwable cause, List<MessageCode> messageCodes) {
		super(cause);
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public TeslaException(String message, Throwable cause) {
		super(message, cause);
		this.messageCodes = new ArrayList<MessageCode>();
	}

	public TeslaException(String message, Throwable cause, MessageCode messageCode) {
		super(message, cause);
		this.messageCodes = new ArrayList<MessageCode>();
		this.messageCodes.add(messageCode);
	}

	public TeslaException(String message, Throwable cause, List<MessageCode> messageCodes) {
		super(message, cause);
		this.messageCodes = new ArrayList<MessageCode>(messageCodes);
	}

	public List<MessageCode> getMessageCodes() {
		return messageCodes;
	}

	public void setMessageCodes(List<MessageCode> messageCodes) {
		this.messageCodes = messageCodes;
	}

	public String toStackTrace() {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		this.printStackTrace(pw);

		return sw.getBuffer().toString();
	}

}
