package DID;

public class Read_Write_ExcelFile_Test {

	public static void main(String[] args) {
		// Reading Excel file
		Xls_Reader xsl = new Xls_Reader("C:\\Next day porting\\PranavTestFile.xlsx");
		
		System.out.println(xsl.getCellData("Data1", "Name", 3));
		System.out.println(xsl.getCellData("Data1", 1, 3));
		
		String validEmail = xsl.getCellData("Data1", "UserName", 2);
		System.out.println(validEmail);
		
		System.out.println(xsl.getRowCount("Data1"));
		System.out.println(xsl.getColumnCount("Data1"));
		
		xsl.setCellData("Data1", "Name", 15, "Pranav");
	}

}
