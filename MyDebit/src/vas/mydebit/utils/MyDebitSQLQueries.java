

package vas.mydebit.utils;

import vas.mydebit.coreconstants.MyDebitCoreConstant;

/**
 * @author ayushman
 * Date 27/feb/2014
 * In this file all the SQL queries will be written.Try to avoid writing hardcoded sql Syntax
 * all the sql syntax should be fetched from MyDebitCommonSQLSyntaxConstans.java
 */
public class MyDebitSQLQueries {
	
	public static final String DATABASE_CREATE = "create table " + MyDebitCoreConstant.TABLE_LOGIN_INFO
	+ "(" + MyDebitCoreConstant.USER_ID + " integer primary key autoincrement, "
	+ MyDebitCoreConstant.COLUMN_USER_NAME + " text not null,"+ MyDebitCoreConstant.COLUMN_USER_PASSWORD + " text not null,"+ MyDebitCoreConstant.COLUMN_USER_SECURITY_INDEX +
	" integer not null,"+ MyDebitCoreConstant.COLUMN_USER_SECURITY_ANSWER +" text not null );";


}
