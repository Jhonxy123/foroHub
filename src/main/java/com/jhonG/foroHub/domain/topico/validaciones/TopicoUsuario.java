package com.jhonG.foroHub.domain.topico.validaciones;

import com.jhonG.foroHub.domain.topico.DatosTopico;
import com.jhonG.foroHub.domain.usuario.UsuarioRepository;
import com.jhonG.foroHub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoUsuario implements IValidadorDeTopicos {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosTopico datosTopico){
        if (!usuarioRepository.findById(datosTopico.idUsuario()).isPresent()) {
            throw new ValidacionDeIntegridad("Usuario no encontrado");
        }
    }
}
