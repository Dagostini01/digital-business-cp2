package checkpoint.entities;

import javax.persistence.*;

@Entity
@Table(name="TB_SALDO")
public class SaldoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double valor;

    public SaldoEntity() {
        this.valor = 100.0;
    }

    public SaldoEntity(Long id, Double valor) {
        this.id = id;
        this.valor = valor + 100.0;
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
}
