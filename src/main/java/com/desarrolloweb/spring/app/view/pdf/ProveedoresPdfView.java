package com.desarrolloweb.spring.app.view.pdf;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.desarrolloweb.spring.app.entities.Proveedor;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import com.desarrolloweb.spring.app.entities.Proveedor;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
//import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
//import antlr.collections.List;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Component("proveedores.pdf")
public class ProveedoresPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		Iterable<Proveedor> ite= (Iterable<Proveedor>) model.get("proveedoresPdf");
		PdfPTable t = new PdfPTable(1);
		PdfPCell estilo = new PdfPCell();
		Font fuente = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fuente.setColor(Color.WHITE);
		fuente.setSize(14);
		estilo.setBorderColor(Color.BLUE);
		estilo.setBackgroundColor(Color.GRAY);
		estilo.setBorderWidth(1);
		estilo.setPhrase(new Phrase("Lista proveedores",fuente));
		t.setSpacingAfter(20);
		t.addCell(estilo);	
		for(Proveedor proveedor:ite) {
			estilo.setPhrase(new Phrase(proveedor.getId() + " - " + proveedor.getNombre() + " - " + proveedor.getEmail() + "  ",fuente));	
			t.addCell(estilo);
		}
		document.add(t);

			}

}

