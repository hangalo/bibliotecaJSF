/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.jsf.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author praveen
 */
@Entity
@Table(name = "emprestimo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprestimo.findAll", query = "SELECT e FROM Emprestimo e"),
    @NamedQuery(name = "Emprestimo.findByIdLivro", query = "SELECT e FROM Emprestimo e WHERE e.emprestimoPK.idLivro = :idLivro"),
    @NamedQuery(name = "Emprestimo.findByIdLeitor", query = "SELECT e FROM Emprestimo e WHERE e.emprestimoPK.idLeitor = :idLeitor"),
    @NamedQuery(name = "Emprestimo.findByDataEmprestimo", query = "SELECT e FROM Emprestimo e WHERE e.emprestimoPK.dataEmprestimo = :dataEmprestimo"),
    @NamedQuery(name = "Emprestimo.findByDataDevolucao", query = "SELECT e FROM Emprestimo e WHERE e.dataDevolucao = :dataDevolucao"),
    @NamedQuery(name = "Emprestimo.findByObservacoes", query = "SELECT e FROM Emprestimo e WHERE e.observacoes = :observacoes")})
public class Emprestimo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmprestimoPK emprestimoPK;
    @Column(name = "data_devolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Size(max = 100)
    @Column(name = "observacoes")
    private String observacoes;
    @JoinColumn(name = "id_leitor", referencedColumnName = "id_leitor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Leitor leitor;
    @JoinColumn(name = "id_livro", referencedColumnName = "id_livro", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Livro livro;

    public Emprestimo() {
    }

    public Emprestimo(EmprestimoPK emprestimoPK) {
        this.emprestimoPK = emprestimoPK;
    }

    public Emprestimo(int idLivro, int idLeitor, Date dataEmprestimo) {
        this.emprestimoPK = new EmprestimoPK(idLivro, idLeitor, dataEmprestimo);
    }

    public EmprestimoPK getEmprestimoPK() {
        return emprestimoPK;
    }

    public void setEmprestimoPK(EmprestimoPK emprestimoPK) {
        this.emprestimoPK = emprestimoPK;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
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
        hash += (emprestimoPK != null ? emprestimoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprestimo)) {
            return false;
        }
        Emprestimo other = (Emprestimo) object;
        if ((this.emprestimoPK == null && other.emprestimoPK != null) || (this.emprestimoPK != null && !this.emprestimoPK.equals(other.emprestimoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.Emprestimo[ emprestimoPK=" + emprestimoPK + " ]";
    }
    
}
