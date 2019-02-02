package data;
import utilities.Xls_Reader;

public class Data {
	// Login 
	Xls_Reader xsl = new Xls_Reader("C:\\testing\\LoginTest.xlsx");
	public String validEmail = xsl.getCellData("Data1", 1, 2);
	public String wrongPassword = xsl.getCellData("Data1", 2, 2);
	public String expectedErr = xsl.getCellData("Data1", 4, 2);
	
	public String invalidEmail = xsl.getCellData("Data1", 1, 3);
	public String invalidEmailErr = xsl.getCellData("Data1", 3, 3);
}
