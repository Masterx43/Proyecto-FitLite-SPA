package com.example.FitLife.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.FitLife.model.Usuario;

@Repository
public class UsuarioRepository {
    private List<Usuario> ListaUsuario = new ArrayList<>();

    public List<Usuario> obtenerUsuarios( ){
        return ListaUsuario;
    }

    
    public Usuario BuscarUsuarioPorId(int Usuarioid){
        for(Usuario usuario:ListaUsuario){
            if(usuario.getUsuarioId() == Usuarioid){
                return usuario;
            }
        }
        return null;

    }

    public Usuario AgregarUsuario(Usuario user){
        ListaUsuario.add(user);
        return user;
    }
    
    public Usuario ActualizarUsuario(Usuario user){
        for (int i = 0; i < ListaUsuario.size(); i++){
            if(ListaUsuario.get(i).getUsuarioId() == user.getUsuarioId()){
                ListaUsuario.set(i,user);
                return user;
            }
        }
        
        Usuario Usuario1 = new Usuario();
        Usuario1.setUsuarioId(Usuario1.getUsuarioId());
        Usuario1.setPNombre(Usuario1.getPNombre());
        Usuario1.setSNombre(Usuario1.getSNombre());
        Usuario1.setApPaterno(Usuario1.getApPaterno());
        Usuario1.setApMaterno(Usuario1.getApMaterno());
        Usuario1.setEmail(Usuario1.getEmail());
        Usuario1.setPassword(Usuario1.getPassword());
        Usuario1.setFechaRegistro(Usuario1.getFechaRegistro());

        return Usuario1;
    }

    public void EliminarUsuario(int Usuarioid){
        Usuario usuario = BuscarUsuarioPorId(Usuarioid);
        if(usuario != null){
            ListaUsuario.remove(usuario);
        }
    }





        




    
}
