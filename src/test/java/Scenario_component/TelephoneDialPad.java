package Scenario_component;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Generic_Component.Base_class;


public class TelephoneDialPad  extends Base_class{	
	
  	@Test(dataProvider ="dp_DialPad" ,dataProviderClass = DataProvider_component.DataProvider_Login.class,groups = {"smoke"})
	public void Test_phonedial(Map<String,String> map) throws IOException
	{
  		
  		String Dial_Number = map.get("Dial_Number");  	
  		Reporter. log("Combination of chars for number - " + Dial_Number +  " - " );
		LinkedList<String> Letters= retrieveCombinations(Dial_Number);
		for(String str : Letters)
		{
			Reporter. log(str + ",");
			
		}			
	}

  	
	
}
