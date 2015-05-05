package GetAllProductPack;

import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllProductInterface {
	
	@GET("/GetAllProducts")
	public GetAllProduct getAllProduct(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);

}
