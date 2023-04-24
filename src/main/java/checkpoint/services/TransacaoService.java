package checkpoint.services;

import checkpoint.entities.PixEntity;
import checkpoint.entities.TransacaoEntity;
import checkpoint.entities.UsuarioEntity;
import checkpoint.enums.StatusTransacao;
import checkpoint.repositories.PixRepository;
import checkpoint.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service

public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private PixRepository pixRepository;

    @NotNull
    public void realizarTransacao(@org.jetbrains.annotations.NotNull TransacaoEntity transacao) throws Exception{

        if (pixRepository.findByValor(transacao.getChavePixCreditor()) != null) {
            String msg = "Pix creditor não encontrado";
            transacao.setDescricaoErro(msg);
            transacao.setStatus(StatusTransacao.FALHA);
            transacaoRepository.save(transacao);
            throw new IllegalArgumentException(msg);
        }

        UsuarioEntity usuarioDebitor = transacao.getPixDebitor().getUsuario();
        double saldoDebitor = usuarioDebitor.getSaldo().getValor();

        if (saldoDebitor >= transacao.getValorTransacao()) {
            String msg = "Saldo insulficiente";
            transacao.setDescricaoErro(msg);
            transacao.setStatus(StatusTransacao.FALHA);
            transacaoRepository.save(transacao);
            throw new IllegalArgumentException(msg);
        }

        PixEntity pixCreditor = pixRepository.findByValor(transacao.getChavePixCreditor());
        UsuarioEntity usuarioCreditor = pixCreditor.getUsuario();
        double saldoCreditor = usuarioCreditor.getSaldo().getValor();




        if (!usuarioCreditor.isAtivo() || !usuarioDebitor.isAtivo()) {
            String msg = "Os usuários não estão ativos";
            transacao.setDescricaoErro(msg);
            transacao.setStatus(StatusTransacao.FALHA);
            transacaoRepository.save(transacao);
            throw new IllegalArgumentException(msg);
        }

        saldoDebitor = saldoDebitor - transacao.getValorTransacao();
        saldoCreditor = saldoCreditor + transacao.getValorTransacao();
        transacao.setStatus(StatusTransacao.SUCESSO);
        transacaoRepository.save(transacao);

    }

    public List<TransacaoEntity> findAll() {
        List<TransacaoEntity> transacoes = transacaoRepository.findAll();
        return transacoes;
    }

    public List<TransacaoEntity> listarTransacoesUltimos7Dias() {
        List<TransacaoEntity> transacoes = transacaoRepository.findAll();
        List<TransacaoEntity> transacoesUltimosSeteDias = new ArrayList<>();
        for (TransacaoEntity t : transacoes) {
            int seteDiasAtras = LocalDateTime.now().getDayOfYear() - 7;
            int ano = LocalDateTime.now().getYear();
            if (ano == t.getHoraTranscao().getYear() && t.getHoraTranscao().getDayOfYear() > seteDiasAtras) {
                transacoesUltimosSeteDias.add(t);
            }
        }
        return transacoesUltimosSeteDias;
    }
}
