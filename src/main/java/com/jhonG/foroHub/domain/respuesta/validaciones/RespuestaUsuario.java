package com.jhonG.foroHub.domain.respuesta.validaciones;


import com.jhonG.foroHub.domain.respuesta.DatosRespuesta;
import com.jhonG.foroHub.domain.usuario.UsuarioRepository;
import com.jhonG.foroHub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RespuestaUsuario implements IValidadorDeRespuestas {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosRespuesta datosRespuesta) {
        if (!usuarioRepository.findById(datosRespuesta.idUsuario()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encotrado");
        }
    }



}
