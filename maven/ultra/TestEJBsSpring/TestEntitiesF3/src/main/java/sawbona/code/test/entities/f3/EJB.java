/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbona.code.test.entities.f3;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author isaac
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "EJB.findAll",
    query = "select o from EJB o")
})
@Table(name = "EJB")
public class EJB implements Serializable {

    @Id
    @SequenceGenerator(name = "EJB_Gen", sequenceName = "SEQ_EJB",
    allocationSize = 1)
    @GeneratedValue(generator = "EJB_Gen",
    strategy = GenerationType.SEQUENCE)
    @Column(name = "EJB_ID", nullable = false)
    private long id;
    @Column(name = "ejbnombre")
    private String ejbName;
    @Column(name = "ejbtiempo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ejbtiempo;

    /**
     * Constructor.
     */
    public EJB() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the ejbName
     */
    public String getEjbName() {
        return ejbName;
    }

    /**
     * @param ejbName the ejbName to set
     */
    public void setEjbName(String ejbName) {
        this.ejbName = ejbName;
    }

    /**
     * @return the ejbtiempo
     */
    public Date getEjbtiempo() {
        return ejbtiempo;
    }

    /**
     * @param ejbtiempo the ejbtiempo to set
     */
    public void setEjbtiempo(Date ejbtiempo) {
        this.ejbtiempo = ejbtiempo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ejbName != null ? ejbName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EJB)) {
            return false;
        }
        EJB other = (EJB) object;
        if ((this.ejbName == null && other.ejbName != null) || (this.ejbName != null && !this.ejbName.equals(other.ejbName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sawbona.code.test.entities.f3.EJB[Nombre=" + ejbName + "]";
    }
}
