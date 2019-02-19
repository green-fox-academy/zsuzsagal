package enums;

public enum IssueType {
  TASK("Task"),
  STORY("Story"),
  EPIC("Epic"),
  INCIDENT("Incident"),
  BUG("Bug");

  private final String value;
  IssueType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
