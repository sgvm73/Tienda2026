/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.sergiovm73.tienda2025;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import javax.swing.plaf.metal.MetalIconFactory;
import org.w3c.dom.html.HTMLFontElement;

/**
 *
 * @author 1dawd24
 */
public class Tienda2026 {
    private ArrayList <LineaPedido> LineaPedido=new ArrayList();
    private ArrayList <Pedido> pedidos;
    private Scanner sc=new Scanner(System.in);
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
    
    
    public Tienda2026(){
        pedidos=new ArrayList();
        clientes=new HashMap();
        articulos=new HashMap();
    }

    public static void main(String[] args) {
        
        
        Tienda2026 t = new Tienda2026();
        t.cargaDatos();
        t.menu();
    }
    
    //para ordenar por carpetas usar "fcom" + tab
    //<editor-fold defaultstate="collapsed" desc="cargaDatos">
    

    public void cargaDatos(){
       clientes.put("80580845T",new Cliente("80580845T","ANA ","658111111","ana@gmail.com"));
       clientes.put("36347775R",new Cliente("36347775R","LOLA","649222222","lola@gmail.com"));
       clientes.put("63921307Y",new Cliente("63921307Y","JUAN","652333333","juan@gmail.com"));
       clientes.put("02337565Y",new Cliente("02337565Y","EDU","634567890","edu@gmail.com"));
              //put es keyset y new... es .value
              
              /*TODOS LOS .STREAM: 
              
              .filter()
              .sorted()
              .forEach(a->System.out.println(a))
              

*/
       articulos.put("1-11",new Articulo("1-11","RATON LOGITECH ST ",14,15));
       articulos.put("1-22",new Articulo("1-22","TECLADO STANDARD  ",9,18));
       articulos.put("2-11",new Articulo("2-11","HDD SEAGATE 1 TB  ",16,80));
       articulos.put("2-22",new Articulo("2-22","SSD KINGSTOM 256GB",9,70));
       articulos.put("2-33",new Articulo("2-33","SSD KINGSTOM 512GB",0,200));
       articulos.put("3-11",new Articulo("3-22","HP LASERJET HP800 ",2,200));
       articulos.put("3-22",new Articulo("3-22","EPSON PRINT XP300 ",5,80));
       articulos.put("4-11",new Articulo("4-11","ASUS  MONITOR  22 ",5,100));
       articulos.put("4-22",new Articulo("4-22","HP MONITOR LED 28 ",5,180));
       articulos.put("4-33",new Articulo("4-33","SAMSUNG ODISSEY G5",12,580));
       
       LocalDate hoy = LocalDate.now();
       pedidos.add(new Pedido("80580845T-001/2025",clientes.get("80580845T"),hoy.minusDays(1), new ArrayList<>
        (List.of(new LineaPedido("1-11",3),new LineaPedido("4-22",3)))));                                                                                                                                                               
       pedidos.add(new Pedido("80580845T-002/2025",clientes.get("80580845T"),hoy.minusDays(2), new ArrayList<>
        (List.of(new LineaPedido("4-11",3),new LineaPedido("4-22",2),new LineaPedido("4-33",4)))));
       pedidos.add(new Pedido("36347775R-001/2025",clientes.get("36347775R"),hoy.minusDays(3), new ArrayList<>
        (List.of(new LineaPedido("4-22",1),new LineaPedido("2-22",3)))));
       pedidos.add(new Pedido("36347775R-002/2025",clientes.get("36347775R"),hoy.minusDays(5), new ArrayList<>
        (List.of(new LineaPedido("4-33",3),new LineaPedido("2-11",3)))));
       pedidos.add(new Pedido("63921307Y-001/2025",clientes.get("63921307Y"),hoy.minusDays(4), new ArrayList<>
        (List.of(new LineaPedido("2-11",5),new LineaPedido("2-33",3),new LineaPedido("4-33",2)))));
}
    //</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Menus">
    

