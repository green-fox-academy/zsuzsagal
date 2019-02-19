package enums;

public enum Priority {
  HIGHEST("Highest"),
  HIGH("High"),
  MEDIUM("Medium"),
  LOW("Low"),
  LOWEST("Lowest");

  private final String value;
  Priority(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
