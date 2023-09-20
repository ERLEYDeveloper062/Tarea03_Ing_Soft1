package edu.software1;
/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        ConvertirCvsAJson convertidor = new ConvertirCvsAJson();
        convertidor.leerArchivo("estudiantes.csv");
    }
}
