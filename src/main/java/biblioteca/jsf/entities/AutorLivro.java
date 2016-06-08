/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author praveen
 */
@Entity
@Table(name = "autor_livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorLivro.findAll", query = "SELECT a FROM AutorLivro a"),
    @NamedQuery(name = "AutorLivro.findByLivroIdLivro", query = "SELECT a FROM AutorLivro a WHERE a.autorLivroPK.livroIdLivro = :livroIdLivro"),
    @NamedQuery(name = "AutorLivro.findByAutorIdAutor", query = "SELECT a FROM AutorLivro a WHERE a.autorLivroPK.autorIdAutor = :autorIdAutor"),
    @NamedQuery(name = "AutorLivro.findByAno", query = "SELECT a FROM AutorLivro a WHERE a.ano = :ano")})
public class AutorLivro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutorLivroPK autorLivroPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    @JoinColumn(name = "autor_id_autor", referencedColumnName = "id_autor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Autor autor;
    @JoinColumn(name = "livro_id_livro", referencedColumnName = "id_livro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Livro livro;

    public AutorLivro() {
    }

    public AutorLivro(AutorLivroPK autorLivroPK) {
        this.autorLivroPK = autorLivroPK;
    }

    public AutorLivro(AutorLivroPK autorLivroPK, int ano) {
        this.autorLivroPK = autorLivroPK;
        this.ano = ano;
    }

    public AutorLivro(int livroIdLivro, int autorIdAutor) {
        this.autorLivroPK = new AutorLivroPK(livroIdLivro, autorIdAutor);
    }

    public AutorLivroPK getAutorLivroPK() {
        return autorLivroPK;
    }

    public void setAutorLivroPK(AutorLivroPK autorLivroPK) {
        this.autorLivroPK = autorLivroPK;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autorLivroPK != null ? autorLivroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorLivro)) {
            return false;
        }
        AutorLivro other = (AutorLivro) object;
        if ((this.autorLivroPK == null && other.autorLivroPK != null) || (this.autorLivroPK != null && !this.autorLivroPK.equals(other.autorLivroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.AutorLivro[ autorLivroPK=" + autorLivroPK + " ]";
    }
    
}
