package GetAllServicesPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllServiceInterface {
	
	@GET("/GetAllServices")
	void getAllService(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllService> callback);

}