    public void menu(){
        
int opcion;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
            System.out.println("\t\t\t\t1 - ARTICULOS");
            System.out.println("\t\t\t\t2 - CLIENTES");
            System.out.println("\t\t\t\t3 - PEDIDOS");
           

 
            System.out.println("\t\t\t\t9 - SALIR");
            
            opcion=sc.nextInt();
            sc.nextLine();      
            switch (opcion){
                case 1:{
                    menuArticulos();
                    break;
                }    
                case 2:{
                    menuClientes();
                    break;
                } 
                case 3:{
                    menuPedidos();
                    break;
                } 
                
               
            }
        }while (opcion != 9 );
}
    
    
    
    
    public void menuArticulos(){
        
        int opcion;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
            System.out.println("\t\t\t\t1 - ALTA");
            System.out.println("\t\t\t\t2 - BAJA");
            System.out.println("\t\t\t\t3 - REPOSICIÓN");
            System.out.println("\t\t\t\t4 - LISTADOS");
            
 
            System.out.println("\t\t\t\t9 - SALIR");
            
            opcion=sc.nextInt();
            sc.nextLine();      
            switch (opcion){
                case 1:{
                    altaArticulos();
                    break;
                }    
                case 2:{
                    bajaArticulos();
                    break;
                } 
                case 3:{
                    reposicionArticulos();
                    break;
                } 
                case 4:{
                    listarArticulos();
                    break;
                } 
                
               
            }
        }while (opcion != 9 );
        
        
    }
    
    
    public void menuClientes(){
        
        int opcion;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
            System.out.println("\t\t\t\t1 - ALTA");
            System.out.println("\t\t\t\t2 - BAJA");
            System.out.println("\t\t\t\t3 - MODIFICACIÓN DATOS");
            System.out.println("\t\t\t\t4 - LISTADOS");
            
 
            System.out.println("\t\t\t\t9 - SALIR");
            
            opcion=sc.nextInt();
            sc.nextLine();      
            switch (opcion){
                case 1:{
                    altaClientes();
                    break;
                }    
                case 2:{
                    bajaClientes();
                    break;
                } 
                case 3:{
                    modificarClientes();
                    break;
                } 
                case 4:{
                    listarClientes();
                    break;
                } 
                
               
            }
        }while (opcion != 9 );
        
        
    }
    
    
    public void menuPedidos(){
        
        int opcion;
        do{
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE OPCIONES\n");
            System.out.println("\t\t\t\t1 - NUEVO PEDIDO");
            System.out.println("\t\t\t\t2 - LISTADO DE PEDIDOS");
            System.out.println("\t\t\t\t3 - ");
            
            
            
            
 
            System.out.println("\t\t\t\t9 - SALIR");
            
            opcion=sc.nextInt();
            sc.nextLine();      
            switch (opcion){
                case 1:{
                    nuevoPedido();
                    break;
                }
                case 2:{
                    listadoPedido();
                    break;
                } 
                case 3:{
                    
                    break;
                }
                

                
               
            }
        }while (opcion != 9 );
        
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Articulos">
    

    private void altaArticulos(){
     String idArticulo,descripcion,existencias,pvp;
     
     sc.nextLine();
        System.out.println("ALTA DE NUEVO ARTICULO");
        idArticulo=sc.next();
        do{
            System.out.println("idArticulo (IDENTIFICADO): ");
            idArticulo=sc.next();
        }while(!idArticulo.matches("[1-6][-][0-9][0-9]") || articulos.containsKey(idArticulo));
        System.out.println("DESCRIPCION");
        descripcion=sc.nextLine();
        
        do{
            System.out.println("EXISTENCIAS:");
            existencias=sc.next();
        }while(!MetodosAux.esInt(existencias));
        
        do{
            System.out.println("PVP: ");
            pvp=sc.next();
        }while(!MetodosAux.esDouble(pvp));
       
        Articulo a = new Articulo(idArticulo, descripcion, Integer.parseInt(existencias), Double.parseDouble(pvp));
        articulos.put(idArticulo, a);
        
        System.out.println("- Articulo añadido -");
    }
    private void bajaArticulos(){
        
    }
    private void reposicionArticulos(){
        
    }
    private void listarArticulos(){
        System.out.println("");
        for (Articulo a:articulos.values()){
            System.out.println(a);
        }
        
        
        //pasar los articulos a arraylist:
        
        ArrayList<Articulo> articulosAux = new ArrayList(articulos.values());
        System.out.println("");
        articulosAux.stream().forEach(a->System.out.println(a));
        
        
        ArrayList<Articulo> articulosAux2 = new ArrayList(articulosAux);
        System.out.println("");
        articulosAux2.stream().forEach(a->System.out.println(a));

        
            
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Clientes">
    

    private void altaClientes(){
        
    }
    private void bajaClientes(){
        
    }
    private void modificarClientes(){
        
    }
    private void listarClientes(){
        System.out.println("");
        for (Cliente c:clientes.values()){
            System.out.println(c);  
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Pedido">
private void listadoPedido(){
        System.out.println("");
        for (Pedido p:pedidos){
            System.out.println(p +"- Total:"+totalPedido(p));
          
       
        }
        System.out.println("\n");
        System.out.println("Pedidos de menor a mayor");
        pedidos.stream().sorted(Comparator.comparing(p->totalPedido(p))).forEach(p->System.out.println(p + "- Total: "+totalPedido(p)));
        
                pedidos.stream().filter(p->totalPedido(p)>1000).sorted(Comparator.comparing(p->totalPedido(p))).forEach(p->System.out.println(p + "- Total: "+totalPedido(p)));

    }
    
    private String generaIdPedido(String idCliente){ 
        String nuevoId; //vble String para ir construyendo un nuevo idPedido
         //Calculamos en la vble contador cuantos pedidos tiene el cliente aportado
        int contador = 0;  
        for (Pedido p: pedidos){
            if (p.getClientePedido().getIdCliente().equalsIgnoreCase(idCliente)){
                contador++;
            }
        }
        contador++; //sumamos a contador 1 para el nuevo pedido
        nuevoId= idCliente + "-" + String.format("%03d", contador) + "/" + LocalDate.now().getYear();
        return nuevoId;
    }
    
    private void stock (String idArticulo, int unidades) throws StockCero, StockInsuficiente {
        if (articulos.get(idArticulo).getExistencias()==0){
            throw new StockCero("0 unidades disponibles de: " 
                    + articulos.get(idArticulo).getDescripcion());
        }
        if (articulos.get(idArticulo).getExistencias() < unidades){
            throw new StockInsuficiente("Sólo hay " + articulos.get(idArticulo).getExistencias() 
                    + " unidades disponibles de: " + articulos.get(idArticulo).getDescripcion());
        }
    }
    
    private void nuevoPedido() {
        
        String idCliente;
        do{
            System.out.println("DNI (id) CLIENTE:");
            idCliente=sc.nextLine().toUpperCase();
            if (!clientes.containsKey(idCliente)){
                System.out.println("No es cliente de la tienda."
                        + " Desea darse de alta o compra como invitado");
            }
        }while (!MetodosAux.validarDNI(idCliente));
        
        ArrayList <LineaPedido> cestaCompra =new ArrayList();
        String idArticulo;
        int unidades=0;
        System.out.print("\nTecle el ID del artículo deseado (FIN para terminar la compra)");
        idArticulo=sc.next();
        while (!idArticulo.equalsIgnoreCase("FIN")){
            System.out.print("\nTeclea las unidades deseadas: ");
            unidades=sc.nextInt();

            try {
                stock(idArticulo, unidades);
                cestaCompra.add(new LineaPedido(idArticulo,unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());
                System.out.println("Las quieres (SI/NO)");
                String respuesta=sc.next();
                if (respuesta.equalsIgnoreCase("SI")){
                    cestaCompra.add(new LineaPedido(idArticulo,articulos.get(idArticulo).getExistencias()));
                }
            }
            System.out.print("\nTeclee el ID del artículo deseado (FIN para terminar la compra)");
            idArticulo=sc.next();
        }
        if (!cestaCompra.isEmpty()){
            System.out.println("Este es tu pedido");
            double totalPedido=0;
            double totalLinea=0;
            for (LineaPedido l:cestaCompra){
                totalLinea=l.getUnidades()*articulos.get(l.getIdArticulo()).getPvp();
                 totalPedido+=totalLinea;       
                System.out.println( l.getIdArticulo()+"-"+articulos.get(l.getIdArticulo()).getDescripcion() + " - " + l.getUnidades() + " - " + articulos.get(l.getIdArticulo()).getPvp() + " - "  + totalLinea)  ;
            }
            System.out.println("\t\t\t\tTotal: " + totalPedido);
            System.out.println("Procedemos con la compra (SI/NO) "); 
            String respuesta=sc.next();
            if (respuesta.equalsIgnoreCase("SI")){
                pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente),
                LocalDate.now(), cestaCompra));
                for (LineaPedido l:cestaCompra){
                    articulos.get(l.getIdArticulo()).setExistencias(articulos.get(l.getIdArticulo()).getExistencias()-l.getUnidades());
                }
            }
        }         
    }
    
    
    private double totalPedido (Pedido p){
        
        
        double totalPedido=0;
        for (LineaPedido l: p.getCestaCompra()){
            
             totalPedido+=l.getUnidades()*articulos.get(l.getIdArticulo()).getPvp();
             
            
        }
        return totalPedido;

       
    }
    //ordenar los pedidos por total de mayor a menos y viceversa cons streams

   
    
            
    //</editor-fold>
    
    
    
 
         
}
