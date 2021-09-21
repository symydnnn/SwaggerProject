package staj.proje.DataAcccess;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import staj.proje.Entities.Product;


public interface IProductDal extends JpaRepository<Product, Integer> {
	@Query("select p from Product p")
	List<Product> getAll();
	
	///@Query("select p from Product p where productName=:productName")
	List<Product>  getByProductName(String productName);

	///@Query("select p from Product p where productName=:productName and categoryId=:categoryId")
	List<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	//@Query("select p from Product p where productName=:productName or categoryId=:categoryId")
	List<Product> getByProductNameOrCategory(String productName, int categoryId);

	//@Query("select c from Category c")
	List<Product> getByCategoryIn(List<Integer> categories);

	//@Query("select p from Product p where productName=:productName")
	List<Product> getByProductNameContains(String productName);

	
	List<Product> getByProductNameStartsWith(String productName);
	
	@Query("select p from Product p where productName=:productName and categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName, int categoryId);

	

	
}
