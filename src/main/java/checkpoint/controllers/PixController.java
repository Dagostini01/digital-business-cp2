package checkpoint.controllers;

import checkpoint.entities.PixEntity;
import checkpoint.entities.UsuarioEntity;
import checkpoint.services.PixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pix")
public class PixController {

    @Autowired
    private PixService pixService;

    @GetMapping
    public ResponseEntity<List<PixEntity>> findAll() {
        return ResponseEntity.ok(pixService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> cadastrarPix(@RequestBody PixEntity pix) {
        try {
            pixService.cadastrarPix(pix);
            return ResponseEntity.created(URI.create("/pix")).body("PIX cadastro!");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    @DeleteMapping("/{valor}")
    public ResponseEntity<String> deleteUsuarioEntity(@PathVariable String valor) {
        try {
            pixService.delete(valor);
            return ResponseEntity.ok("PIX deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
