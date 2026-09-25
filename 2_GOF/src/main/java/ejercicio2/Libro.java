package ejercicio2;

public class Libro {
	private final String isbn;
	private final Autor autor;

	public Libro(String isbn, Autor autor) {
		this.isbn = isbn;
		this.autor = autor;
	}

	public String getISBN() {
		return isbn;
	}

	public Autor getAutor() {
		return autor;
	}
}
