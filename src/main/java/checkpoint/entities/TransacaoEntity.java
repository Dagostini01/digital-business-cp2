package checkpoint.entities;

import checkpoint.enums.StatusTransacao;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
@Table(name="TB_TRANSACAO")
public class TransacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_transacao")
    private Long id;
    private double valorTransacao;
    @Enumerated(EnumType.STRING)
    private StatusTransacao status;
    private String descricaoErro;
    private LocalDate horaTranscao;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private PixEntity pixDebitor;
    @Column(name = "chave_pix_creditor")
    private String chavePixCreditor;


    public TransacaoEntity () {
        this.horaTranscao = LocalDate.now();
    }

    public TransacaoEntity(Long id, double valorTransacao, StatusTransacao status, String descricaoErro,
                           Calendar horaTranscao, PixEntity pixDebitor, String chavePixCreditor) {
        this.id = id;
        this.valorTransacao = valorTransacao;
        this.status = status;
        this.descricaoErro = descricaoErro;
        this.horaTranscao = LocalDate.now();
        this.pixDebitor = pixDebitor;
        this.chavePixCreditor = chavePixCreditor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(double valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public void setStatus(StatusTransacao status) {
        this.status = status;
    }

    public String getDescricaoErro() {
        return descricaoErro;
    }

    public void setDescricaoErro(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }

    public LocalDate getHoraTranscao() {
        return horaTranscao;
    }

    public void setHoraTranscao(LocalDate horaTranscao) {
        this.horaTranscao = horaTranscao;
    }

    public PixEntity getPixDebitor() {
        return pixDebitor;
    }

    public void setPixDebitor(PixEntity pixDebitor) {
        this.pixDebitor = pixDebitor;
    }

    public String getChavePixCreditor() {
        return chavePixCreditor;
    }

    public void setChavePixCreditor(String chavePixCreditor) {
        this.chavePixCreditor = chavePixCreditor;
    }
}
