package GetDetailLevelNumberPack;

import java.util.HashMap;
import java.util.Map;

public class Result {

private String Level;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The Level
*/
public String getLevel() {
return Level;
}

/**
* 
* @param Level
* The Level
*/
public void setLevel(String Level) {
this.Level = Level;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}