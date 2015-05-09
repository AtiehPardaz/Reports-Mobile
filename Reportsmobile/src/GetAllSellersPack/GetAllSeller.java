package GetAllSellersPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class GetAllSeller {

	private List<GetAllSellersPack.Result> Result = new ArrayList<GetAllSellersPack.Result>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The Result
	 */
	public List<GetAllSellersPack.Result> getResult() {
		return Result;
	}

	/**
	 * 
	 * @param Result
	 *            The Result
	 */
	public void setResult(List<GetAllSellersPack.Result> Result) {
		this.Result = Result;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}