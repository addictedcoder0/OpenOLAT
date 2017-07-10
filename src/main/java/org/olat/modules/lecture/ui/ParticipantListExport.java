package org.olat.modules.lecture.ui;

import org.olat.core.gui.components.form.flexible.impl.elements.table.FlexiColumnModel;
import org.olat.core.gui.components.form.flexible.impl.elements.table.FlexiTableComponent;
import org.olat.core.gui.components.form.flexible.impl.elements.table.FlexiTableDataModel;
import org.olat.core.gui.components.form.flexible.impl.elements.table.XlsFlexiTableExporter;
import org.olat.core.gui.translator.Translator;
import org.olat.core.logging.OLog;
import org.olat.core.logging.Tracing;
import org.olat.core.util.openxml.OpenXMLWorkbook;
import org.olat.core.util.openxml.OpenXMLWorksheet.Row;
import org.olat.modules.lecture.ui.ParticipantListDataModel.ParticipantsCols;

/**
 * 
 * 
 * Initial date: 10 juil. 2017<br>
 * @author srosse, stephane.rosse@frentix.com, http://www.frentix.com
 *
 */
public class ParticipantListExport extends XlsFlexiTableExporter {
	
	private static final OLog log = Tracing.createLoggerFor(ParticipantListExport.class);

	@Override
	protected void createCell(FlexiTableComponent ftC, FlexiColumnModel cd, Row dataRow, int row, int col,
			Translator translator, OpenXMLWorkbook workbook) {
		try {
			int colIndex = cd.getColumnIndex();
			if(colIndex < ParticipantListRepositoryController.USER_PROPS_OFFSET) {
				switch(ParticipantsCols.values()[colIndex]) {
					case rate:
						FlexiTableDataModel<?> dataModel = ftC.getFlexiTableElement().getTableDataModel();
						Object rate = dataModel.getValueAt(row, colIndex);
						if(rate instanceof Number) {
							dataRow.addCell(col, (Number)rate, workbook.getStyles().getPercentStyle());
						}
						break;
					default:
						super.createCell(ftC, cd, dataRow, row, col, translator, workbook);
						break;
				}
			} else {
				super.createCell(ftC, cd, dataRow, row, col, translator, workbook);
			}
		} catch (Exception e) {
			log.error("", e);
		}
	}
}
