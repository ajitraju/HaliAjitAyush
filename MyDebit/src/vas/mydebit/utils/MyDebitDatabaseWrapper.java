package vas.mydebit.utils;

import vas.mydebit.coreconstants.MyDebitCoreConstant;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDebitDatabaseWrapper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "MyDebitStore.db";
	private static final int DATABASE_VERSION = 1;


	public MyDebitDatabaseWrapper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(MyDebitSQLQueries.DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + MyDebitCoreConstant.TABLE_LOGIN_INFO);
		onCreate(db);
	}

}