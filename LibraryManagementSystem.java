public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        
        // Crear y ejecutar varios patrones en hilos
        for (int i = 0; i < 5; i++) {  // Suponiendo 5 patrones
            Patron patron = new Patron(library, "Patron" + i);
            Thread thread = new Thread(patron);
            thread.start();
        }
    }
}
