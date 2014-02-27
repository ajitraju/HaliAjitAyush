

package vas.mydebit.views;
import vas.mydebit.dao.MyDebitOpertaions;
import vas.mydebit.daoimpl.MydebitOperationsImpl;
import vas.mydebit.models.MydebitLoginInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
/**
 * @author ayushman
 * Date 27/feb/2014
 * main login screen
 */
public class LoginActivity extends Activity implements OnClickListener{
	
	private MyDebitOpertaions mydebitOperations;
	private MydebitLoginInfo mydebitLoginInfo;
	private Boolean isAuthenticatedUser = false;
	private EditText etUserName;
	private EditText etPassword;
	private Button   btnLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initVariable();
		mydebitOperations = new MydebitOperationsImpl(this);
		btnLogin.setOnClickListener(this);
	} 
	
	@Override
	protected void onResume() {
		mydebitOperations.open();
		super.onResume();
	}
	@Override
	protected void onPause() {
		mydebitOperations.close();
		super.onPause();
	}

	//Handling on click events
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_login :
			mydebitOperations.open();
			isAuthenticatedUser=mydebitOperations.authenticateUser(etUserName.getText().toString(),etPassword.getText().toString());
			
			if(true == isAuthenticatedUser)
			{
				Toast.makeText(getApplicationContext(),"Is AuthenticateUser", 1).show();
			}
			else
			{
				Toast.makeText(getApplicationContext(),"Not a  AuthenticateUser", 1).show();	
			}
			
			break;

		    default:
			break;
		}
	}
		
	//instantiation of variable 
	 private void initVariable() {
		etUserName = (EditText) findViewById(R.id.et_loginusername);
		etPassword = (EditText) findViewById(R.id.et_loginpassword);
		btnLogin = (Button)findViewById(R.id.btn_login);
		
	}


}
