package errors;

/*
   ERROR CODE FORMAT:
   0x[31-24][23-16][15-8][7-0]
   [0-7]bit : Entity Code,
   [8-15]bit: Property / Entity Code
   [16-23]bit: Event Code
   [24-31]bit: Error Type Code
   */

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class WebErrors extends Util {
  private static final String TAG = "WebErrors";
  String version = "0.0.1";
  String locale = "en-US";

//  public HashMap<String , Error> addAllError() {
//        add("SUCCESS", Util.make(0, 0, Event.NONE, Type.SUCCEEDED), "Success!");
//        add("FAILURE", Util.make(0, 0, 0, Type.FAILURE), "Failure!");
//        add("FAILED", Util.make(0, 0, 0, Type.FAILED), "Failed!");
//        add("ERROR", Util.make(0, 0, 0, Type.ERROR), "Error!");
//        add("NOT_FOUND", Util.make(Entity.GENERIC, 0, 0, Type.NOT_FOUND), "Not Found!");
//        add("EXISTED", Util.make(Entity.GENERIC, 0, 0, Type.EXISTED), "Existed!");
//        add("NOT_SPECIFIED", Util.make(Entity.GENERIC, 0, 0, Type.NOT_SPECIFIED), "Not Specified!");
//        add("NOT_LOGIN", Util.make(Entity.GENERIC, 0, 0, Type.NOT_LOGIN), "Not Login!");
//        add("REQUIRED", Util.make(Entity.GENERIC, 0, 0, Type.REQUIRED), "Required!");
//        add("UNKNOWN_ERROR", Util.make(Entity.UNKNOWN, 0, 0, Type.FAILURE), "Unknown Error!");
//        add("USER_EXISTED", Util.make(Entity.USER, 0, 0, Type.EXISTED), "User Existed!");
//        add("USER_NOT_FOUND", Util.make(Entity.USER, 0, 0, Type.EXISTED), "User Not Found!");
//        add("USER_NOT_LOGIN", Util.make(Entity.USER, 0, 0, Type.NOT_LOGIN), "User Not Login!");
//        add("USERNAME_EXISTED", Util.make(Entity.USER, 0, 0, Type.EXISTED), "Username Existed!");
//        add("DATABASE_ERROR", Util.make(Entity.DATABASE, 0, 0, Type.FAILURE), "Database Error!");
//        add("PASSWORD_ERROR", Util.make(Entity.PASSWORD, 0, 0, Type.ERROR), "Password Error!");
//        add("FILE_NOT_FOUND", Util.make(Entity.FILE, 0, 0, Type.NOT_FOUND), "File Not Found!");
//        add("ADMIN_EXISTED", Util.make(Entity.ADMIN, 0, 0, Type.EXISTED), "Administrator Existed!");
//        add("ADMIN_NOT_FOUND", Util.make(Entity.ADMIN, 0, 0, Type.EXISTED), "Administrator Not Found!");
//        add("ADMIN_NOT_LOGIN", Util.make(Entity.GENERIC, 0, 0, Type.NOT_LOGIN), "Administrator Not Login!");
//        add("MERCHANT_NOT_LOGIN", Util.make(Entity.MERCHANT, 0, 0, Type.NOT_LOGIN), "Merchant Not Login!");
//        add("UPDATE_FAILED", Util.make(0, 0, Event.UPDATE, Type.FAILED), "Update Failed!");
//        add("INPUT_INVALID", Util.make(Entity.INPUT, 0, 0, Type.FAILED), "Input Invalid!");
//        add("NUMERIC_REQUIRED", Util.make(Entity.NUMERIC, 0, 0, Type.REQUIRED), "Numeric Required!");
//        add("NAME_NOT_SPECIFIED", Util.make(Entity.NAME, 0, 0, Type.NOT_SPECIFIED), "Name Not Specified!");
//        add("PASSWORD_NOT_SPECIFIED", Util.make(Entity.PASSWORD, 0, 0, Type.NOT_SPECIFIED), "Password Not Specified!");
//        add("EMAIL_NOT_SPECIFIED", Util.make(Entity.EMAIL, 0, 0, Type.NOT_SPECIFIED), "Email Not Specified!");
//        add("CATEGORY_NOT_FOUND", Util.make(Entity.CATEGORY, 0, 0, Type.NOT_FOUND), "Category Not Found!");
//        add("EMAIL_EXISTED", Util.make(Entity.EMAIL, 0, 0, Type.EXISTED), "Email Existed!");
//        add("PHONE_EXISTED", Util.make(Entity.PHONE, 0, 0, Type.EXISTED), "Phone Existed!");
//        add("NETWORK_ERROR", Util.make(Entity.NETWORK, 0, 0, Type.ERROR), "Network Error Occurred!");
//        return errors;
//  }

  public void setLocale(String locale) {
    this.locale = locale;
  }
}