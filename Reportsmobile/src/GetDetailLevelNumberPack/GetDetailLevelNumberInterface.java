package GetDetailLevelNumberPack;

import retrofit.http.GET;
import retrofit.http.Query;
import GetAllWarehousesPack.GetAllWarehouses;

public interface GetDetailLevelNumberInterface {

	@GET("/GetDetailLevelNumber")
	public GetDetailLevelNumber getDetailLevelNumber(
			@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);

}
