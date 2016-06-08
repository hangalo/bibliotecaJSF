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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "editora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Editora.findAll", query = "SELECT e FROM Editora e"),
    @NamedQuery(name = "Editora.findByIdEditora", query = "SELECT e FROM Editora e WHERE e.idEditora = :idEditora"),
    @NamedQuery(name = "Editora.findByNomeEditora", query = "SELECT e FROM Editora e WHERE e.nomeEditora = :nomeEditora"),
    @NamedQuery(name = "Editora.findByCasaEditora", query = "SELECT e FROM Editora e WHERE e.casaEditora = :casaEditora"),
    @NamedQuery(name = "Editora.findByRuaEditora", query = "SELECT e FROM Editora e WHERE e.ruaEditora = :ruaEditora"),
    @NamedQuery(name = "Editora.findByBairroEditora", query = "SELECT e FROM Editora e WHERE e.bairroEditora = :bairroEditora"),
    @NamedQuery(name = "Editora.findByCaixaPostalEditora", query = "SELECT e FROM Editora e WHERE e.caixaPostalEditora = :caixaPostalEditora"),
    @NamedQuery(name = "Editora.findByTelefoneFixoEditora", query = "SELECT e FROM Editora e WHERE e.telefoneFixoEditora = :telefoneFixoEditora"),
    @NamedQuery(name = "Editora.findByTelefoneMovelEditora", query = "SELECT e FROM Editora e WHERE e.telefoneMovelEditora = :telefoneMovelEditora"),
    @NamedQuery(name = "Editora.findByEmailEditora", query = "SELECT e FROM Editora e WHERE e.emailEditora = :emailEditora"),
    @NamedQuery(name = "Editora.findByHomePageEditora", query = "SELECT e FROM Editora e WHERE e.homePageEditora = :homePageEditora")})
public class Editora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_editora")
    private Integer idEditora;
    @Size(max = 100)
    @Column(name = "nome_editora")
    private String nomeEditora;
    @Size(max = 45)
    @Column(name = "casa_editora")
    private String casaEditora;
    @Size(max = 45)
    @Column(name = "rua_editora")
    private String ruaEditora;
    @Size(max = 45)
    @Column(name = "bairro_editora")
    private String bairroEditora;
    @Size(max = 45)
    @Column(name = "caixa_postal_editora")
    private String caixaPostalEditora;
    @Size(max = 45)
    @Column(name = "telefone_fixo_editora")
    private String telefoneFixoEditora;
    @Size(max = 45)
    @Column(name = "telefone_movel_editora")
    private String telefoneMovelEditora;
    @Size(max = 45)
    @Column(name = "email_editora")
    private String emailEditora;
    @Size(max = 45)
    @Column(name = "home_page_editora")
    private String homePageEditora;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEditora")
    private Collection<Livro> livroCollection;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    @ManyToOne
    private Municipio idMunicipio;

    public Editora() {
    }

    public Editora(Integer idEditora) {
        this.idEditora = idEditora;
    }

    public Integer getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Integer idEditora) {
        this.idEditora = idEditora;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public String getCasaEditora() {
        return casaEditora;
    }

    public void setCasaEditora(String casaEditora) {
        this.casaEditora = casaEditora;
    }

    public String getRuaEditora() {
        return ruaEditora;
    }

    public void setRuaEditora(String ruaEditora) {
        this.ruaEditora = ruaEditora;
    }

    public String getBairroEditora() {
        return bairroEditora;
    }

    public void setBairroEditora(String bairroEditora) {
        this.bairroEditora = bairroEditora;
    }

    public String getCaixaPostalEditora() {
        return caixaPostalEditora;
    }

    public void setCaixaPostalEditora(String caixaPostalEditora) {
        this.caixaPostalEditora = caixaPostalEditora;
    }

    public String getTelefoneFixoEditora() {
        return telefoneFixoEditora;
    }

    public void setTelefoneFixoEditora(String telefoneFixoEditora) {
        this.telefoneFixoEditora = telefoneFixoEditora;
    }

    public String getTelefoneMovelEditora() {
        return telefoneMovelEditora;
    }

    public void setTelefoneMovelEditora(String telefoneMovelEditora) {
        this.telefoneMovelEditora = telefoneMovelEditora;
    }

    public String getEmailEditora() {
        return emailEditora;
    }

    public void setEmailEditora(String emailEditora) {
        this.emailEditora = emailEditora;
    }

    public String getHomePageEditora() {
        return homePageEditora;
    }

    public void setHomePageEditora(String homePageEditora) {
        this.homePageEditora = homePageEditora;
    }

    @XmlTransient
    public Collection<Livro> getLivroCollection() {
        return livroCollection;
    }

    public void setLivroCollection(Collection<Livro> livroCollection) {
        this.livroCollection = livroCollection;
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
        hash += (idEditora != null ? idEditora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editora)) {
            return false;
        }
        Editora other = (Editora) object;
        if ((this.idEditora == null && other.idEditora != null) || (this.idEditora != null && !this.idEditora.equals(other.idEditora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.Editora[ idEditora=" + idEditora + " ]";
    }
    
}
