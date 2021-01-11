/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Model.ProductHelper;
import Model.Producto;
import com.google.gson.Gson;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Juan Jose Parada
 */
@Path("producto")
public class ProductoResource {

    @Context
    private UriInfo context;

    ProductHelper productHelper = new ProductHelper();

    /**
     * Creates a new instance of ProductoResource
     */
    public ProductoResource() {

    }

    /**
     * Single Result
     *
     * @param ref
     * @return an json instance (java.lang.String in json format)
     */
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson(@QueryParam("ref") String ref) {
        Gson gson = new Gson();
        String json = "";
        if (ref==null) {
            json = gson.toJson(productHelper.getProductos());
        } else {
            json = gson.toJson(productHelper.getProducto(ref));
        }

        return json;
    }
    
}
