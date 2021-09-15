package com.desarrolloweb.spring.app.view.excel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.desarrolloweb.spring.app.entities.Cliente;
import com.desarrolloweb.spring.app.entities.Proveedor;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.GroupLayout.Alignment;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;


@Component("proveedores.xlsx")

public class ProveedorExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
try {
			response.setHeader("Content-Disposition", "attachment; filename=\"reporte_proveedores.xlsx\"");
			Sheet sheet = workbook.createSheet("proveedoreslista");
			response.setHeader("Content-Disposition", "attachment; filename=\"reporte_clientes.xlsx\"");
			Iterable<Proveedor> ite= (Iterable<Proveedor>) model.get("proveedoresPdf");;
			int acum=2;	
			CellStyle estilotit = workbook.createCellStyle();
			CellStyle estilo = workbook.createCellStyle();
			Font fuentetit = workbook.createFont();
			Font fuente = workbook.createFont();
            estilotit.setAlignment(HorizontalAlignment.CENTER);
			fuentetit.setColor(IndexedColors.BLACK.index);
			fuentetit.setFontName("Arial");
			estilotit.setFont(fuentetit);
			estilo.setFillForegroundColor(IndexedColors.BLUE.index);
			estilo.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			estilo.setAlignment(HorizontalAlignment.CENTER);
			fuente.setColor(IndexedColors.YELLOW.index);
			fuente.setFontName("Arial");
			estilo.setFont(fuente);
            Row row = sheet.createRow(0);
			Cell cell = row.createCell(0);
			cell.setCellValue("Listado");
			cell.setCellStyle(estilotit);
			row = sheet.createRow(1);
			cell = row.createCell(0);
			cell.setCellValue("id");
			cell.setCellStyle(estilo);
			cell = row.createCell(1);
			cell.setCellValue("nombre");
			cell.setCellStyle(estilo);
			cell = row.createCell(2);
			cell.setCellValue("e-mail");
			cell.setCellStyle(estilo);
			for(Proveedor proveedor: ite) {
			row = sheet.createRow(acum);
			cell = row.createCell(0);
				cell.setCellValue(proveedor.getId());
				cell.setCellStyle(estilo);
				cell = row.createCell(1);
				cell.setCellValue(proveedor.getNombre());
				cell.setCellStyle(estilo);
				cell = row.createCell(2);
				cell.setCellValue(proveedor.getEmail());
				cell.setCellStyle(estilo);
				acum++;
			}
			sheet.autoSizeColumn(1);
			sheet.autoSizeColumn(2);
			sheet.autoSizeColumn(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
