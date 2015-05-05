package GetAllPersonsPack;

import java.util.HashMap;
import java.util.Map;

public class GetAllPerson {

private String Id;
private String PersonCode;
private String Title;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The Id
*/
public String getId() {
return Id;
}

/**
* 
* @param Id
* The Id
*/
public void setId(String Id) {
this.Id = Id;
}

/**
* 
* @return
* The PersonCode
*/
public String getPersonCode() {
return PersonCode;
}

/**
* 
* @param PersonCode
* The PersonCode
*/
public void setPersonCode(String PersonCode) {
this.PersonCode = PersonCode;
}

/**
* 
* @return
* The Title
*/
public String getTitle() {
return Title;
}

/**
* 
* @param Title
* The Title
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