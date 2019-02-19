package enums;

public enum Status {
    OPEN ("OPEN"),
    TODO ("TO DO"),
    INPROGRESS ("IN PROGRESS"),
    DONE ("DONE"),
    STUCK ("STUCK"),
    REVIEW ("REVIEW"),
    CLOSED ("CLOSED");

    private final String stringValue;

    Status (String stringValue) {
        this.stringValue = stringValue;
    }
    public String getStringValue () {
        return this.stringValue;
    }
}
