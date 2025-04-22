package com.example.FitLife.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.FitLife.model.Pago;

@Repository
public class PagoRepository {

    List<Pago> listaPagos = new ArrayList<>();
    
    public Pago agregarPago(Pago pago) {
        listaPagos.add(pago);
        return pago;
    }

    public List<Pago> obtenerPagos() {
        return listaPagos;
    }

    public Pago buscarPorId(int idPago) {
        for (Pago pago : listaPagos) {
            if (pago.getPagoId() == idPago) {
                return pago;
            }
        }
        return null;
    }

    public Pago actualizarPagos(Pago pago) {
        int id = 0;
        int idPosicion = 0;
        for (int i = 0; i < listaPagos.size(); i++) {
            if (listaPagos.get(i).getPagoId() == pago.getPagoId()) {
                id = pago.getPagoId();
                idPosicion = i;
            }
        }
    
    Pago pago1 = new Pago();
    pago1.setPagoId(id);
    pago1.setUsuarioId(pago.getUsuarioId());
    pago1.setMonto(pago.getMonto());
    pago1.setFechaPago(pago.getFechaPago());
    pago1.setMetodoPago(pago.getMetodoPago());
    pago1.setDetalle(pago.getDetalle());
    pago1.setMembresiaId(pago.getMembresiaId());

    listaPagos.set(idPosicion, pago1);
    return pago1;
    }

    public void eliminarPago(int id) {
        // alternative 1
        Pago pago = buscarPorId(id);
        if (pago != null) {
            listaPagos.remove(pago);
        }

        // alternative 2
        int idPosicion = 0;
        for (int i = 0; i < listaPagos.size(); i++) {
            if (listaPagos.get(i).getPagoId() == id) {
                idPosicion = i;
                break;
            }
        }
        if (idPosicion > 0) {
            listaPagos.remove(idPosicion);
        }

        // alternative 3
        listaPagos.removeIf(x -> x.getPagoId() == id);
    }

>>>>>>> 018ed10f239ffb9c108c233a558ede1d8b6285a2
}
