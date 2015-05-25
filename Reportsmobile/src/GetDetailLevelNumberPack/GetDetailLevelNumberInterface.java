package GetDetailLevelNumberPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetDetailLevelNumberInterface {

	@GET("/GetDetailLevelNumber")
	void getDetailLevelNumber(
			@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetDetailLevelNumber> callback);

}
