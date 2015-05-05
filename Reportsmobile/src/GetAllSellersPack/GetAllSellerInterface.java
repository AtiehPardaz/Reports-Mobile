package GetAllSellersPack;

import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllSellerInterface {

	@GET("/GetAllSellers")
	public GetAllSeller getAllSellers(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);

}
