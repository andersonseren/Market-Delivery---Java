package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/pdf/usuario")
    public ResponseEntity<byte[]> generarPdfUsuario() throws Exception {

        // Aquí puedes usar datos reales del usuario
        String html = """
            <html>
                <body>
                    <h1>Reporte de Usuario</h1>
                    <p>Este es un PDF generado desde HTML con Flying Saucer.</p>
                </body>
            </html>
        """;

        byte[] pdfBytes = pdfService.generarPdfDesdeHtml(html);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=reporte_usuario.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}
