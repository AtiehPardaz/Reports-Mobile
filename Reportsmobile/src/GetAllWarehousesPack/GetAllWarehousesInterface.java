package GetAllWarehousesPack;

import retrofit.http.GET;
import retrofit.http.Query;
import GetAllSellersPack.GetAllSeller;

public interface GetAllWarehousesInterface {
	
	@GET("/GetAllWarehouses")
	public GetAllWarehouses getAllWarehouses(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);

}
