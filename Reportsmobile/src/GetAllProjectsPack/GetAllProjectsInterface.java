package GetAllProjectsPack;

import retrofit.http.GET;
import retrofit.http.Query;
 
public interface GetAllProjectsInterface {
	@GET("/GetAllProjects")
	public GetAllProjects getAllProjects(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token);
}
