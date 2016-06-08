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
@Table(name = "livro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l"),
    @NamedQuery(name = "Livro.findByIdLivro", query = "SELECT l FROM Livro l WHERE l.idLivro = :idLivro"),
    @NamedQuery(name = "Livro.findByIsbn", query = "SELECT l FROM Livro l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Livro.findByDataPublicacao", query = "SELECT l FROM Livro l WHERE l.dataPublicacao = :dataPublicacao"),
    @NamedQuery(name = "Livro.findByEdicao", query = "SELECT l FROM Livro l WHERE l.edicao = :edicao"),
    @NamedQuery(name = "Livro.findByResumo", query = "SELECT l FROM Livro l WHERE l.resumo = :resumo"),
    @NamedQuery(name = "Livro.findBySessao", query = "SELECT l FROM Livro l WHERE l.sessao = :sessao"),
    @NamedQuery(name = "Livro.findByEstante", query = "SELECT l FROM Livro l WHERE l.estante = :estante"),
    @NamedQuery(name = "Livro.findByPosicao", query = "SELECT l FROM Livro l WHERE l.posicao = :posicao")})
public class Livro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_livro")
    private Integer idLivro;
    @Size(max = 100)
    @Column(name = "isbn")
    private String isbn;
    @Size(max = 100)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "data_publicacao")
    @Temporal(TemporalType.DATE)
    private Date dataPublicacao;
    @Size(max = 45)
    @Column(name = "edicao")
    private String edicao;
    @Size(max = 400)
    @Column(name = "resumo")
    private String resumo;
    @Size(max = 45)
    @Column(name = "sessao")
    private String sessao;
    @Column(name = "estante")
    private Integer estante;
    @Column(name = "posicao")
    private Integer posicao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livro")
    private Collection<LivroCategoria> livroCategoriaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livro")
    private Collection<Emprestimo> emprestimoCollection;
    @JoinColumn(name = "id_editora", referencedColumnName = "id_editora")
    @ManyToOne(optional = false)
    private Editora idEditora;
    @JoinColumn(name = "id_lingua", referencedColumnName = "id_lingua")
    @ManyToOne(optional = false)
    private Lingua idLingua;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "livro")
    private Collection<AutorLivro> autorLivroCollection;

    public Livro() {
    }

    public Livro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public Integer getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Integer idLivro) {
        this.idLivro = idLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSessao() {
        return sessao;
    }

    public void setSessao(String sessao) {
        this.sessao = sessao;
    }

    public Integer getEstante() {
        return estante;
    }

    public void setEstante(Integer estante) {
        this.estante = estante;
    }

    public Integer getPosicao() {
        return posicao;
    }

    public void setPosicao(Integer posicao) {
        this.posicao = posicao;
    }

    @XmlTransient
    public Collection<LivroCategoria> getLivroCategoriaCollection() {
        return livroCategoriaCollection;
    }

    public void setLivroCategoriaCollection(Collection<LivroCategoria> livroCategoriaCollection) {
        this.livroCategoriaCollection = livroCategoriaCollection;
    }

    @XmlTransient
    public Collection<Emprestimo> getEmprestimoCollection() {
        return emprestimoCollection;
    }

    public void setEmprestimoCollection(Collection<Emprestimo> emprestimoCollection) {
        this.emprestimoCollection = emprestimoCollection;
    }

    public Editora getIdEditora() {
        return idEditora;
    }

    public void setIdEditora(Editora idEditora) {
        this.idEditora = idEditora;
    }

    public Lingua getIdLingua() {
        return idLingua;
    }

    public void setIdLingua(Lingua idLingua) {
        this.idLingua = idLingua;
    }

    @XmlTransient
    public Collection<AutorLivro> getAutorLivroCollection() {
        return autorLivroCollection;
    }

    public void setAutorLivroCollection(Collection<AutorLivro> autorLivroCollection) {
        this.autorLivroCollection = autorLivroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLivro != null ? idLivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.idLivro == null && other.idLivro != null) || (this.idLivro != null && !this.idLivro.equals(other.idLivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.Livro[ idLivro=" + idLivro + " ]";
    }
    
}
