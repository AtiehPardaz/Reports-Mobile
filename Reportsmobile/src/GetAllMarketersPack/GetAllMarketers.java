package GetAllMarketersPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetAllMarketers {

	private List<GetAllMarketersPack.Result> Result = new ArrayList<GetAllMarketersPack.Result>();
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The Result
	 */
	public List<GetAllMarketersPack.Result> getResult() {
		return Result;
	}

	/**
	 * 
	 * @param Result
	 *            The Result
	 */
	public void setResult(List<GetAllMarketersPack.Result> Result) {
		this.Result = Result;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}