package enums;

public enum ProjectType {
    SANDBOX ("SANDBOX"),
    HOTDOG ("HOTDOG"),
    VIKTOR ("VIKTOR-23"),
    KOALA ("koala project");

    private final String stringValue;

    ProjectType(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getStringValue() {
        return this.stringValue;
    }
    }
