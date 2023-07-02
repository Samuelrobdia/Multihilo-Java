import java.io.File;
import java.io.IOException;

public class Lanzador {
    public static void main(String[] args) {
        
        ProcessBuilder proceso1 = new ProcessBuilder("java","MostrarDatos","Luis","2003");
        proceso1.directory(new File(".\\bin"));
        proceso1.redirectOutput(new File("datos1.txt"));
        proceso1.redirectError(new File("erroresDatos1.txt"));


        ProcessBuilder proceso2 = new ProcessBuilder("java","MostrarDatos","Pedro","2000");
        proceso2.directory(new File(".\\bin"));
        proceso2.redirectOutput(new File("datos2.txt"));
        proceso2.redirectError(new File("erroresDatos2.txt"));

        try {

            proceso1.start();
            proceso2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}
