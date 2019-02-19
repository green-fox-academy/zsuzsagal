package enums;

public enum StatusType {
  TODO("TO DO"),
  INPROGRESS("IN PROGRESS"),
  DONE("DONE");

  private final String value;
  StatusType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
