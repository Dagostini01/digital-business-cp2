package checkpoint.services;

import checkpoint.entities.PixEntity;
import checkpoint.exception.ChaveJaCadastradaException;
import checkpoint.repositories.PixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PixService {

    @Autowired
    private PixRepository pixRepository;

    public void cadastrarPix(PixEntity pix) throws ChaveJaCadastradaException{
        String valorChave = pix.getValor();
        if (!pix.getUsuario().isAtivo()) {
            throw new IllegalArgumentException("Usuário não está ativo");
        }

        if (pixRepository.findByValor(valorChave) != null) {
            throw new ChaveJaCadastradaException("Chave já está sendo utilizada");
        }

        pixRepository.save(pix);

    }

    public void delete(String chavePix) {
        PixEntity pix = pixRepository.findByValor(chavePix);

        if (pix != null) {
            pixRepository.delete(pix);
        } else {
            throw new IllegalArgumentException("Pix não foi removido, chave não encontrada");
        }
    }

}
