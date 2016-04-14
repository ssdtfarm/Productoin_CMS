package com.sinosoft.report.f1report;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class ChangeCode {
  public void ChangeCode(){

  }
  public static String ChgCode(String cType,String cValue) {
    switch (Integer.parseInt(cValue)){
      case 1:
          return "100";
      case 2:
          return "200";
      case 3:
          return "300";
      default:
          return "400";
    }
  }
}
