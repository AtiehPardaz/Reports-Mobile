package GetAllCurrenciesPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query; 

public interface GetAllCurrenciesInterface {
	@GET("/GetAllCurrencies")
	void getAllCurrencies(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllCurrencies> callback);
}
