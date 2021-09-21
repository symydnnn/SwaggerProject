package staj.proje.Business;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import staj.proje.Entities.Product;


public interface IProductService { 
	
	List<Product> getAll();
	
	List<Product> getByProductName(String productName);

	List<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory(String productName, int categoryId);

	List<Product> getByCategoryIn(List<Integer> categories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);
	
	List<Product> getByNameAndCategory(String productName, int categoryId);
	
	void add(Product product);
	
	void update(Product product);
	
	//@Query(value = "delete from Product p where product_id=:product_id", nativeQuery = true)
	void delete(Product id);

	
}
