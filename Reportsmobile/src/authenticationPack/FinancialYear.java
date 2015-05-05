package authenticationPack;

import java.util.HashMap;
import java.util.Map;

public class FinancialYear {

private String EndDate;
private String Id;
private String StartDate;
private String Title;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The EndDate
*/
public String getEndDate() {
return EndDate;
}

/**
* 
* @param EndDate
* The EndDate
*/
public void setEndDate(String EndDate) {
this.EndDate = EndDate;
}

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
* The StartDate
*/
public String getStartDate() {
return StartDate;
}

/**
* 
* @param StartDate
* The StartDate
*/
public void setStartDate(String StartDate) {
this.StartDate = StartDate;
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