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
public class EmprestimoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_livro")
    private int idLivro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_leitor")
    private int idLeitor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_emprestimo")
    @Temporal(TemporalType.DATE)
    private Date dataEmprestimo;

    public EmprestimoPK() {
    }

    public EmprestimoPK(int idLivro, int idLeitor, Date dataEmprestimo) {
        this.idLivro = idLivro;
        this.idLeitor = idLeitor;
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getIdLeitor() {
        return idLeitor;
    }

    public void setIdLeitor(int idLeitor) {
        this.idLeitor = idLeitor;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idLivro;
        hash += (int) idLeitor;
        hash += (dataEmprestimo != null ? dataEmprestimo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmprestimoPK)) {
            return false;
        }
        EmprestimoPK other = (EmprestimoPK) object;
        if (this.idLivro != other.idLivro) {
            return false;
        }
        if (this.idLeitor != other.idLeitor) {
            return false;
        }
        if ((this.dataEmprestimo == null && other.dataEmprestimo != null) || (this.dataEmprestimo != null && !this.dataEmprestimo.equals(other.dataEmprestimo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteca.jsf.entities.EmprestimoPK[ idLivro=" + idLivro + ", idLeitor=" + idLeitor + ", dataEmprestimo=" + dataEmprestimo + " ]";
    }
    
}
