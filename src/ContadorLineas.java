import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ContadorLineas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos la palabra
        System.out.print("Introduce la palabra que quieres buscar: ");
        String palabraObjetivo = sc.nextLine().toLowerCase();

        int contador = 0;


        try (BufferedReader lector = new BufferedReader(new FileReader("datos.txt"))) {

            String linea;
            while ((linea = lector.readLine()) != null) {
                if (linea.toLowerCase().contains(palabraObjetivo)) {
                    contador++;
                }
            }

            System.out.println("La palabra '" + palabraObjetivo + "' aparece en " + contador + " líneas.");

        } catch (IOException e) {
            System.out.println("Error: No se pudo leer el archivo " +e.getMessage());
        } finally {
            sc.close();
        }
    }
}
