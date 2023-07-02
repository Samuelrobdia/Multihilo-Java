
public class MostrarDatos {
    public static void main(String[] args) throws Exception {
        
        
        if(args.length != 2){
            System.out.println("Tienes que poner dos argumentos");
        
        }else {
            
            try {

                String nombre = args[0];
                int nacimiento = Integer.parseInt(args[1]);
    
                System.out.println("Nombre: "+ nombre +"\n" +  
                "Edad: " + (2022 - nacimiento));
                
            } catch (NumberFormatException e) {
                System.out.println("El año de nacimiento tiene que ser un entero");
            }
        }


    }
}
