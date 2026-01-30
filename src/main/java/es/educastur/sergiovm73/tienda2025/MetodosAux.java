/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.educastur.sergiovm73.tienda2025;

/**
 *
 * @author 1dawd24
 */
class MetodosAux {
    /**
     * Comprueba si un numero "s" es Int
     * 
     * @param s numero a teclear
     * @return true si es Int, false si no lo es
     */
    public static boolean esInt(String s) {
        int n;
        try {
            n = Integer.parseInt(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Comprueba si un numero "s" es Double
     * 
     * @param s numero a teclear
     * @return true si es Double, false si no lo es
     */
    public static boolean esDouble(String s) {
        double n;
        try {
            n = Double.parseDouble(s);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
       
    public static boolean validarDNI(String dni) {
        // Verificar que el DNI tiene un formato válido
        if (dni.isBlank() || !dni.matches("\\d{8}[A-HJ-NP-TV-Z]")) {
            return false;
        }

        // Extraer el número y la letra del DNI
        String numeroStr = dni.substring(0, 8);
        char letra = dni.charAt(8);

        // Calcular la letra correspondiente al número del DNI
        char letraCalculada = calcularLetraDNI(Integer.parseInt(numeroStr));

        // Comparar la letra calculada con la letra proporcionada y devolver
        // el resultado de la comparación TRUE/FALSE
                      
        return letra == letraCalculada; 
        
        /* devuelve TRUE si la letra del DNI y la calculada según la fórmula COINCIDEN 
        SE PUEDE DEVOLVER ASI EL RESULTADO DE UNA COMPARACIÓN. Se devuelve TRUE si la comparación
        se cumple y FALSE sino. Es equivalente a poner:
          if (letra == letraCalculada) {
              return TRUE;
           } else {
              return FALSE;   
           }
        */
    }
    
    private static char calcularLetraDNI(int numero) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.charAt(numero % 23);
    } 
    
    
    /* EJEMPLO DE UTILIZACIÓN validarDNI()
        
        do{
            System.out.println("DNI CLIENTE:");
            dniT=sc.nextLine().toUpperCase();
        }while (!validarDNI(dniT));
    */
    
            
      
 
    
}
