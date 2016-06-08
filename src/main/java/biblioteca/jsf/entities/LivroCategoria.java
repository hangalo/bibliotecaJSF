/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author praveen
 */
@Entity
@Table(name = "livro_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LivroCategoria.findAll", query = "SELECT l FROM LivroCategoria l"),
    @NamedQuery(name = "LivroCategoria.findByLivroIdLivro", query = "SELECT l FROM LivroCategoria l WHERE l.livroCategoriaPK.livroIdLivro = :livroIdLivro"),
    @NamedQuery(name = "LivroCategoria.findByCategoriaIdCategoria", query = "SELECT l FROM LivroCategoria l WHERE l.livroCategoriaPK.categoriaIdCategoria = :categoriaIdCategoria"),
    @NamedQuery(name = "LivroCategoria.findByDataRegisto", query = "SELECT l FROM LivroCategoria l WHERE l.livroCategoriaPK.dataRegisto = :dataRegisto")})
public class LivroCategoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LivroCategoriaPK livroCategoriaPK;
    @JoinColumn(name = "categoria_id_categoria", referencedColumnName = "id_categoria", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "livro_id_livro", referencedColumnName = "id_livro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Livro livro;

    public LivroCategoria() {
    }

    public LivroCategoria(LivroCategoriaPK livroCategoriaPK) {
        this.livroCategoriaPK = livroCategoriaPK;
    }

    public LivroCategoria(int livroIdLivro, int categoriaIdCategoria, Date dataRegisto) {
        this.livroCategoriaPK = new LivroCategoriaPK(livroIdLivro, categoriaIdCategoria, dataRegisto);
    }

    public LivroCategoriaPK getLivroCategoriaPK() {
        return livroCategoriaPK;
    }

    public void setLivroCategoriaPK(LivroCategoriaPK livroCategoriaPK) {
        this.livroCategoriaPK = livroCategoriaPK;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        hash += (livroCategoriaPK != null ? livroCategoriaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LivroCategoria)) {
            return false;
        }
        LivroCategoria other = (LivroCategoria) object;
        if ((this.livroCategoriaPK == null && other.livroCategoriaPK != null) || (this.livroCategoriaPK != null && !this.livroCategoriaPK.equals(other.livroCategoriaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.LivroCategoria[ livroCategoriaPK=" + livroCategoriaPK + " ]";
    }
    
}
