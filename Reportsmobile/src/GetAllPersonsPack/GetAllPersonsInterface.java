package GetAllPersonsPack;

import retrofit.http.GET;
import retrofit.http.Query;

public interface GetAllPersonsInterface {

	
	
	@GET("/GetAllPersons")
	public GetAllPerson getAllPersons(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);
}
