/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author praveen
 */
@Embeddable
public class LivroCategoriaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "livro_id_livro")
    private int livroIdLivro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "categoria_id_categoria")
    private int categoriaIdCategoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_registo")
    @Temporal(TemporalType.DATE)
    private Date dataRegisto;

    public LivroCategoriaPK() {
    }

    public LivroCategoriaPK(int livroIdLivro, int categoriaIdCategoria, Date dataRegisto) {
        this.livroIdLivro = livroIdLivro;
        this.categoriaIdCategoria = categoriaIdCategoria;
        this.dataRegisto = dataRegisto;
    }

    public int getLivroIdLivro() {
        return livroIdLivro;
    }

    public void setLivroIdLivro(int livroIdLivro) {
        this.livroIdLivro = livroIdLivro;
    }

    public int getCategoriaIdCategoria() {
        return categoriaIdCategoria;
    }

    public void setCategoriaIdCategoria(int categoriaIdCategoria) {
        this.categoriaIdCategoria = categoriaIdCategoria;
    }

    public Date getDataRegisto() {
        return dataRegisto;
    }

    public void setDataRegisto(Date dataRegisto) {
        this.dataRegisto = dataRegisto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) livroIdLivro;
        hash += (int) categoriaIdCategoria;
        hash += (dataRegisto != null ? dataRegisto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LivroCategoriaPK)) {
            return false;
        }
        LivroCategoriaPK other = (LivroCategoriaPK) object;
        if (this.livroIdLivro != other.livroIdLivro) {
            return false;
        }
        if (this.categoriaIdCategoria != other.categoriaIdCategoria) {
            return false;
        }
        if ((this.dataRegisto == null && other.dataRegisto != null) || (this.dataRegisto != null && !this.dataRegisto.equals(other.dataRegisto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.LivroCategoriaPK[ livroIdLivro=" + livroIdLivro + ", categoriaIdCategoria=" + categoriaIdCategoria + ", dataRegisto=" + dataRegisto + " ]";
    }
    
}
