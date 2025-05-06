package com.example.report_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.report_service.model.Reporte;
import com.example.report_service.repository.ReporteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReporteService {

    @Autowired
    private final ReporteRepository reporteRepository;

    public List<Reporte> get() {
        return reporteRepository.findAll();
    }

    public Reporte save(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte update(int idReporte,Reporte reporte) {
        Optional<Reporte> reporte1 = reporteRepository.findById(idReporte);
        if (!reporte1.isPresent()) {
            return null;
        }
        Reporte newReporte = new Reporte();
        newReporte.setId(reporte1.get().getId());
        newReporte.setTitulo(reporte.getTitulo());
        newReporte.setDescripcion(reporte.getDescripcion());
        newReporte.setFechaReporte(reporte.getFechaReporte()); 
        return reporteRepository.save(newReporte);
    }

    public String delete(int idReporte) {
        Optional<Reporte> reporte = reporteRepository.findById(idReporte);
        if (reporte.isEmpty()) {
            return "No existe reporte N°" + idReporte;
        }
        reporteRepository.deleteById(idReporte);
        return "Reporte " + idReporte + " eliminado";
    }


}
