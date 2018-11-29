package gov.prefect.stock.export;

import javax.servlet.http.HttpServletResponse;

public interface FileExporter {
	
	boolean export(HttpServletResponse Response, String fileName, String encoding);
		boolean importDataFormExcel();

}
