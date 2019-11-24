package com.dgw.sgco.resources.autenticacao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.domain.enums.Permissao;
import com.dgw.sgco.dto.autenticacao.AlterarImagemDTO;
import com.dgw.sgco.dto.autenticacao.AlterarSenhaDTO;
import com.dgw.sgco.resources.responses.UploadFileResponse;
import com.dgw.sgco.services.FileStorageService;
import com.dgw.sgco.services.autenticacao.UsuarioService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * UsuarioResource
 */
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/alterar_senha", method = RequestMethod.POST)
    public ResponseEntity<Void> alterarSenha(@RequestBody AlterarSenhaDTO objDto) {
        this.service.alterarSenha(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/alterar_imagem", method = RequestMethod.POST)
    public ResponseEntity<Void> alterarImagem(@RequestBody AlterarImagemDTO objDto) {
        this.service.alterarImagem(objDto);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/imagem/upload", method = RequestMethod.POST)
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/imagem/download/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
    }

    @RequestMapping(value = "/imagem/download/{fileName:.+}", method = RequestMethod.GET)
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = fileStorageService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
        }

        // Fallback to the default content type if type could not be determined
        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    /**
     * Buscar Usuario por id
     * 
     * @param id - Integer
     * @return Usuario
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> find(@PathVariable Integer id) {
        Usuario obj = service.find(id);

        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value = "/permissoes/buscar", method = RequestMethod.GET)
    public ResponseEntity<String> findPermissoes() {
        JsonArray arrayPermissoes = new JsonArray();

        for (Permissao p : Permissao.values()) {
            JsonObject obj = new JsonObject();
            obj.addProperty("cod", p.getCod());
            obj.addProperty("descricao", p.getDescricao());

            arrayPermissoes.add(obj);
        }

        return ResponseEntity.ok().body(arrayPermissoes.toString());
    }

    /**
     * Excluir um Usuário pelo id
     * 
     * @param id - Integer
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }

}
