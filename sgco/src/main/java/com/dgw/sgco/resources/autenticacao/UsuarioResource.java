package com.dgw.sgco.resources.autenticacao;

import com.dgw.sgco.domain.autenticacao.Usuario;
import com.dgw.sgco.domain.enums.Permissao;
import com.dgw.sgco.resources.responses.UploadFileResponse;
import com.dgw.sgco.services.FileStorageService;
import com.dgw.sgco.services.autenticacao.UsuarioService;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/imagem/upload", method = RequestMethod.POST)
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/imagem/download/")
                .path(fileName)
                .toUriString();

        return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
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
