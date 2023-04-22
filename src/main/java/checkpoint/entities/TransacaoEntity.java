package checkpoint.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="TB_TRANSACAO")
public class TransacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusTransacao status;
    private String descricao;
    private Calendar horaTranscao;
    private UsuarioEntity debitor;
    private UsuarioEntity creditor;

    public TransacaoEntity () {}

    public TransacaoEntity(Long id, StatusTransacao status, String descricao, Calendar horaTranscao, UsuarioEntity debitor, UsuarioEntity creditor) {
        this.id = id;
        this.status = status;
        this.descricao = descricao;
        this.horaTranscao = horaTranscao;
        this.debitor = debitor;
        this.creditor = creditor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getHoraTranscao() {
        return horaTranscao;
    }

    public void setHoraTranscao(Calendar horaTranscao) {
        this.horaTranscao = horaTranscao;
    }

    public UsuarioEntity getDebitor() {
        return debitor;
    }

    public void setDebitor(UsuarioEntity debitor) {
        this.debitor = debitor;
    }

    public UsuarioEntity getCreditor() {
        return creditor;
    }

    public void setCreditor(UsuarioEntity creditor) {
        this.creditor = creditor;
    }
}
