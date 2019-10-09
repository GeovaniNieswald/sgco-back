package com.dgw.sgco.services.autenticacao;

import java.util.Random;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.repositories.autenticacao.UsuarioRepository;
import com.dgw.sgco.services.email.EmailService;
import com.dgw.sgco.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * AuthService
 */
@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private EmailService emailService;

    private Random rand = new Random();

    /**
     * Método para enviar uma nova senha para o usuário
     * 
     * @param email - String
     */
    public void sendNewPassword(String email) {
        Usuario user = usuarioRepo.findByLogin(email);

        if (user == null) {
            throw new ObjectNotFoundException("Email não encontrado");
        }

        String newPass = newPassword();
        user.setSenha(pe.encode(newPass));

        usuarioRepo.save(user);

        emailService.sendNewPasswordEmail(user, newPass);
    }

    /**
     * Método para gerar uma nova senha
     * 
     * @return String
     */
    private String newPassword() {
        char[] vet = new char[10];

        for (int i = 0; i < 10; i++) {
            vet[i] = randomChar();
        }

        return new String(vet);
    }

    /**
     * Métodod para gerar um char aleatório
     * 
     * @return char
     */
    private char randomChar() {
        int opt = rand.nextInt(3);

        if (opt == 0) { // gera um digito
            return (char) (rand.nextInt(10) + 48);
        } else if (opt == 1) { // gera letra maiuscula
            return (char) (rand.nextInt(26) + 65);
        } else { // gera letra minuscula
            return (char) (rand.nextInt(26) + 97);
        }
    }

}
