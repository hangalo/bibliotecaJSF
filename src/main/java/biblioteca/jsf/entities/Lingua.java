/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author praveen
 */
@Entity
@Table(name = "lingua")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lingua.findAll", query = "SELECT l FROM Lingua l"),
    @NamedQuery(name = "Lingua.findByIdLingua", query = "SELECT l FROM Lingua l WHERE l.idLingua = :idLingua"),
    @NamedQuery(name = "Lingua.findByNomeLingua", query = "SELECT l FROM Lingua l WHERE l.nomeLingua = :nomeLingua")})
public class Lingua implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_lingua")
    private Integer idLingua;
    @Size(max = 45)
    @Column(name = "nome_lingua")
    private String nomeLingua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLingua")
    private Collection<Livro> livroCollection;

    public Lingua() {
    }

    public Lingua(Integer idLingua) {
        this.idLingua = idLingua;
    }

    public Integer getIdLingua() {
        return idLingua;
    }

    public void setIdLingua(Integer idLingua) {
        this.idLingua = idLingua;
    }

    public String getNomeLingua() {
        return nomeLingua;
    }

    public void setNomeLingua(String nomeLingua) {
        this.nomeLingua = nomeLingua;
    }

    @XmlTransient
    public Collection<Livro> getLivroCollection() {
        return livroCollection;
    }

    public void setLivroCollection(Collection<Livro> livroCollection) {
        this.livroCollection = livroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLingua != null ? idLingua.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lingua)) {
            return false;
        }
        Lingua other = (Lingua) object;
        if ((this.idLingua == null && other.idLingua != null) || (this.idLingua != null && !this.idLingua.equals(other.idLingua))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.Lingua[ idLingua=" + idLingua + " ]";
    }
    
}
