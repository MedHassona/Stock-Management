package gov.prefect.stock.export;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import gov.prefect.stock.entites.Article;
import gov.prefect.stock.services.IArticleService;
import gov.prefect.stock.utils.ApplicationConstants;
import jxl.CellView;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.write.Label;
import jxl.write.WritableCellFeatures;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

@Component("articleExporter")
public class ArticleExporter implements FileExporter {

	private static final String FILE_NAME = "list des articles";

	@Autowired
	private IArticleService articleService;
	
	@Override
	public boolean export(HttpServletResponse response, String fileName, String encoding) {
		if(StringUtils.isEmpty(fileName)) {
			fileName = FILE_NAME;
		}
		
		if(StringUtils.isEmpty(encoding)) {
			encoding = ApplicationConstants.DEFAULT_ENCODING;
		}
		
		response.setContentType(ApplicationConstants.EXCEL_CONTENT_TYPE);
		response.setHeader(ApplicationConstants.CONTENT_DISPOSITION, "attachment; filename=" + fileName +".xls");
		WorkbookSettings workbookSettings = new WorkbookSettings();
		workbookSettings.setEncoding(encoding);
		try {;
			
			WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream(), workbookSettings);
			WritableSheet sheet = workbook.createSheet(fileName, 0);
			/**
			 * Sheet Header
			 */
			Label labelId = new Label(0,0, ApplicationConstants.ID_ARTICLE);
			labelId.setCellFeatures(new WritableCellFeatures());
			labelId.getCellFeatures().setComment("");
			sheet.addCell(labelId);
			
			Label labelNom = new Label(1,0, ApplicationConstants.NOM_ARTICLE);
			labelNom.setCellFeatures(new WritableCellFeatures());
			labelNom.getCellFeatures().setComment("");
			sheet.addCell(labelNom);
			
			Label labelCategorie = new Label(2,0, ApplicationConstants.CATEGORIE_ARTICLE);
			labelCategorie.setCellFeatures(new WritableCellFeatures());
			labelCategorie.getCellFeatures().setComment("");
			sheet.addCell(labelCategorie);
			
			Label labelStock = new Label(3,0, ApplicationConstants.STOCK_ARTICLE);
			labelStock.setCellFeatures(new WritableCellFeatures());
			labelStock.getCellFeatures().setComment("");
			sheet.addCell(labelStock);
			
			Label labelDiscription = new Label(4,0, ApplicationConstants.DISCRIPTION_ARTICLE);
			labelDiscription.setCellFeatures(new WritableCellFeatures());
			labelDiscription.getCellFeatures().setComment("");
			sheet.addCell(labelDiscription);
			
			int correntRow = 1;
			
			List<Article> articles = articleService.selectAll();
			if(articles != null && !articles.isEmpty()) {
				/**
				 * Ecriture sur la feauille "sheet"
				 */
				
				for (Article article : articles) {
					
					sheet.addCell(new Label(0, correntRow, ""+article.getIdArticle()));
					sheet.addCell(new Label(1, correntRow, article.getNomArticle()));
					sheet.addCell(new Label(2, correntRow, article.getCategorie().getNomCategory()));
					sheet.addCell(new Label(3, correntRow, ""+article.getQteStock()));
					sheet.addCell(new Label(4, correntRow, article.getDescription()));
					correntRow++;
				}
				
				CellView cellView = new CellView();
				cellView.setAutosize(true);
				//cellView.setSize(500);
				sheet.setColumnView(0, cellView);
				sheet.setColumnView(1, cellView);
				sheet.setColumnView(2, cellView);
				sheet.setColumnView(3, cellView);
				sheet.setColumnView(4, cellView);
				
				/**
				 * Ecrir sur Excel Feuille "sheet"
				 */
				
				workbook.write();
				
				/**
				 * Fermiture de workbook
				 */
				
				workbook.close();
				
				response.getOutputStream().flush();
				response.getOutputStream().close();
				
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean importDataFormExcel() {
		// TODO Auto-generated method stub
		return false;
	}

}
