package checkpoint.entities;

import checkpoint.enums.StatusTransacao;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="TB_TRANSACAO")
public class TransacaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_transacao")
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusTransacao status;
    private String descricaoErro;
    private Calendar horaTranscao;
   
    @OneToMany
    @JoinColumn(name="nome")
    private UsuarioEntity debitor;

    @ManyToOne
    @JoinColumn(name="chave_pix")
    private PixEntity chavePix;

   

    private Long idCreditor;

    public TransacaoEntity () {}

    public TransacaoEntity(Long id, StatusTransacao status, String descricaoErro, Calendar horaTranscao, UsuarioEntity debitor, PixEntity chavePix) {
        this.id = id;
        this.status = status;
        this.descricaoErro = descricaoErro;
        this.horaTranscao = horaTranscao;
        //this.debitor = debitor;
        //this.chavePix = chavePix;
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

    public String getDescricaoErro() {
        return descricaoErro;
    }

    public void setDescricaoErro(String descricaoErro) {
        this.descricaoErro = descricaoErro;
    }

    public Calendar getHoraTranscao() {
        return horaTranscao;
    }

    public void setHoraTranscao(Calendar horaTranscao) {
        this.horaTranscao = horaTranscao;
    }

    /*
    public UsuarioEntity getDebitor() {
        return debitor;
    }

    public void setDebitor(UsuarioEntity debitor) {
        this.debitor = debitor;
    }


    public PixEntity getChavePix() {
        return chavePix;
    }

    public void setChavePix(PixEntity chavePix) {
        this.chavePix = chavePix;
    }

     */
}
