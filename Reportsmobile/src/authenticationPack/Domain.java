package authenticationPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Domain {

	private List<FinancialYear> FinancialYears = new ArrayList<FinancialYear>();
	private String Id;
	private List<Permission> Permissions = new ArrayList<Permission>();
	private String Title;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The FinancialYears
	 */
	public List<FinancialYear> getFinancialYears() {
		return FinancialYears;
	}

	/**
	 * 
	 * @param FinancialYears
	 *            The FinancialYears
	 */
	public void setFinancialYears(List<FinancialYear> FinancialYears) {
		this.FinancialYears = FinancialYears;
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
	 * @return The Permissions
	 */
	public List<Permission> getPermissions() {
		return Permissions;
	}

	/**
	 * 
	 * @param Permissions
	 *            The Permissions
	 */
	public void setPermissions(List<Permission> Permissions) {
		this.Permissions = Permissions;
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