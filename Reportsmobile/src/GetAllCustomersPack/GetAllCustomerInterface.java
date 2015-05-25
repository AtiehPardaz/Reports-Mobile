package GetAllCustomersPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllCustomerInterface {
	
	@GET("/GetAllCustomers")
	void getAllCustomer(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllCustomer> callback);

}
