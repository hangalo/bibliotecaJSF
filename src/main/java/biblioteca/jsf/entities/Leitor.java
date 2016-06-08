/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author praveen
 */
@Entity
@Table(name = "leitor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Leitor.findAll", query = "SELECT l FROM Leitor l"),
    @NamedQuery(name = "Leitor.findByIdLeitor", query = "SELECT l FROM Leitor l WHERE l.idLeitor = :idLeitor"),
    @NamedQuery(name = "Leitor.findByNomeLeitor", query = "SELECT l FROM Leitor l WHERE l.nomeLeitor = :nomeLeitor"),
    @NamedQuery(name = "Leitor.findBySobrenomeLeitor", query = "SELECT l FROM Leitor l WHERE l.sobrenomeLeitor = :sobrenomeLeitor"),
    @NamedQuery(name = "Leitor.findByDataNascimento", query = "SELECT l FROM Leitor l WHERE l.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Leitor.findByDataInscricao", query = "SELECT l FROM Leitor l WHERE l.dataInscricao = :dataInscricao"),
    @NamedQuery(name = "Leitor.findByBairroLeitor", query = "SELECT l FROM Leitor l WHERE l.bairroLeitor = :bairroLeitor"),
    @NamedQuery(name = "Leitor.findByRuaLeitor", query = "SELECT l FROM Leitor l WHERE l.ruaLeitor = :ruaLeitor"),
    @NamedQuery(name = "Leitor.findByCasaLeitor", query = "SELECT l FROM Leitor l WHERE l.casaLeitor = :casaLeitor")})
public class Leitor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_leitor")
    private Integer idLeitor;
    @Size(max = 45)
    @Column(name = "nome_leitor")
    private String nomeLeitor;
    @Size(max = 45)
    @Column(name = "sobrenome_leitor")
    private String sobrenomeLeitor;
    @Size(max = 45)
    @Column(name = "data_nascimento")
    private String dataNascimento;
    @Column(name = "data_inscricao")
    @Temporal(TemporalType.DATE)
    private Date dataInscricao;
    @Size(max = 45)
    @Column(name = "bairro_leitor")
    private String bairroLeitor;
    @Size(max = 45)
    @Column(name = "rua_leitor")
    private String ruaLeitor;
    @Size(max = 45)
    @Column(name = "casa_leitor")
    private String casaLeitor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "leitor")
    private Collection<Emprestimo> emprestimoCollection;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false)
    private Municipio idMunicipio;

    public Leitor() {
    }

    public Leitor(Integer idLeitor) {
        this.idLeitor = idLeitor;
    }

    public Integer getIdLeitor() {
        return idLeitor;
    }

    public void setIdLeitor(Integer idLeitor) {
        this.idLeitor = idLeitor;
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public void setNomeLeitor(String nomeLeitor) {
        this.nomeLeitor = nomeLeitor;
    }

    public String getSobrenomeLeitor() {
        return sobrenomeLeitor;
    }

    public void setSobrenomeLeitor(String sobrenomeLeitor) {
        this.sobrenomeLeitor = sobrenomeLeitor;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    public String getBairroLeitor() {
        return bairroLeitor;
    }

    public void setBairroLeitor(String bairroLeitor) {
        this.bairroLeitor = bairroLeitor;
    }

    public String getRuaLeitor() {
        return ruaLeitor;
    }

    public void setRuaLeitor(String ruaLeitor) {
        this.ruaLeitor = ruaLeitor;
    }

    public String getCasaLeitor() {
        return casaLeitor;
    }

    public void setCasaLeitor(String casaLeitor) {
        this.casaLeitor = casaLeitor;
    }

    @XmlTransient
    public Collection<Emprestimo> getEmprestimoCollection() {
        return emprestimoCollection;
    }

    public void setEmprestimoCollection(Collection<Emprestimo> emprestimoCollection) {
        this.emprestimoCollection = emprestimoCollection;
    }

    public Municipio getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipio idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLeitor != null ? idLeitor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Leitor)) {
            return false;
        }
        Leitor other = (Leitor) object;
        if ((this.idLeitor == null && other.idLeitor != null) || (this.idLeitor != null && !this.idLeitor.equals(other.idLeitor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.Leitor[ idLeitor=" + idLeitor + " ]";
    }
    
}
