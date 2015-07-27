package errors;

/**
 * Error entities that throw or generate the errors
 *
 * The most commonly used entities are listed
 *
 * Total 8 bits
 *
 * Users have the ability to extend the entities for their own projects
 */

public class Entity {
  public static final int SYSTEM = 0;
  public static final int GENERIC = 0;
  public static final int UNKNOWN = 1;
  public static final int USER = 2;
  public static final int DATABASE = 3;
  public static final int IMAGE = 4;
  public static final int EMAIL = 5;
  public static final int FILE = 6;
  public static final int ADMIN = 7;
  public static final int PASSWORD = 8;
  public static final int INPUT = 9;
  public static final int NUMERIC = 10;
  public static final int CATEGORY = 11;
  public static final int NAME = 12;
  public static final int PHONE = 13;
  public static final int MERCHANT = 14;
  public static final int NETWORK = 15;
}
