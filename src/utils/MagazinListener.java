package utils;

public interface MagazinListener {
	
	// in momentul in care am adaugat un produs din alta fereastra, aceasta a notificat-o
	// pe aia principala sa reactualizeze lista
	
	public void listaProduseModificata();
}
