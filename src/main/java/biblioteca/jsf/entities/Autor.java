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
@Table(name = "autor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autor.findAll", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor"),
    @NamedQuery(name = "Autor.findByNomeAutor", query = "SELECT a FROM Autor a WHERE a.nomeAutor = :nomeAutor"),
    @NamedQuery(name = "Autor.findBySobrenomeAutor", query = "SELECT a FROM Autor a WHERE a.sobrenomeAutor = :sobrenomeAutor"),
    @NamedQuery(name = "Autor.findByDataNascimento", query = "SELECT a FROM Autor a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Autor.findByBreveBiografia", query = "SELECT a FROM Autor a WHERE a.breveBiografia = :breveBiografia")})
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_autor")
    private Integer idAutor;
    @Size(max = 45)
    @Column(name = "nome_autor")
    private String nomeAutor;
    @Size(max = 45)
    @Column(name = "sobrenome_autor")
    private String sobrenomeAutor;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Size(max = 400)
    @Column(name = "breve_biografia")
    private String breveBiografia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private Collection<AutorLivro> autorLivroCollection;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    @ManyToOne
    private Municipio idMunicipio;

    public Autor() {
    }

    public Autor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getSobrenomeAutor() {
        return sobrenomeAutor;
    }

    public void setSobrenomeAutor(String sobrenomeAutor) {
        this.sobrenomeAutor = sobrenomeAutor;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getBreveBiografia() {
        return breveBiografia;
    }

    public void setBreveBiografia(String breveBiografia) {
        this.breveBiografia = breveBiografia;
    }

    @XmlTransient
    public Collection<AutorLivro> getAutorLivroCollection() {
        return autorLivroCollection;
    }

    public void setAutorLivroCollection(Collection<AutorLivro> autorLivroCollection) {
        this.autorLivroCollection = autorLivroCollection;
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
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.Autor[ idAutor=" + idAutor + " ]";
    }
    
}
