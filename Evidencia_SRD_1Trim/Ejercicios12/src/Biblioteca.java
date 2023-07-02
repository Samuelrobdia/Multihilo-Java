import java.util.LinkedList;
import java.util.Queue;

public class Biblioteca {
    
    private Queue<Libro> colaLibros;

    public Biblioteca() {
        
        colaLibros = new LinkedList<Libro>();
        Libro libro1 = new Libro(1, "Libro1", "Autor1");
        colaLibros.add(libro1);
    
    }

    public synchronized boolean hayLibrosDisponibles() {
        
        if(colaLibros.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }else {
            notify();
            return true;
        }
    }

    public synchronized Libro sacaLibro(){
        notify();
        return colaLibros.remove();
    }

    public synchronized void devolverLibro(Libro libro){
        notify();
        colaLibros.add(libro);
    }


    
}
