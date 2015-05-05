package authenticationPack;

import java.util.HashMap;
import java.util.Map;

public class Permission {

private int Key;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The Key
*/
public int getKey() {
return Key;
}

/**
* 
* @param Key
* The Key
*/
public void setKey(int Key) {
this.Key = Key;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}