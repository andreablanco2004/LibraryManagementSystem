public class Patron implements Runnable {
    private Library library; // La biblioteca donde el patrón realizará las operaciones
    private String name;     // Nombre único del patrón

    public Patron(Library library, String name) {
        this.library = library;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            // Simulando un patrón que pide un libro y luego lo devuelve
            String bookToBorrow = "Libro" + (int) (Math.random() * 10);  // Un título aleatorio
            if (library.borrowBook(bookToBorrow)) {
                Thread.sleep((int) (Math.random() * 1000));  // Simula tiempo de lectura
                library.returnBook(bookToBorrow);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
