

package vas.mydebit.daoimpl;
import vas.mydebit.coreconstants.MyDebitCoreConstant;
import vas.mydebit.dao.MyDebitOpertaions;
import vas.mydebit.models.MydebitLoginInfo;
import vas.mydebit.utils.MyDebitDatabaseWrapper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * @author ayushman
 * Here the implementation for all database operations will be placed
 */
public class MydebitOperationsImpl implements MyDebitOpertaions {

	// Database fields
	private MyDebitDatabaseWrapper dbHelper;
	private String[] USERINFO_TABLE_COLUMNS = { MyDebitCoreConstant.USER_ID, MyDebitCoreConstant.COLUMN_USER_NAME,
			MyDebitCoreConstant.COLUMN_USER_PASSWORD,MyDebitCoreConstant.COLUMN_USER_SECURITY_INDEX,MyDebitCoreConstant.COLUMN_USER_SECURITY_ANSWER};
	private SQLiteDatabase database;
	public MydebitOperationsImpl(Context context) {
		dbHelper = new MyDebitDatabaseWrapper(context);
	}
	
	@Override
	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	@Override
	public void close() {
		dbHelper.close();
	}
	
	@Override
	public  void addUserInfo(MydebitLoginInfo mydebitLoginInfo) {
    ContentValues values = new ContentValues();
	values.put(MyDebitCoreConstant.COLUMN_USER_NAME,mydebitLoginInfo.getUserName());
	values.put(MyDebitCoreConstant.COLUMN_USER_PASSWORD,mydebitLoginInfo.getPassword());
	values.put(MyDebitCoreConstant.COLUMN_USER_SECURITY_INDEX,mydebitLoginInfo.getSecurityIndex());
	values.put(MyDebitCoreConstant.COLUMN_USER_SECURITY_ANSWER,mydebitLoginInfo.getSecurityAnswer());
    
	
	long uId = database.insert(MyDebitCoreConstant.TABLE_LOGIN_INFO, null, values);
    Log.d("My Debit Database created Successfully","testDbCreation");
	// now that the student is created return it ...
	Cursor cursor = database.query(MyDebitCoreConstant.TABLE_LOGIN_INFO,USERINFO_TABLE_COLUMNS, MyDebitCoreConstant.USER_ID+ " = "+ uId, null, null, null, null);
    cursor.moveToFirst();
    //MydebitLoginInfo loginInfo = parseUser(cursor);
	cursor.close();
	
	}

    
	
	//This method is to return the stored user info to Cursor
    private MydebitLoginInfo parseUser(Cursor cursor) {
		MydebitLoginInfo mydebitLoginInfo = new MydebitLoginInfo();
		mydebitLoginInfo.setUserId((cursor.getInt(0)));
		mydebitLoginInfo.setUserName(cursor.getString(1));
		mydebitLoginInfo.setPassword(cursor.getString(2));
		mydebitLoginInfo.setSecurityIndex(cursor.getInt(3));
		mydebitLoginInfo.setSecurityAnswer(cursor.getString(4));
		return mydebitLoginInfo;
	}

	@Override
	public boolean authenticateUser(String userName, String password) {
		Cursor mCursor = database.rawQuery("SELECT * FROM " + MyDebitCoreConstant.TABLE_LOGIN_INFO + " WHERE username=? AND password=?", new String[]{userName,password});
		if (mCursor != null) {
		if(mCursor.getCount() > 0)
		{
		return true;
		}
		}
		return false;
		
	}

}