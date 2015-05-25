package GetAllMarketersPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllMarketersInterface {

	@GET("/GetAllMarketers")
	void getAllMarketers(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllMarketers> callback);
}
