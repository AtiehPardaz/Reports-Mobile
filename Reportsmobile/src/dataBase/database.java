package dataBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database extends SQLiteOpenHelper {

	public final String path = "data/data/com.Atieh.reportsmobile/databases/";
	public final String Name = "db";
	public static SQLiteDatabase mydb;
	private final Context mycontext;

	public database(Context context) {
		super(context, "db", null, 1);
		mycontext = context;

	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public void database() {

		boolean checkdb = checkdb();

		if (checkdb) {

		} else {

			this.getReadableDatabase();

			try {
				copydatabase();
			} catch (IOException e) {

			}
		}
	}

	public void open() {

		mydb = SQLiteDatabase.openDatabase(path + Name, null,
				SQLiteDatabase.OPEN_READWRITE);

	}

	public void close() {
		mydb.close();
	}

	public boolean checkdb() {

		SQLiteDatabase db = null;
		try {
			db = SQLiteDatabase.openDatabase(path + Name, null,
					SQLiteDatabase.OPEN_READONLY);
		}

		catch (SQLException e) {

		}
		return db != null ? true : false;

	}

	public void copydatabase() throws IOException {
		OutputStream myOutput = new FileOutputStream(path + Name);
		byte[] buffer = new byte[1024];
		int length;

		InputStream myInput = mycontext.getAssets().open("db");
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		myInput.close();
		myOutput.flush();
		myOutput.close();
	}
	
	public Cursor GetCustomers (){


		Cursor cu= mydb.rawQuery("select * from testtable ORDER BY  title", null); 
		return cu ;

	}
	public Cursor Getbazar (){


		Cursor cu= mydb.rawQuery("select * from testlongtable ORDER BY  title", null); 
		return cu ;

	}

}
