package errors;

/**
 *  Error events that throw or generate the errors
 *
 *  The most commonly used events are listed
 *
 *  Total 8 bits
 *
 *  Users have the ability to extend the events for their own projects
 *
 */

public class Event {
  public static final int NONE = 0;
  public static final int REGISTER = 1;
  public static final int LOGIN = 2;
  public static final int LOGOUT = 3;

  public static final int CREATE = 4;

  //Alias have the same value
  public static final int RETRIEVE = 5;
  public static final int READ = 5;
  public static final int GET = 5;

  public static final int UPDATE = 6;
  public static final int REMOVE = 7;
  public static final int DELETE = 7;
}
