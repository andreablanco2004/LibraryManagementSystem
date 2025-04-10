import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<String> availableBooks = new ArrayList<>();

    public Library() {
        // Añadir algunos libros a la biblioteca para la prueba
        availableBooks.add("Libro1");
        availableBooks.add("Libro2");
        availableBooks.add("Libro3");
    }

    public synchronized boolean borrowBook(String bookTitle) {
        if (availableBooks.contains(bookTitle)) {
            availableBooks.remove(bookTitle);
            System.out.println(Thread.currentThread().getName() + " ha tomado prestado el libro: " + bookTitle);
            return true;  // Aquí estaba el problema, faltaba un 'return true'
        } else {
            System.out.println("El libro no está disponible: " + bookTitle);
            return false;  // Se completa el retorno en caso de que el libro no esté disponible
        }
    }

    public synchronized void returnBook(String bookTitle) {
        availableBooks.add(bookTitle);
        System.out.println(Thread.currentThread().getName() + " ha devuelto el libro: " + bookTitle);
    }
}
