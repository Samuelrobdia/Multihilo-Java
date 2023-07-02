
public class Libro {
    
    private int id;
    private String nombre;
    private String autor;
    
    public Libro(int id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }


    @Override
    public String toString() {
        return "Id: " + this.id + "\n" +
        "Nombre: "+ this.nombre + "\n" +
        "Autor: "+ this.autor;
    }


    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public String getAutor() {
        return autor;
    }
    
}
