package checkpoint.entities;

import javax.persistence.*;

@Entity
@Table(name="TB_SALDO")
public class SaldoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="vl_saldo")
    private Double valor;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_usuario")
    private UsuarioEntity usuario;

    public SaldoEntity() {
        this.valor = 100.0;
    }

    public SaldoEntity(Long id, Double valor, UsuarioEntity usuario) {
        this.id = id;
        this.valor = valor + 100.0;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
}
