
public class PrincipalBiblioteca {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
                
        Usuario user1 = new Usuario("Usuario1",biblioteca);
        Usuario user2 = new Usuario("Usuario2",biblioteca);
        Usuario user3 = new Usuario("Usuario3",biblioteca);

        user1.start();
        user2.start();
        user3.start();
        

    }
}
