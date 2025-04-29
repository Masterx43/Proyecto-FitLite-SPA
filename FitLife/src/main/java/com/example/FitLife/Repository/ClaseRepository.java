package com.example.FitLife.Repository; 
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.FitLife.model.Clase;


@Repository
public class ClaseRepository {
    private List<Clase> ListaClase = new ArrayList<>();

    public List<Clase> obtenerClase( ){
        return ListaClase;
    }

    
    public Clase BuscarClasePorId(int idClase){
        for(Clase clase:ListaClase){
            if(clase.getIdClase() == idClase){
                return clase;
            }
        }
        return null;

    }

    public Clase AgregarClase(Clase clase){
        ListaClase.add(clase);
        return clase;
    }
    
    public Clase ActualizarClase(Clase clase){
        int idClase = 0;
        int IdPosicionClase = 0;

        for (int i = 0; i < ListaClase.size(); i++){
            if(ListaClase.get(i).getIdClase() == clase.getIdClase()){
                idClase = clase.getIdClase();
                IdPosicionClase = i;

            }

        }
        
        Clase Clase1 = new Clase();
        Clase1.setIdClase(idClase);
        Clase1.setNombre(Clase1.getNombre());
        Clase1.setDescripcion(Clase1.getDescripcion());
        Clase1.setCapacidadMaxima(Clase1.getCapacidadMaxima());
        Clase1.setUbicacion(Clase1.getUbicacion());
        Clase1.setFechaHora(Clase1.getFechaHora());
        Clase1.setEntrenadorId(Clase1.getEntrenadorId());
        
        ListaClase.set(IdPosicionClase, Clase1);
        return Clase1;
    }

    public void EliminarClase(int idClase){
        Clase clase = BuscarClasePorId(idClase);
        if(clase != null){
            ListaClase.remove(clase);
        }
    }
}
