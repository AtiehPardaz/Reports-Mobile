package GetAllProductPack;

import java.util.HashMap;
import java.util.Map;

public class GetAllProduct {

	private String Code;
	private String Id;
	private String Title;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The Code
	 */
	public String getCode() {
		return Code;
	}

	/**
	 * 
	 * @param Code
	 *            The Code
	 */
	public void setCode(String Code) {
		this.Code = Code;
	}

	/**
	 * 
	 * @return The Id
	 */
	public String getId() {
		return Id;
	}

	/**
	 * 
	 * @param Id
	 *            The Id
	 */
	public void setId(String Id) {
		this.Id = Id;
	}

	/**
	 * 
	 * @return The Title
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * 
	 * @param Title
	 *            The Title
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}