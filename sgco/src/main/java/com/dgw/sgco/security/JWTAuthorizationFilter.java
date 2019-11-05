package com.dgw.sgco.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dgw.sgco.config.UsuarioAtivoFilter;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * JWTAuthorizationFilter
 */
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private JWTUtil jwtUtil;
    private UserDetailsService userDetailsService;
    private UsuarioRepository repoUsuario;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailsService, UsuarioRepository repoUsuario) {
        super(authenticationManager);

        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.repoUsuario = repoUsuario;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");

        UsuarioAtivoFilter usuarioAtivoFilter = new UsuarioAtivoFilter(jwtUtil, repoUsuario);
        usuarioAtivoFilter.doFilter(request, response);

        if (header != null && header.startsWith("Bearer ")) {
            UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));

            if (auth != null) {
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String token) {
        if (jwtUtil.tokenValido(token)) {
            String email = jwtUtil.getUsername(token);

            UserDetails userD = userDetailsService.loadUserByUsername(email);

            return new UsernamePasswordAuthenticationToken(userD, null, userD.getAuthorities());
        }

        return null;
    }
}
