/**
 * 
 */
package shopManager;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;


import shopmanager.MyProduct;
import shopmanager.MyStockManager;
import shopmanager.Product;
import shopmanager.StockManager;


/**
 * @author isabo
 *
 */

public class MyStockManagerTest {

	StockManager underTest;
	String underTestAsString;
	
	@BeforeEach
	public void setup() {
		MyStockManager.getInstance().clean();
	}

	/**
	 * Test method for {@link shopmanager.MyStockManager#getInstance()}.
	 */
	@Test
	@Tag("unidad")
	@Tag("integracion")
	@DisplayName("Prueba del m�todo que devuelve la instancia �nica")
	public void testGetInstance() {
		underTest=MyStockManager.getInstance();
		underTestAsString=underTest.toString();
				
		assertNotNull(underTest,"getInstance no devuelve una referencia v�lida");
		assertEquals(underTest,MyStockManager.getInstance(),"getInstance debe devolver siempre la misma instancia");
	}

	/**
	 * Test method for {@link shopmanager.MyStockManager#addProduct(shopmanager.Product)}.
	 */
	@Test
	@Tag("integracion")
	@DisplayName("Prueba para el m�todo que a�ade un producto")
	public void testAddProduct() {
		Product product=new MyProduct("nuevoProducto",1);
	
		MyStockManager.getInstance().addProduct(product);
	
		assertEquals(product.toString(),MyStockManager.getInstance().searchProduct("nuevoProducto").toString(),"El objeto obtenido debe ser igual al introducido");
		assertEquals("nuevoProducto", MyStockManager.getInstance().searchProduct("nuevoProducto").getId(),"El id del producto recuperado no es el buscado");
		assertEquals(1, MyStockManager.getInstance().searchProduct("nuevoProducto").getNumber(),"El n�mero de unidades del producto recuperado no es el esperado");	
		
		MyStockManager.getInstance().addProduct(product);
		assertEquals(2, MyStockManager.getInstance().searchProduct("nuevoProducto").getNumber(),"Si a�ado un producto que ya estaba se a�ade el n�mero de unidades");	
	}

	/**
	 * Test method for {@link shopmanager.MyStockManager#searchProduct(java.lang.String)}.
	 */
	@Test
	@DisplayName("Prueba para el m�todo de b�squeda de un producto")
	public void testSearchProduct() {
		assertNull(MyStockManager.getInstance().searchProduct("noexiste"),"No debe encontrar un producto que no existe");
		Product product=new MyProduct("nuevoProducto",1);
		MyStockManager.getInstance().addProduct(product);
		assertEquals(product.toString(),MyStockManager.getInstance().searchProduct("nuevoProducto").toString(),"El objeto obtenido debe ser igual al introducido");
	}

}
