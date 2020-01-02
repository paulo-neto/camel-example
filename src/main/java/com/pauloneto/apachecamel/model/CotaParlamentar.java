package com.pauloneto.apachecamel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jnosql.artemis.Column;
import org.jnosql.artemis.Embeddable;
import org.jnosql.artemis.Entity;
import org.jnosql.artemis.Id;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
@Entity("CotaParlamentar")
public class CotaParlamentar implements Serializable {

    @Id("_id")
    private String id;

    @Column
    private long idDeputado;
    @Column
    private String nomeParlamentar;

    @Column
    private String cpf;

    @Column
    private String numeroCarteiraParlamentar;

    @Column
    private Long legislatura;

    @Column
    private String siglaUF;

    @Column
    private String siglaPartido;

    @Column
    private Long codigoLegislatura;

    @Column
    private Long numeroSubCota;

    @Column
    private String descricao;

    @Column
    private Long numeroEspecificacaoSubCota;

    @Column
    private String descricaoEspecificacao;

    @Column
    private String fornecedor;

    @Column
    private String cnpjCPF;

    @Column
    private String numero;

    @Column
    private String tipoDocumento;

    @Column
    private Date dataEmissao;

    @Column
    private String valorDocumento;

    @Column
    private String valorGlosa;

    @Column
    private String valorLiquido;

    @Column
    private Integer mes;

    @Column
    private Long ano;

    @Column
    private String parcela;

    @Column
    private String passageiro;

    @Column
    private String trecho;

    @Column
    private String lote;

    @Column
    private String ressarcimento;

    @Column
    private String restituicao;

    @Column
    private Long numeroDeputadoID;
    @Column
    private Long idDocumento;

    @Column
    private String urlDocumento;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        HashCodeBuilder builder = new HashCodeBuilder();
        builder.append(getId());
        return builder.toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        String[] ignoreFields = {"id"};
        return EqualsBuilder.reflectionEquals(this, obj, true, CotaParlamentar.class, ignoreFields);
    }
}
