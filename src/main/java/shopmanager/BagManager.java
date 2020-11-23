/**
 * 
 */
package shopmanager;

/**
 * @author isa
 *
 */
import java.util.List;

/**
 * @author Isabel Rom�n
 * Gestor de la cesta de la compra
 *
 */
public interface BagManager {
	/**
	 * 
	 * @param newProduct producto a a�adir, en el n�mero de unidades se indica cu�ntas unidades se a�aden
	 * debe verificar si hay en stock, si no no se a�aden y deber�a lanzar una excepci�n (to do)
	 * actualiza stock disminuyendo el n�mero de unidades a��adidas y el n�mero de unidades en la cesta
	 * @return true si se pudo añadir
	 */
	boolean addProduct(Product newProduct);
	/**
	 * 
	 * @param oldProduct producto a eliminar, se eliminan las unidades que se marquen, actualiza stock aumentando estas unidades liberadas
	 * @return newProduct, el producto, indicando el n�mero de unidades que quedan en la cesta
	 */
	Product lessProduct(Product oldProduct);
	/**
	 * 
	 * @param oldProduct
	 * Elimina completamente el producto, actualiza stock sumando las unidades liberadas
	 */
	void removeProduct(Product oldProduct);
	/**
	 * 
	 * @param oldProduct
	 * Elimina completamente el producto, actualiza stock sumando las unidades liberadas
	 */
	void removeProduct(String productId);
	
	/**
	 * 
	 * @return devuelve la cesta como una lista de productos
	 */
	List<Product> getBag();
	/**
	 * 
	 * @param producto a buscar
	 * @return el producto, con el n�mero de unidades del mismo, si es cero es que no estaba en la cesta
	 */
	Product findProduct(String productId);
	/**
	 * 
	 * @param producto a buscar
	 * @return el producto, con el n�mero de unidades del mismo, si es cero es que no estaba en la cesta
	 */
	Product findProduct(Product product);

}
