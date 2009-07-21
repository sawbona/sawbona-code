
package mx.com.sawbona.testing.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author jacob
 */
@Entity
public class ArchivoLab implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String nombreArchivo;

    /**
     * Get the value of nombreArchivo
     *
     * @return the value of nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Set the value of nombreArchivo
     *
     * @param nombreArchivo new value of nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    @Column(length=3145728)
    private byte[] bytes;

    /**
     * Get the value of bytes
     *
     * @return the value of bytes
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * Set the value of bytes
     *
     * @param bytes new value of bytes
     */
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ArchivoLab other = (ArchivoLab) obj;
        if ((this.nombreArchivo == null) ? (other.nombreArchivo != null) : !this.nombreArchivo.equals(other.nombreArchivo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.nombreArchivo != null ? this.nombreArchivo.hashCode() : 0);
        hash = 53 * hash + (this.bytes != null ? this.bytes.hashCode() : 0);
        return hash;
    }


    @Override
    public String toString() {
        return "mx.com.sawbona.testing.modelo.Archivo[Nombre del archivo= " + nombreArchivo + "]";
    }

}
