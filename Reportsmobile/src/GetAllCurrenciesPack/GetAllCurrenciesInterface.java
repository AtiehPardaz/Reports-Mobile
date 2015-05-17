package GetAllCurrenciesPack;

import retrofit.http.GET;
import retrofit.http.Query;
 

public interface GetAllCurrenciesInterface {
	@GET("/GetAllCurrencies")
	public GetAllCurrencies getAllCurrencies(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);
}
