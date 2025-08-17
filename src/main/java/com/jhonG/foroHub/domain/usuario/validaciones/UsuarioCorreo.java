package com.jhonG.foroHub.domain.usuario.validaciones;

import com.jhonG.foroHub.domain.usuario.DatosUsuario;
import com.jhonG.foroHub.domain.usuario.UsuarioRepository;
import com.jhonG.foroHub.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UsuarioCorreo implements IValidadorDeUsuarios {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void validar(DatosUsuario datosUsuario) {
        var usuario = usuarioRepository.existsByCorreo(datosUsuario.correo());
        if (usuario) {
            throw new ValidacionDeIntegridad("Correo ya registrado");
        }
    }
}
