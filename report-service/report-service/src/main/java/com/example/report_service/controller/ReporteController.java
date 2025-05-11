package com.example.report_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.report_service.model.Reporte;
import com.example.report_service.service.ReporteService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api-v1/reporte")
@
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Reporte>> getReportes() {
        return ResponseEntity.ok(reporteService.get());
    }

    @PostMapping("/crear")
    public ResponseEntity<Reporte> saveReporte(@RequestBody Reporte reporte) {
         ResponseEntity.status(HttpStatus.CREATED).body(reporte);
    }

    @PutMapping("/buscar/{id}")
    public ResponseEntity<Reporte> getReporte(@PathVariable int id, @RequestBody Reporte reporte) {
        return ResponseEntity.ok(reporteService.update(id, reporte));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteReporte(@PathVariable int id) {
        reporteService.delete(id);
    }
    
    
}
