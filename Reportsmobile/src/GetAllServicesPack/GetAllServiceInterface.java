package GetAllServicesPack;

import retrofit.http.GET;
import retrofit.http.Query;
import GetAllSellersPack.GetAllSeller;

public interface GetAllServiceInterface {
	
	@GET("/GetAllServices")
	public GetAllService getAllService(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);

}
