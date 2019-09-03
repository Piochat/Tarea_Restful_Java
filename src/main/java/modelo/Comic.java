/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author georg
 */
public class Comic {
    
    private int id;
    private String nombre;
    private String ruta;
    private String imgn;
    private int editorial;
    private int escritor;
    private int dibujante;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the imgn
     */
    public String getImgn() {
        return imgn;
    }

    /**
     * @param imgn the imgn to set
     */
    public void setImgn(String imgn) {
        this.imgn = imgn;
    }

    /**
     * @return the editorial
     */
    public int getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(int editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the escritor
     */
    public int getEscritor() {
        return escritor;
    }

    /**
     * @param escritor the escritor to set
     */
    public void setEscritor(int escritor) {
        this.escritor = escritor;
    }

    /**
     * @return the dibujante
     */
    public int getDibujante() {
        return dibujante;
    }

    /**
     * @param dibujante the dibujante to set
     */
    public void setDibujante(int dibujante) {
        this.dibujante = dibujante;
    }
    
}
