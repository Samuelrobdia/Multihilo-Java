import java.util.Random;

public class Usuario extends Thread{
    
    private Biblioteca biblioteca ;

    
    public Usuario(String nombreU,Biblioteca biblioteca) {
        
        this.biblioteca = biblioteca;
        this.setName(nombreU);
    }

    @Override
    public void run() {
        
        while(true){

            if(biblioteca.hayLibrosDisponibles()){
                 
                Libro libro1 = biblioteca.sacaLibro();
                System.out.println(this.getName() + "A sacado el libro: " + libro1.getNombre());
                int rd = new Random().nextInt(10) +2;
    
                try {
                    sleep(rd * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                biblioteca.devolverLibro(libro1);
                System.out.println(this.getName() + "A devuelto el libro: " + libro1.getNombre());
            }
        }
    }
    
}
