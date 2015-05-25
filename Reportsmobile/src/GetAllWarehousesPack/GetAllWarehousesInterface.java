package GetAllWarehousesPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllWarehousesInterface {
	
	@GET("/GetAllWarehouses")
	void getAllWarehouses(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllWarehouses> callback);

}
