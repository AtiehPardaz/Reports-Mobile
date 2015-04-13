package authenticationPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface AuthenticationInterface {

		@GET("/AuthenticateUser")
		public  void authenticate(@Query("userName") String userName , @Query("password") String password , Callback<Authentication> authInfo);
		
	}
