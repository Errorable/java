package errors;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class Util {
  public static HashMap<String , Error> errors = new HashMap<String , Error>();
  public static HashMap<String , JSONObject> locales = new HashMap<String , JSONObject>();


  Util() {

  }

  /**
   * Easy way to make an error code
   * @param entity
   * @param property
   * @param event
   * @param type
   * @returns {number}
   */
  public static Integer make(int entity, int property, int event, int type) {
    return (entity << 24) | (property << 16) | (event << 8) | type;
  }
  /**
   * Easy way to make a custom error code
   * @param entity
   * @param property
   * @param event
   * @param type
   * @returns {number}
   */
  public Integer customeMake(int entity, int property, int event, int type) {
    return make(entity | 0x80, property | 0x80, event | 0x80, type | 0x80);
  }
  /**
   * Add an error with a name, a code, a message
   *
   * @param name
   * @param code
   * @param message
   * @returns {boolean}
   */
  public static boolean add(String name, int code, String message) {
    Error e = errors.get(name);
    if (e != null) {
      return false;
    }
    errors.put(name, new Error(code, message));
    return true;
  }


  /**
   * Update a locale item
   * @param name
   * @param value
   * @param locale
   * @returns {boolean}
   */
  public static boolean updateLocaleItem(String name, String value, String locale) {
    if (name == null || value == null || locale == null) {
      return false;
    }

    JSONObject json = locales.get(locale);
    if (json == null) {
      json = new JSONObject();
    }
    try {

      json.put(name, value);
    } catch (JSONException e) {
      e.printStackTrace();
      return false;
    }
    return true;

  }
  /**
   * Get localized message
   * @param key
   * @param locale
   * @returns {*}
   */
  public String lang(String key, String locale) {
    if (locale == null || locale == "") {
      locale = "en";
    }
    JSONObject json = locales.get(locale);
    if (json != null) {
      try {
        return json.get(key).toString();
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return key;
  }

  public static int queryErrorMessageByCode(int code) {
    int result = 80;
    switch (code) {
      case (0 << 24) | (0 << 16) | (Event.NONE << 8) | Type.SUCCEEDED:
        result = ErrorName.SUCCESS;
        break;
      case (0 << 24) | (0 << 16) | (0 << 8) | Type.FAILURE:
        result = ErrorName.FAILURE;
        break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  ErrorName.NOT_FOUND;
      break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  ErrorName.EXISTED;
      break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  ErrorName.NOT_SPECIFIED;
      break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  ErrorName.NOT_LOGIN;
      break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.REQUIRED:
        result =  ErrorName.REQUIRED;
      break;
      case (Entity.UNKNOWN << 24) | (0 << 16) | (0 << 8) | Type.FAILURE:
        result =  ErrorName.UNKNOWN_ERROR;
      break;
      case (Entity.USER << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  ErrorName.USER_EXISTED;
      break;
      case (Entity.USER << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  ErrorName.USER_NOT_FOUND;
      break;
      case (Entity.USER << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  ErrorName.USER_NOT_LOGIN;
      break;
      case (Entity.USER << 24) | (Entity.NAME << 16) | (0 << 8) | Type.EXISTED:
        result =  ErrorName.USERNAME_EXISTED;
      break;
      case (Entity.DATABASE << 24) | (0 << 16) | (0 << 8) | Type.FAILURE:
        result =  ErrorName.DATABASE_ERROR;
      break;
      case (Entity.PASSWORD << 24) | (0 << 16) | (0 << 8) | Type.ERROR:
        result =  ErrorName.PASSWORD_ERROR;
      break;
      case (Entity.FILE << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  ErrorName.FILE_NOT_FOUND;
      break;
      case (Entity.ADMIN << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  ErrorName.ADMIN_EXISTED;
      break;
      case (Entity.ADMIN << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  ErrorName.ADMIN_NOT_FOUND;
      break;
      case (Entity.ADMIN << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  ErrorName.ADMIN_NOT_LOGIN;
      break;
      case (Entity.MERCHANT << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  ErrorName.MERCHANT_NOT_LOGIN;
      break;
      case (0 << 24) | (0 << 16) | (Event.UPDATE << 8) | Type.FAILED:
        result =  ErrorName.UPDATE_FAILED;
      break;
      case (Entity.INPUT << 24) | (0 << 16) | (0 << 8) | Type.FAILED:
        result =  ErrorName.INPUT_INVALID;
      break;
      case (Entity.NUMERIC << 24) | (0 << 16) | (0 << 8) | Type.REQUIRED:
        result =  ErrorName.NUMERIC_REQUIRED;
      break;
      case (Entity.NAME << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  ErrorName.NAME_NOT_SPECIFIED;
      break;
      case (Entity.PASSWORD << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  ErrorName.PASSWORD_NOT_SPECIFIED;
      break;
      case (Entity.EMAIL << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  ErrorName.EMAIL_NOT_SPECIFIED;
      break;
      case (Entity.CATEGORY << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  ErrorName.CATEGORY_NOT_FOUND;
      break;
      case (Entity.EMAIL << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  ErrorName.EMAIL_EXISTED;
      break;
      case (Entity.PHONE << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  ErrorName.PHONE_EXISTED;
      break;
      case (Entity.NETWORK << 24) | (0 << 16) | (0 << 8) | Type.ERROR:
        result =  ErrorName.NETWORK_ERROR;
      break;
    }
    return result;
  }

  public static String toastErrorMessageByCode(int code) {
    String result = "";
    switch (code) {
      case (0 << 24) | (0 << 16) | (Event.NONE << 8) | Type.SUCCEEDED:
        result = "成功";
        break;
      case (0 << 24) | (0 << 16) | (0 << 8) | Type.FAILURE:
        result = "失败";
        break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  "没有找到";
        break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  "已经存在";
        break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  "未指定";
        break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  "没有登录";
        break;
      case (Entity.GENERIC << 24) | (0 << 16) | (0 << 8) | Type.REQUIRED:
        result =  "必需有";
        break;
      case (Entity.UNKNOWN << 24) | (0 << 16) | (0 << 8) | Type.FAILURE:
        result =  "失败了";
        break;
      case (Entity.USER << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  "用户已经存在";
        break;
      case (Entity.USER << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  "用户未找到";
        break;
      case (Entity.USER << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  "用户未登录";
        break;
      case (Entity.USER << 24) | (Entity.NAME << 16) | (0 << 8) | Type.EXISTED:
        result =  "用户已存在";
        break;
      case (Entity.DATABASE << 24) | (0 << 16) | (0 << 8) | Type.FAILURE:
        result =  "数据库错误";
        break;
      case (Entity.PASSWORD << 24) | (0 << 16) | (0 << 8) | Type.ERROR:
        result =  "密码错误";
        break;
      case (Entity.FILE << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  "文件未找到";
        break;
      case (Entity.ADMIN << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  "管理员已经存在";
        break;
      case (Entity.ADMIN << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  "管理员未找到";
        break;
      case (Entity.ADMIN << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  "管理员未登录";
        break;
      case (Entity.MERCHANT << 24) | (0 << 16) | (0 << 8) | Type.NOT_LOGIN:
        result =  "商户未登录";
        break;
      case (0 << 24) | (0 << 16) | (Event.UPDATE << 8) | Type.FAILED:
        result =  "更新失败";
        break;
      case (Entity.INPUT << 24) | (0 << 16) | (0 << 8) | Type.FAILED:
        result =  "输入无效";
        break;
      case (Entity.NUMERIC << 24) | (0 << 16) | (0 << 8) | Type.REQUIRED:
        result =  "输入必须是数值";
        break;
      case (Entity.NAME << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  "名字未指定";
        break;
      case (Entity.PASSWORD << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  "密码未指定";
        break;
      case (Entity.EMAIL << 24) | (0 << 16) | (0 << 8) | Type.NOT_SPECIFIED:
        result =  "邮箱未指定";
        break;
      case (Entity.CATEGORY << 24) | (0 << 16) | (0 << 8) | Type.NOT_FOUND:
        result =  "分类未找到";
        break;
      case (Entity.EMAIL << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  "邮箱已经存在";
        break;
      case (Entity.PHONE << 24) | (0 << 16) | (0 << 8) | Type.EXISTED:
        result =  "手机已经存在";
        break;
      case (Entity.NETWORK << 24) | (0 << 16) | (0 << 8) | Type.ERROR:
        result =  "网络错误";
        break;
    }
    return result;
  }

  public static HashMap<String , Error> addAllError() {
    add("SUCCESS", Util.make(0, 0, Event.NONE, Type.SUCCEEDED), "Success!");
    add("FAILURE", Util.make(0, 0, 0, Type.FAILURE), "Failure!");
    add("FAILED", Util.make(0, 0, 0, Type.FAILED), "Failed!");
    add("ERROR", Util.make(0, 0, 0, Type.ERROR), "Error!");
    add("NOT_FOUND", Util.make(Entity.GENERIC, 0, 0, Type.NOT_FOUND), "Not Found!");
    add("EXISTED", Util.make(Entity.GENERIC, 0, 0, Type.EXISTED), "Existed!");
    add("NOT_SPECIFIED", Util.make(Entity.GENERIC, 0, 0, Type.NOT_SPECIFIED), "Not Specified!");
    add("NOT_LOGIN", Util.make(Entity.GENERIC, 0, 0, Type.NOT_LOGIN), "Not Login!");
    add("REQUIRED", Util.make(Entity.GENERIC, 0, 0, Type.REQUIRED), "Required!");
    add("UNKNOWN_ERROR", Util.make(Entity.UNKNOWN, 0, 0, Type.FAILURE), "Unknown Error!");
    add("USER_EXISTED", Util.make(Entity.USER, 0, 0, Type.EXISTED), "User Existed!");
    add("USER_NOT_FOUND", Util.make(Entity.USER, 0, 0, Type.EXISTED), "User Not Found!");
    add("USER_NOT_LOGIN", Util.make(Entity.USER, 0, 0, Type.NOT_LOGIN), "User Not Login!");
    add("USERNAME_EXISTED", Util.make(Entity.USER, Entity.NAME, 0, Type.EXISTED), "Username Existed!");
    add("DATABASE_ERROR", Util.make(Entity.DATABASE, 0, 0, Type.FAILURE), "Database Error!");
    add("PASSWORD_ERROR", Util.make(Entity.PASSWORD, 0, 0, Type.ERROR), "Password Error!");
    add("FILE_NOT_FOUND", Util.make(Entity.FILE, 0, 0, Type.NOT_FOUND), "File Not Found!");
    add("ADMIN_EXISTED", Util.make(Entity.ADMIN, 0, 0, Type.EXISTED), "Administrator Existed!");
    add("ADMIN_NOT_FOUND", Util.make(Entity.ADMIN, 0, 0, Type.EXISTED), "Administrator Not Found!");
    add("ADMIN_NOT_LOGIN", Util.make(Entity.GENERIC, 0, 0, Type.NOT_LOGIN), "Administrator Not Login!");
    add("MERCHANT_NOT_LOGIN", Util.make(Entity.MERCHANT, 0, 0, Type.NOT_LOGIN), "Merchant Not Login!");
    add("UPDATE_FAILED", Util.make(0, 0, Event.UPDATE, Type.FAILED), "Update Failed!");
    add("INPUT_INVALID", Util.make(Entity.INPUT, 0, 0, Type.FAILED), "Input Invalid!");
    add("NUMERIC_REQUIRED", Util.make(Entity.NUMERIC, 0, 0, Type.REQUIRED), "Numeric Required!");
    add("NAME_NOT_SPECIFIED", Util.make(Entity.NAME, 0, 0, Type.NOT_SPECIFIED), "Name Not Specified!");
    add("PASSWORD_NOT_SPECIFIED", Util.make(Entity.PASSWORD, 0, 0, Type.NOT_SPECIFIED), "Password Not Specified!");
    add("EMAIL_NOT_SPECIFIED", Util.make(Entity.EMAIL, 0, 0, Type.NOT_SPECIFIED), "Email Not Specified!");
    add("CATEGORY_NOT_FOUND", Util.make(Entity.CATEGORY, 0, 0, Type.NOT_FOUND), "Category Not Found!");
    add("EMAIL_EXISTED", Util.make(Entity.EMAIL, 0, 0, Type.EXISTED), "Email Existed!");
    add("PHONE_EXISTED", Util.make(Entity.PHONE, 0, 0, Type.EXISTED), "Phone Existed!");
    add("NETWORK_ERROR", Util.make(Entity.NETWORK, 0, 0, Type.ERROR), "Network Error Occurred!");
    return errors;
  }


}
