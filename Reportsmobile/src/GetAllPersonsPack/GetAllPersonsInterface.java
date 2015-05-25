package GetAllPersonsPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllPersonsInterface {

	@GET("/GetAllPersons")
	void getAllPersons(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllPerson> callback);
}
