package Framework.ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		dataDriven d = new dataDriven();
		ArrayList data = d.getData("Purchase");
		
	System.out.println(data.get(1));
	System.out.println(data.get(1));
	System.out.println(data.get(2));
	System.out.println(data.get(3));
		

	}

}
