package GetAllSellersPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllSellerInterface {

	@GET("/GetAllSellers")
	void getAllSellers(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllSeller> callback);

}
