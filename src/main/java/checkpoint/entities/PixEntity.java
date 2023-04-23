package checkpoint.entities;

import checkpoint.enums.TipoChave;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name="TB_PIX")
public class PixEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoChave tipoChave;
    @Column(name="chave_pix")
    private String valor;
    private boolean ativa;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private UsuarioEntity usuario;

    /*
    @OneToMany(mappedBy = "chavesPix")
    @JoinColumn(name="id_transacao")
    private List<TransacaoEntity> transacoes;

     */


    public PixEntity () {}

    public PixEntity(Long id, TipoChave tipoChave, String valor, boolean ativa, UsuarioEntity usuario, List<TransacaoEntity> transacoes) {
        this.id = id;
        this.tipoChave = tipoChave;
        this.valor = valor;
        this.ativa = ativa;
        this.usuario = usuario;
        //this.transacoes = transacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoChave getTipoChave() {
        return tipoChave;
    }

    public void setTipoChave(TipoChave tipoChave) {
        this.tipoChave = tipoChave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    /*
    public List<TransacaoEntity> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<TransacaoEntity> transacoes) {
        this.transacoes = transacoes;
    }
     */
}
