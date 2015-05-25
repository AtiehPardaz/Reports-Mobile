package GetAllProductPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllProductInterface {
	
	@GET("/GetAllProducts")
	void getAllProduct(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllProduct> callback);

}
