/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.sergiovm73.tienda2025;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;


/**
 *
 * @author 1dawd24
 */
public class Tienda2026 implements Serializable{

    private ArrayList <Pedido> pedidos;
    private static final transient Scanner sc=new Scanner(System.in);
    private HashMap <String, Articulo> articulos;
    private HashMap <String, Cliente> clientes;
    
    
    public Tienda2026(){
        pedidos=new ArrayList();
        clientes=new HashMap();
        articulos=new HashMap();
        
    }

    public HashMap<String, Articulo> getArticulos() {
        return articulos;
    }

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }
    
    

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    

    public static void main(String[] args) {
        
        
        Tienda2026 t = new Tienda2026();
        t.cargaDatos();
        
        t.leerArticulosPorSeccion();
        //t.menu();
    }
    
    //para ordenar por carpetas usar "fcom" + tab
    //<editor-fold defaultstate="collapsed" desc="cargaDatos">
    

    public void cargaDatos(){
       
              //put es keyset y new... es .value
              
              /*TODOS LOS .STREAM: 
              
              .filter()
              .sorted()
              .forEach(a->System.out.println(a))
              

*/

        clientes.put("80580845T", new Cliente("80580845T", "ANA ", "658111111", "ana@gmail.com"));
        clientes.put("36347775R", new Cliente("36347775R", "LOLA", "649222222", "lola@gmail.com"));
        clientes.put("63921307Y", new Cliente("63921307Y", "JUAN", "652333333", "juan@gmail.com"));
        clientes.put("02337565Y", new Cliente("02337565Y", "EDU", "634567890", "edu@gmail.com"));

        articulos.put("1-11", new Articulo("1-11", "RATON LOGITECH ST ", 0, 15));
        articulos.put("1-22", new Articulo("1-22", "TECLADO STANDARD  ", 5, 18));
        articulos.put("2-11", new Articulo("2-11", "HDD SEAGATE 1 TB  ", 15, 80));
        articulos.put("2-22", new Articulo("2-22", "SSD KINGSTOM 256GB", 9, 70));
        articulos.put("2-33", new Articulo("2-33", "SSD KINGSTOM 512GB", 0, 200));
        articulos.put("3-11", new Articulo("3-11", "HP LASERJET HP800 ", 2, 200));
        articulos.put("3-22", new Articulo("3-22", "EPSON PRINT XP300 ", 5, 80));
        articulos.put("4-11", new Articulo("4-11", "ASUS  MONITOR  22 ", 5, 100));
        articulos.put("4-22", new Articulo("4-22", "HP MONITOR LED 28 ", 5, 180));
        articulos.put("4-33", new Articulo("4-33", "SAMSUNG ODISSEY G5", 12, 580));

        LocalDate hoy = LocalDate.now();
        pedidos.add(new Pedido("80580845T-001/2025", clientes.get("80580845T"), hoy.minusDays(1), new ArrayList<>(List.of(new LineaPedido(articulos.get("1-11"), 3), new LineaPedido(articulos.get("4-22"), 3)))));
        pedidos.add(new Pedido("80580845T-002/2025", clientes.get("80580845T"), hoy.minusDays(2), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-11"), 3), new LineaPedido(articulos.get("4-22"), 2), new LineaPedido(articulos.get("4-33"), 4)))));
        pedidos.add(new Pedido("36347775R-001/2025", clientes.get("36347775R"), hoy.minusDays(3), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-22"), 1), new LineaPedido(articulos.get("2-22"), 3)))));
        pedidos.add(new Pedido("36347775R-002/2025", clientes.get("36347775R"), hoy.minusDays(5), new ArrayList<>(List.of(new LineaPedido(articulos.get("4-33"), 3), new LineaPedido(articulos.get("2-11"), 3)))));
        pedidos.add(new Pedido("63921307Y-001/2025", clientes.get("63921307Y"), hoy.minusDays(4), new ArrayList<>(List.of(new LineaPedido(articulos.get("2-11"), 5), new LineaPedido(articulos.get("2-33"), 3), new LineaPedido(articulos.get("4-33"), 2)))));
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
    
    public String generaIdPedido(String idCliente){ 
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
    
    public void stock (Articulo a, int unidades) throws StockCero, StockInsuficiente {
        if (a.getExistencias()==0){
            throw new StockCero("0 unidades disponibles de: " 
                    + a.getDescripcion());
        }
        if (a.getExistencias() < unidades){
            throw new StockInsuficiente("Sólo hay " + a.getExistencias() 
                    + " unidades disponibles de: " + a.getDescripcion());
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
        idArticulo = sc.next();
        while (!idArticulo.equalsIgnoreCase("FIN")){
            System.out.print("\nTeclea las unidades deseadas: ");
            unidades = sc.nextInt();
            try {
                stock(articulos.get(idArticulo), unidades);
                cestaCompra.add(new LineaPedido(articulos.get(idArticulo),unidades));
            } catch (StockCero ex) {
                System.out.println(ex.getMessage());
            } catch (StockInsuficiente ex) {
                System.out.println(ex.getMessage());
                System.out.println("Las quieres (SI/NO)");
                String respuesta=sc.next();
                if (respuesta.equalsIgnoreCase("SI")){
                    cestaCompra.add(new LineaPedido(articulos.get(idArticulo),articulos.get(idArticulo).getExistencias()));
                }
            }
            System.out.print("\nTeclee el ID del artículo deseado (FIN para terminar la compra)");
            idArticulo=sc.next();
        }
        if (!cestaCompra.isEmpty()){
            System.out.println("Este es tu pedido");
            double totalPedido = 0;
            double totalLinea = 0;
            for (LineaPedido l : cestaCompra){
                totalLinea=l.getUnidades()* l.getArticulo().getPvp();
                 totalPedido+=totalLinea;       
                System.out.println( l.getArticulo() + " - " + l.getArticulo().getDescripcion() + " - " + l.getUnidades() + " - " + l.getArticulo().getPvp() + " - " + totalLinea);
            }
            System.out.println("\t\t\t\tTotal: " + totalPedido);
            System.out.println("Procedemos con la compra (SI/NO) "); 
            String respuesta=sc.next();
            if (respuesta.equalsIgnoreCase("SI")){
                pedidos.add(new Pedido(generaIdPedido(idCliente), clientes.get(idCliente),
                LocalDate.now(), cestaCompra));
                for (LineaPedido l : cestaCompra){
                    l.getArticulo().setExistencias(l.getArticulo().getExistencias() - l.getUnidades());
                    //ANTES: articulos.get(l.getIdArticulo()).setExistencias(articulos.get(l.getIdArticulo()).getExistencias()-l.getUnidades());
                }
            }
        }         
    }
    
    
    
    public double totalPedido (Pedido p){
        
        
        double totalPedido=0;
        for (LineaPedido l: p.getCestaCompra()){
            
             totalPedido+=l.getUnidades()*l.getArticulo().getPvp();
             
            
        }
        return totalPedido;

       
    }
    //ordenar los pedidos por total de mayor a menos y viceversa cons streams

   //Pedidos ordenados por fecha
    public void colecciones(){
        List<Pedido> pedidosOrdenadosFecha
                =pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getFechaPedido))
                .collect(Collectors.toList());
        
        pedidos.stream().forEach(p->System.out.println(p.getIDpedido()+" -"+p.getFechaPedido()));
        System.out.println("\n");
        pedidosOrdenadosFecha.stream().forEach(p->System.out.println(p.getIDpedido()));

    
    
    TreeMap<Double, Pedido> pedidosConTotales=new TreeMap();
    for (Pedido p:pedidos){
    pedidosConTotales.put(totalPedido(p), p);
}
    //muestra la nueva coleccion
        System.out.println("\n");
    for (Double total:pedidosConTotales.descendingKeySet()){
        System.out.println(pedidosConTotales.get(total).getIDpedido()+" - "+total);
    }
    
            
    //clientes ordenados por el total gastado
    
    //EJEMPLO 3
        //CREAR UN MAPA ORDENADO (TreeMap) CON LOS CLIENTES (values) Y EL TOTAL GASTADO POR CADA CLIENTE
        TreeMap<Double, Cliente> ventasPorCliente=new TreeMap();
        for (Cliente c:clientes.values()){
            ventasPorCliente.put(totalCliente(c),c);
        }
        
        //COMPROBACIÓN DE RESULTADOS .keySet mostrará de < a > los totales
        // .descendingKeySet() los mostrará de > a <
        System.out.println("\n");
        for (Double totCli:ventasPorCliente.keySet()){
            System.out.println(ventasPorCliente.get(totCli).getNombre()+ " - " + totCli);
        }
        
        //EJEMPLO 4
        //CREAR UNA COLECCION DE TIPO List CON LOS ARTICULOS DE CADA SECCION
        List <Articulo> perifericos, almacenamiento, monitores, impresoras;
        
        // CON STREAMS y .collect
        perifericos=articulos.values().stream()
                .filter(a->a.getIdArticulo().startsWith("1"))
                .collect(Collectors.toList());
        almacenamiento=articulos.values().stream()
                .filter(a->a.getIdArticulo().startsWith("2"))
                .collect(Collectors.toList());
        impresoras=articulos.values().stream()
                .filter(a->a.getIdArticulo().startsWith("3"))
                .collect(Collectors.toList());
        monitores=articulos.values().stream()
                .filter(a->a.getIdArticulo().startsWith("4"))
                .collect(Collectors.toList());
        
        //ESTILO CLÁSICO CON UN switch y .add
        for (Articulo a : articulos.values()) {
            switch (a.getIdArticulo().charAt(0)) {
                case '1':
                    perifericos.add(a);
                       break;
                case '2':
                    almacenamiento.add(a);
                    break;
                case '3':
                    impresoras.add(a);
                    break;
                case '4':
                    monitores.add(a);
                    break;
            }
        }
        //COMPROBACIÓN DE RESULTADOS
        System.out.println("\n" + perifericos);
        System.out.println("\n" + almacenamiento);
        System.out.println("\n" + impresoras);
        System.out.println("\n" + monitores);
        
        //EJEMPLO 5 - BORRADO EN COLECCIONES
        
        //BORRAR LOS ARTICULOS DE LA SECCIÓN IMPRESORAS
        articulos.values().removeIf(a->a.getIdArticulo().startsWith("3"));
        System.out.println("\n");
        articulos.values().stream()
                .forEach(a->System.out.println(a));
        


        //BORRAR LOS PEDIDOS DE MÁS DE 3 DÍAS DE ANTIGUEDAD
        //Las colecciones de tipo List no admiten removeIf()
        List <Pedido> pedidosAntiguos=pedidos.stream()
                .filter(p->p.getFechaPedido().isBefore(LocalDate.now().minusDays(3)))
                .collect(Collectors.toList()); 
        pedidos.removeAll(pedidosAntiguos);
        
        System.out.println(pedidos);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Examen">
    
    private void uno1 (){
        
        String seccion;
        System.out.println("\nSeccion a listar:");
        seccion=sc.next();
        System.out.println("Articulos de la sección");
        for (Articulo a:articulos.values()){
            
            if(a.getIdArticulo().startsWith(seccion)){
                
                System.out.println(a);
            }
        }
        
    
    }
     private void dos2 (){
         
         int contador1=0;
         int contador2=0;
         int contador3=0;
         int contador4=0;
        
         for (Articulo a: articulos.values()){
             if (a.getIdArticulo().startsWith("1")){
                 if(contador1==0){
                 System.out.println("PERIFERICOS");
                 contador1=contador1+1;
}
                 System.out.println(a);
                 
                 
             }
            if(a.getIdArticulo().startsWith("2")){
                if(contador2==0){
                System.out.println("ALMACENAMIENTO");
                contador2=contador2+1;
                }
                System.out.println(a);
                
                 
                     }
            if(a.getIdArticulo().startsWith("3")){ 
                if(contador3==0){
                System.out.println("IMPRESORAS");
                contador3=contador3+1;
                }
                System.out.println(a);
                
                 
                     }
            if(a.getIdArticulo().startsWith("4")){ 
                if(contador4==0){
                System.out.println("MONITORES");
                contador4=contador4+1;
                }
                System.out.println(a);
                
                 
                     }
             
         }
         
         
    }
      private void tres3 (){
          System.out.println("Intoduce el DNI del cliente: ");
          String dni=sc.next().toUpperCase();
          
          for(Pedido p:pedidos){
              if(p.getClientePedido().getIdCliente().equals(dni)){
                  
                  System.out.println(p+" - "+"Total: "+totalPedido(p));
                  
                                     
   
                
              }
          }
     
    }
      
      private int unidadesVendidas (String idArticulo){
          int total=0;
          
          for (Pedido p:pedidos){
              for (LineaPedido l: p.getCestaCompra()){
                  if(l.getArticulo().getIdArticulo().equalsIgnoreCase(idArticulo)){
                      total+=l.getUnidades();
                  }
              }
          }
          return total;
      }
       private void cuatro4 (){
           System.out.println("LISTADO ARTICULOS - UNIDADES VENDIDAS:");
           System.out.println("");
           ArrayList<Articulo> listaArticulos= new ArrayList<>(articulos.values());
           
           listaArticulos.stream().sorted(Comparator.comparing((Articulo a)->unidadesVendidas(a.getIdArticulo())).reversed()).forEach(a-> System.out.println(a.getDescripcion() + " VENDIDAS: "+unidadesVendidas(a.getIdArticulo())));
    }
        private void cinco5 (){
            
            ArrayList<Cliente> clientesSinPedido = new ArrayList<>();
            
            
            for (Cliente c : clientes.values()){
                boolean tienePedido = false;
                
                
                for (Pedido p:pedidos){
                    if(p.getClientePedido().getIdCliente().equalsIgnoreCase(c.getIdCliente())){
                        tienePedido =true;
                        break;
                    }
                }
                if (!tienePedido){
                    clientesSinPedido.add(c);
                }
               
            }
            System.out.println("Listado clientes sin pedido:");
            System.out.println(clientesSinPedido);
        
    }
    
//</editor-fold>

    
    //<editor-fold defaultstate="collapsed" desc="STREAMS">
    private void listadoStreams(){
        System.out.println("ARTICULOS DE MENOS DE 100 EUROS POR PRECIO DE - A");
        articulos.values().stream()
                .filter(a->a.getPvp()<100)
                .sorted(Comparator.comparing(a->a.getPvp()))
                .forEach(a->System.out.println(a));
        
        System.out.println("\n\nPEDIDOS ORDENADOS POR IMPORTE TOTAL");
       /*pedidos.stream()
                .sorted(Comparator.comparing(p -> totalPedido(p)))
                .forEach(p->System.out.println(p + "- Total: " totalPedido(p)));*/
                
       System.out.println("\n\nPEDIDOS DE MAS DE 1000 EUROS (filter) POR LA FECHA DEL PEDIDO");
                /*pedidos.stream().filter(p->totalPedido(p)>1000)
                        .sorted(Comparator.comparing(Pedido::getFechaPedido))
                        .forEach(p->System.out.println(p + "- Total: " + p.getFechaPedido());*/
                
        System.out.println("\n\n\nCONTABILIZAR LOS PEDIDOS DE UN DETERMINADO CLIENTE - PODRIA PEDIR NOMBRE O DNI POR TECLADO");
        long numPedidos = pedidos.stream()
                .filter(p -> p.getClientePedido().getIdCliente().equalsIgnoreCase("80580845T"))
                .count(); //LA VARIABLE COUNT ES PARA CONTABILIZAR LOS PEDIDOS DE UN CLIENTE.
                System.out.println(numPedidos); //para mostrar por consola el nº de pedidos del cliente
        
        //EL ESTILO TRADICIONAL SERÍA:
        System.out.println("\nCONTABILIZACION AL ESTILO TRADICIONAL:");
            long numPedidos2 = 0;
            for (Pedido p : pedidos) {
                if (p.getClientePedido().getIdCliente().equalsIgnoreCase("80580845T")) {
                    numPedidos2++;
                }
        }
                System.out.println(numPedidos2);
            
            
        System.out.println("CONTABILIZAR CUANTOS PEDIDOS HAY POR CLIENTE - PARA LAS AGRUPACIONES SON IDEALES");
        Map <Cliente, Long> numPedidosPorCliente =
                pedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getClientePedido, Collectors.counting())); //voy pedido a pedido (Pedido::) y pillo a los clientes y se agrupan.
                System.out.println(numPedidosPorCliente);
        
        System.out.println("\n\nTOTAL DE VENTAS POR PRODUCTO (groupingBy)");
        
        System.out.println("\n\n");
        for (Cliente c : clientes.values()) { /*Antes de bajar al flatmap, hacemos un filter.
                                                Si queremos pasar a LineaPedido tenemos que 
                                                hacer desde el ArrayList pedidos el flatMap.*/
            int unidades = pedidos.stream().filter(p -> p.getClientePedido().equals(c))
                    .flatMap(p -> p.getCestaCompra().stream()).filter(lp -> lp.getArticulo().equals(c)) //el ultimo c no es correcto, es otra variable
                    .mapToInt(LineaPedido::getUnidades).sum();
        }
        
        System.out.println("\n\nTODOS LOS ARTICULOS VENDIDOS");
        /*En este listado no hay repeticiones gracias al toSet, que quita todas las repeticiones
        que hayan.*/
        pedidos.stream().flatMap(p -> p.getCestaCompra().stream())
                .map(LineaPedido::getArticulo)
                .collect(Collectors.toSet());
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Unidades Vendidas">
    
    private int unidadesVendidas1(Articulo a){
        int c=0;
            for (Pedido p : pedidos) {
                for (LineaPedido l:p.getCestaCompra()){
               if(l.getArticulo().equals(a)){
                   c+=l.getUnidades();
               }
            }
            }
        return c;
    }
    
        private int unidadesVendidas2(Articulo a){
        int total = 0;
            for (Pedido p : pedidos) {
                total += p.getCestaCompra().stream().filter(l->l.getArticulo().equals(a))
                        .mapToInt(LineaPedido::getUnidades).sum();
            }
        return total;
    }
    
    private int unidadesVendidas3(Articulo a){
    return pedidos.stream()
            .flatMap(p -> p.getCestaCompra().stream())
            .filter(l -> l.getArticulo().equals(a))
            .mapToInt(LineaPedido::getUnidades)
            .sum();
}
    //Total gastado por un Cliente
    public double totalCliente(Cliente c){
        return pedidos.stream().filter(p-> p.getClientePedido().equals(c))
                .mapToDouble(p -> totalPedido(p)).sum();
    }
    
    //Importe Total de un Pedido
    public double totalPedido2(Pedido p)
    {
        return p.getCestaCompra().stream()
                .mapToDouble(l-> l.getArticulo().getPvp()
                    *l.getUnidades()).sum();
    }
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Examen2">
    
    private double gastoCliente(Cliente c){
        return pedidos.stream()
                .filter(p-> p.getClientePedido().equals(c))
                .mapToDouble(p-> totalPedido(p))
                .sum();
    }
    
    private void uno (){
        System.out.println("Clientes ordenados por gasto (De mayor a menor)");
        
        clientes.values().stream()
                .sorted(Comparator.comparing((Cliente c)-> gastoCliente(c)).reversed())
                .forEach(c->System.out.println(c+ " Total GASTADO " + gastoCliente(c)));
    }
    
    
    private void dos (){
       
        String seccion;
        System.out.println("\nSeccion a listar:");
        seccion=sc.next();
        System.out.println("Articulos de la sección");
        articulos.values().stream()
                .filter(a-> a.getIdArticulo().startsWith(seccion))
                .filter(a-> a.getExistencias()>0)
                .sorted(Comparator.comparing(Articulo::getPvp).reversed())
                .forEach(a-> System.out.println(a));
                
    }
    
    
    private void tres (){
        ArrayList<Articulo> articulosNoVendidos = new ArrayList<>();
        
        
                pedidos.stream()
                        .flatMap(p->p.getCestaCompra().stream())
                        .map(LineaPedido::getArticulo)
                        .collect(Collectors.toSet());
                System.out.println("");
                    
                }
            
        
        
    
    
    
    private void cuatro (){
        LocalDate fecha1= LocalDate.now();
        LocalDate fecha2 = fecha1.minusDays(5);
        double total = pedidos.stream()
                .filter(p->p.getFechaPedido().isAfter(fecha2))
                .mapToDouble(p->totalPedido(p))
                .sum();
        System.out.println("Total facturado entre "+fecha2 + " y "+ fecha1 + ": " + total);
    }
    
    
    private void cinco (){
        double total = pedidos.stream()
                .mapToDouble(p->totalPedido(p))
                .sum();
        long numPedidos = pedidos.stream().count();
        double media = 0;
        if (numPedidos>0){
            media=total/numPedidos;
        }
        System.out.println("Importe Medio Pedidos TIENDA: " +media);
    }
    

        
    
//</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Archivos">
    
    //file f
    
    private void guardaPedido() {
Scanner sc=new Scanner(System.in);
 try (BufferedWriter bw = new BufferedWriter(new FileWriter("Pedidos.txt",true))) {
     for (Pedido p:pedidos){
         bw.write(p.getIDpedido()+","+p.getClientePedido()+","+p.getFechaPedido()+","+p.getCestaCompra());
         bw.newLine();
         
 
 }
 } catch (IOException e) {
 System.out.println("No se ha podido escribir en el fichero");
 }
}
    private void guardaClientes(){
        //GUARDAMOS LOS CLIENTES LÍNEA A LÍNEA EN UN ARCHIVO .txt ESCRIBIENDO LOS DATOS SEGUN TENGAMOS DISPUESTO EN EL toString()
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/clientes.txt"))) {
            for (Cliente c:clientes.values()){
               bw.write(c.toString());
               bw.newLine();
            }
            System.out.println("Archivo D:/clientes.txt creado correctamente");                              
        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo D:/clientes.txt");
        }
        
         //GUARDAMOS LOS CLIENTES LÍNEA A LÍNEA EN UN ARCHIVO .csv CON LOS VALORES DE LOS ATRIBUTOS SEPARADOS POR ,        
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:/clientes.csv"))) {
            for (Cliente c:clientes.values()){
               bw.write(c.getIdCliente()+","+c.getNombre()+","+c.getTelefono()+","+c.getEmail()+"\n");
            }
            System.out.println("Archivo D:/clientes.csv creado correctamente");
        } catch (IOException e) {
            System.out.println("No se ha podido crear el archivo D:/clientes.txt");
        }
    }
    
    private void leeClientes(){
        
        //SIMPLEMENTE LEER LAS LÍNEAS DEL ARCHIVO clientes.txt Y MOSTRARLAS POR PANTALLA
        System.out.println("\nListado de Clientes directamente desde clientes.txt\n");
        try(Scanner scClientes=new Scanner(new File("D:/clientes.txt"))){
            while (scClientes.hasNextLine()){
                System.out.println(scClientes.nextLine());                                                              
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        
        //CREAR UNA NUEVA COLECCIÓN DE TIPO HASHMAP A PARTIR DEL ARCHIVO clientes.csv
        HashMap <String,Cliente> clientesAux = new HashMap();
        try(Scanner scClientes=new Scanner(new File("D:/clientes.csv"))){
            while (scClientes.hasNextLine()){
                String [] atributos = scClientes.nextLine().split("[,]");                                                              
                Cliente c=new Cliente(atributos[0],atributos[1],atributos[2],atributos[3]); 
                clientesAux.put(atributos[0], c);
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
        System.out.println("\nListado de Clientes del nuevo HashMap clientesAux\n");
        clientesAux.values().forEach(System.out::println);
    }
    
    public void guardaArticulosPorSeccion(){
        try (BufferedWriter bwPer = new BufferedWriter(new FileWriter("perifericos.csv"));
            BufferedWriter bwAlm = new BufferedWriter(new FileWriter("almacenamiento.csv"));
            BufferedWriter bwImp = new BufferedWriter(new FileWriter("impresores.csv"));
            BufferedWriter bwMon = new BufferedWriter(new FileWriter("monitores.csv"))) {
            
            for (Articulo a : articulos.values()) {
                switch (a.getIdArticulo().charAt(0)) {
                    case '1':
                        bwPer.write(a.getIdArticulo() + " - " +  a.getDescripcion() + " - " + a.getExistencias() + " - " + a.getPvp() + "\n");
                        break;
                    case '2':
                        bwAlm.write(a.getIdArticulo() + " - " +  a.getDescripcion() + " - " + a.getExistencias() + " - " + a.getPvp() + "\n");
                        break;
                    case '3':
                        bwImp.write(a.getIdArticulo() + " - " +  a.getDescripcion() + " - " + a.getExistencias() + " - " + a.getPvp() + "\n");
                        break;
                    case '4':
                        bwMon.write(a.getIdArticulo() + " - " +  a.getDescripcion() + " - " + a.getExistencias() + " - " + a.getPvp() + "\n");
                        break;
                }
            }
            System.out.println("Archivo creados correctamente");
        } catch (IOException e) {
            System.out.println("No se han podido crear los archivos");
            File f = new File("D:/perifericos.csv");
            f.delete();
            f = new File("D:/almacenamiento.csv");
            f.delete();
            f = new File("D:/impresoras.csv");
            f.delete();
            f = new File("D:/monitores.csv");
            f.delete();
        }
    }
    public void leerArticulosPorSeccion(){
         System.out.println("\nListado de artículos por sección\n");
        try(Scanner scPer = new Scanner(new File("perifericos.csv"));
           Scanner scAlm = new Scanner(new File("almacenamiento.csv"));
           Scanner scImp = new Scanner(new File("impresores.csv"));
           Scanner scMon = new Scanner(new File("monitores.csv"))){
            
            System.out.println("\n\nSECCION PERIFERICOS");
            while (scPer.hasNextLine()){
                System.out.println(scPer.nextLine());                                                
            }
            
            System.out.println("\n\nSECCION ALMACENAMIENTO");
            while (scAlm.hasNextLine()){
                System.out.println(scAlm.nextLine());                                       
            }
            
            System.out.println("\n\nSECCION IMPRESORES");
            while (scImp.hasNextLine()){
                System.out.println(scImp.nextLine());                                                        
            }
            
            System.out.println("\n\nSECCION MONITORES");
            while (scMon.hasNextLine()){
                System.out.println(scMon.nextLine());                                                              
            }
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }
    public void ExportarColecciones() {
        try (ObjectOutputStream oosArticulos = new ObjectOutputStream(new FileOutputStream("D:/articulos.dat"));
            ObjectOutputStream oosClientes = new ObjectOutputStream(new FileOutputStream("D:/clientes.dat"));
            ObjectOutputStream oosPedidos = new ObjectOutputStream (new FileOutputStream("D:/pedidos.dat"))) {
	   	   
            for (Articulo a : articulos.values()) {
                oosArticulos.writeObject(a);
            }
            for (Cliente c:clientes.values()) {
                oosClientes.writeObject(c);
            }
            for (Pedido p:pedidos){
                 oosPedidos.writeObject(p);
            }
            System.out.println("Copia de seguridad realizada con éxito.");
	    
        } catch (IOException ex) {
            System.out.println("No se han podido crear los archivos correctamente, "
                    + "revise unidades de almacenamiento e inténtelo de nuevo");
            File f=new File("D:/articulos.dat");
            f.delete();
            f=new File("D:/clientes.dat");
            f.delete();
            f=new File("D:/pedidos.dat");
            f.delete();
        } 
    }  
    
    public void importarColecciones() {
        /* HAY QUE LEER DESDE CADA ARCHIVO POR SEPARADO PORQUE SI INTENTAMOS METERLO TODO EN EL MISMO
        TRY-CATCH AL LLEGAR AL FINAL DEL PRIMER ARCHIVO SE PRODUCE LA EOFException Y SÓLO SE 
        LEERÍA BIEN EL PRIMER ARCHIVO, EL RESTO NO */ 
        
        try (ObjectInputStream oisArticulos = new ObjectInputStream(new FileInputStream("D:/articulos.dat"))){
            Articulo a;
            while ( (a=(Articulo)oisArticulos.readObject()) != null){
                 articulos.put(a.getIdArticulo(), a);
            } 
        } catch (FileNotFoundException e) {
                 System.out.println(e.toString());    
        } catch (EOFException e){
                System.out.println("Finalizada la lectura del archivo articulos.dat");
        } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.toString()); 
        } 
     
        try (ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream("D:/clientes.dat"))){
            Cliente c;
            while ( (c=(Cliente)oisClientes.readObject()) != null){
                 clientes.put(c.getIdCliente(), c);
            } 
	} catch (FileNotFoundException e) {
                 System.out.println(e.toString());    
        } catch (EOFException e){
                System.out.println("Finalizada la lectura del archivo clientes.dat");
        } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.toString()); 
        }
        
        try (ObjectInputStream oisPedidos = new ObjectInputStream(new FileInputStream("D:/pedidos.dat"))){
            Pedido p;
            while ( (p=(Pedido)oisPedidos.readObject()) != null){
                 pedidos.add(p);
            } 
	} catch (FileNotFoundException e) {
                 System.out.println(e.toString());    
        } catch (EOFException e){
                 System.out.println("Finalizada la lectura del archivo pedidos.dat");
        } catch (ClassNotFoundException | IOException e) {
                System.out.println(e.toString()); 
        }
    }   
    
    
//</editor-fold>
       

}

