package GetAllCostCentersPack;

import retrofit.http.GET;
import retrofit.http.Query;
 

public interface GetAllCostCentersInterface {

	@GET("/GetAllCostCenters")
	public GetAllCostCenters getAllCostCenters(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);

}
