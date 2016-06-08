/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author praveen
 */
@Embeddable
public class AutorLivroPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "livro_id_livro")
    private int livroIdLivro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "autor_id_autor")
    private int autorIdAutor;

    public AutorLivroPK() {
    }

    public AutorLivroPK(int livroIdLivro, int autorIdAutor) {
        this.livroIdLivro = livroIdLivro;
        this.autorIdAutor = autorIdAutor;
    }

    public int getLivroIdLivro() {
        return livroIdLivro;
    }

    public void setLivroIdLivro(int livroIdLivro) {
        this.livroIdLivro = livroIdLivro;
    }

    public int getAutorIdAutor() {
        return autorIdAutor;
    }

    public void setAutorIdAutor(int autorIdAutor) {
        this.autorIdAutor = autorIdAutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) livroIdLivro;
        hash += (int) autorIdAutor;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorLivroPK)) {
            return false;
        }
        AutorLivroPK other = (AutorLivroPK) object;
        if (this.livroIdLivro != other.livroIdLivro) {
            return false;
        }
        if (this.autorIdAutor != other.autorIdAutor) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.AutorLivroPK[ livroIdLivro=" + livroIdLivro + ", autorIdAutor=" + autorIdAutor + " ]";
    }
    
}
