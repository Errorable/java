package errors;

/**
 * Created by eric on 15/4/2.
 */
public class Error {
  int code;
  String message;
  Error(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
