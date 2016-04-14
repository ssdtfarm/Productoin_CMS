package com.sinosoft.utility;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.Map;

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
public class CachedSQL extends ExeSQL
{
  protected static Map cache = new Hashtable();


  public CachedSQL(Connection tConnection)
  {
    super(tConnection);
  }

  public CachedSQL()
  {
    super();
  }



  public SSRS execSQL(String sql)
  {
    SSRS ssrs = (SSRS) cache.get(sql);
    if (ssrs == null) {
      ssrs = super.execSQL(sql);
      cache.put(sql, ssrs);
    }
    else {
//      debug("got cache");
    }

    return ssrs;
  }

  public String getOneValue(String sql)
  {
    return execSQL(sql).GetText(1,1);
  }



  public static void clearCache()
  {
    cache.clear();
  }

//  public static void main(String[] args)
//  {
//    CachedSQL cachedsql = new CachedSQL();
//  }
}
