package GetAllProjectsPack;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;
 
public interface GetAllProjectsInterface {
	@GET("/GetAllProjects")
	void getAllProjects(@Query("domainId") String domainID,
			@Query("finantialYeasrId") String finantialYeasrId,
			@Query("token") String token, Callback<GetAllProjects> callback);
}
