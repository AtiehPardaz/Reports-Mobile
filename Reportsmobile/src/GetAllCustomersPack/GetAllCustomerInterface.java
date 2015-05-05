package GetAllCustomersPack;

import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllCustomerInterface {
	
	@GET("/GetAllCustomers")
	public GetAllCustomer getAllCustomer(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);

}
