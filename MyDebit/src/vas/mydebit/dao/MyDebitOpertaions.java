/**
 * @author ayushman
 * Date 27/Feb/2014
 * In this interface all the common method calls for any database related operations will be stored
 */
package vas.mydebit.dao;

import vas.mydebit.models.MydebitLoginInfo;

public interface MyDebitOpertaions {
	
	//To open the Database
	public void open();
	//To close the Database
	public void close();
	//Here user is added to database
	public  void addUserInfo(MydebitLoginInfo mydebitLoginInfo);
	public boolean authenticateUser(String userName,String password);

}
