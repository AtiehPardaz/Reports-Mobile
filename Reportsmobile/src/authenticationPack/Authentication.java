package authenticationPack;

import java.util.HashMap;
import java.util.Map;

public class Authentication {

private authenticationPack.Result Result;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* 
* @return
* The Result
*/
public authenticationPack.Result getResult() {
return Result;
}

/**
* 
* @param Result
* The Result
*/
public void setResult(authenticationPack.Result Result) {
this.Result = Result;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}