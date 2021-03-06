package authenticationPack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

	private List<Domain> Domains = new ArrayList<Domain>();
	private authenticationPack.Status Status;
	private String Token;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The Domains
	 */
	public List<Domain> getDomains() {
		return Domains;
	}

	/**
	 * 
	 * @param Domains
	 *            The Domains
	 */
	public void setDomains(List<Domain> Domains) {
		this.Domains = Domains;
	}

	/**
	 * 
	 * @return The Status
	 */
	public authenticationPack.Status getStatus() {
		return Status;
	}

	/**
	 * 
	 * @param Status
	 *            The Status
	 */
	public void setStatus(authenticationPack.Status Status) {
		this.Status = Status;
	}

	/**
	 * 
	 * @return The Token
	 */
	public String getToken() {
		return Token;
	}

	/**
	 * 
	 * @param Token
	 *            The Token
	 */
	public void setToken(String Token) {
		this.Token = Token;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}