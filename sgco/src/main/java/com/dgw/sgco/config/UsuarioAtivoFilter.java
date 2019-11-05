package com.dgw.sgco.config;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.security.JWTUtil;

/**
 * ResponseFiler
 */
public class UsuarioAtivoFilter {

    private JWTUtil jwtUtil;
    private UsuarioRepository repoUsuario;

    public UsuarioAtivoFilter(JWTUtil jwtUtil, UsuarioRepository repoUsuario) {
        this.jwtUtil = jwtUtil;
        this.repoUsuario = repoUsuario;
    }

    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");

        String header = ((HttpServletResponse) response).getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            String email = null;

            if (jwtUtil.tokenValido(token)) {
                email = jwtUtil.getUsername(token);
            }

            if (email != null) {
                Usuario user = repoUsuario.findByLogin(email);

                if (user != null) {
                    if (!user.isAtivo()) {
                        usuarioInativo((HttpServletRequest) request, (HttpServletResponse) response);
                    }
                } else {
                    usuarioInativo((HttpServletRequest) request, (HttpServletResponse) response);
                }
            }
        }
    }

    private void usuarioInativo(HttpServletRequest requisicao, HttpServletResponse response) throws IOException {
        response.setStatus(401);
        response.setContentType("application/json");
        response.getWriter().append(json(requisicao.getPathInfo()));
    }

    private String json(String path) {
        long date = new Date().getTime();

        return "{\"timestamp\": " + date + ", "
                + "\"status\": 401, "
                + "\"error\": \"Não autorizado\", "
                + "\"message\": \"Usuário inativo\", "
                + "\"path\": " + path + "}";
    }

}
