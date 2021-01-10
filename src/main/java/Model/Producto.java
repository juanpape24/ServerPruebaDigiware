/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Jose Parada
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByReferencia", query = "SELECT p FROM Producto p WHERE p.referencia = :referencia"),
    @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByDescripcionCorta", query = "SELECT p FROM Producto p WHERE p.descripcionCorta = :descripcionCorta"),
    @NamedQuery(name = "Producto.findByImage", query = "SELECT p FROM Producto p WHERE p.image = :image"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "REFERENCIA")
    private String referencia;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 1000)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Size(max = 500)
    @Column(name = "DESCRIPCION_CORTA")
    private String descripcionCorta;
    @Size(max = 250)
    @Column(name = "IMAGE")
    private String image;
    @Size(max = 50)
    @Column(name = "PRECIO")
    private String precio;

    public Producto() {
    }

    public Producto(String referencia) {
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referencia != null ? referencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.referencia == null && other.referencia != null) || (this.referencia != null && !this.referencia.equals(other.referencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Producto[ referencia=" + referencia + " ]";
    }
    
}
