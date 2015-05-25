package GetAllCostCentersPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query; 

public interface GetAllCostCentersInterface {

	@GET("/GetAllCostCenters")
	void getAllCostCenters(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllCostCenters> callback);
}
