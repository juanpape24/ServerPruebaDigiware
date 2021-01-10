/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author USUARIO
 */
public class ProductHelper {

    public ProductHelper() {
    }

    EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("com.mycompany_ServerD_war_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();

    public List<Producto> getProductos() {

        TypedQuery<Producto> consultaProductos = em.createNamedQuery("Producto.findAll", Producto.class);

        List<Producto> lista = consultaProductos.getResultList();

        return lista;
    }
    
    public Producto getProducto(String ref){
        
        TypedQuery<Producto> consultaProducto = em.createNamedQuery("Producto.findByReferencia", Producto.class);
        consultaProducto.setParameter("referencia", ref);
        Producto prod = consultaProducto.getSingleResult();
        return prod;
    }
}
