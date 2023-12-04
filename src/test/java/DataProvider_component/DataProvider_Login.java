package DataProvider_component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelRW;



public class DataProvider_Login {   
	
	@DataProvider(name="dp_DialPad")
	public static Iterator<Object[]> Invalid_login() throws IOException
	{
		 return common_logic("TestCases","High");		
	}	

	public static  Iterator<Object[]> common_logic(String sheetName,String sname ) throws IOException
	{
		String userDirectoryPath = System.getProperty("user.dir");	
		String projectPath = userDirectoryPath.replaceAll("\\\\","$0$0");
		System.out.println(projectPath);
		//ExcelRW c1= new ExcelRW("C:\\Users\\Dell\\eclipse-workspace\\360T_Project\\testData.xlsx");
		ExcelRW c1= new ExcelRW(projectPath+"\\testData.xlsx");
		
		
		int row_count = c1.getRow(sheetName);
		int col_count = c1.getCol(sheetName);
		
		List<Object[]> arr_list = new ArrayList<Object[]>();
		
		for(int i=1; i <=row_count ; i++)
		{
			String execute_flag = c1.readCell(sheetName, i, 3);
			if(execute_flag.equalsIgnoreCase("Y"))
			{
			Map<String, String> dmap=	new HashMap<String, String>();
			Object[] x= new Object[1];
			
					for(int j=0; j< col_count ; j++)
					{
						String key = c1.readCell(sheetName, 0, j);
						String value = c1.readCell(sheetName, i, j);
						 dmap.put(key, value);
						 x[0]=dmap;
					}	
					arr_list.add(x);
			}//if condition end			
		}//end for loop
	return	arr_list.iterator();	
		
	}

}
