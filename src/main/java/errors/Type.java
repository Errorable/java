package errors;

/**
 *  Error types that thrown or generated
 *
 *  The most commonly used types are listed
 *
 *  Total 8 bits
 *
 *  Users have the ability to extend the types for their own projects
 *
 */

public class Type {
  //Basic error types
  public static final int SUCCEEDED = 0;
  //Alias can be of the same value
  public static final int FAILURE = 1;
  public static final int FAILED = 1;
  public static final int ERROR = 1;

  //Validation error types
  public static final int INVALID = 2;
  public static final int MISMATCH = 3;
  public static final int REQUIRED = 4;

  //Existence related
  public static final int NOT_FOUND = 5;
  public static final int EXISTED = 6;

  //Accessibility or authentication related
  public static final int NOT_LOGIN = 7;
  public static final int EXPIRED = 8;
  public static final int BLOCKED = 9;

  //Resources related
  public static final int EXCEEDED = 10;

  //Input related
  public static final int NOT_SPECIFIED = 11;
}
