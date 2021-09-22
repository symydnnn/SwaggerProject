package staj.proje.Business;

import java.util.List;
import staj.proje.cekirdek.Result;
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
	
	Result add(Product product);
	
	Result delete(Product id);

	Result update(Product product);
	
}
