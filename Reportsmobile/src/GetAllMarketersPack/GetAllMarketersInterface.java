package GetAllMarketersPack;

import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllMarketersInterface {

	@GET("/GetAllMarketers")
	public GetAllMarketers getAllMarketers(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);
}
