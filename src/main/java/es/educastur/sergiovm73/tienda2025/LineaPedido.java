/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.sergiovm73.tienda2025;

/**
 *
 * @author 1dawd24
 */
public class LineaPedido {
    
    private Articulo Articulo;
    private int unidades;

    public LineaPedido(Articulo Articulo, int unidades) {
        this.Articulo = Articulo;
        this.unidades = unidades;
    }

    public Articulo getArticulo() {
        return Articulo;
    }

    public void setArticulo(Articulo Articulo) {
        this.Articulo = Articulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return "LineaPedido{" + "Articulo=" + Articulo + ", unidades=" + unidades + '}';
    }


    


    
    
    
}
