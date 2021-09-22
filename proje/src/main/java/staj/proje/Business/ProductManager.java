package staj.proje.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import staj.proje.cekirdek.Result;
import staj.proje.cekirdek.SuccessResult;
import staj.proje.DataAcccess.IProductDal;
import staj.proje.Entities.Product;

@Service
public class ProductManager implements IProductService{
	
	private IProductDal productDal;

	@Autowired
	public ProductManager(IProductDal productDal) {
		super();
		this.productDal = productDal;
	}
	
	
	@Override
	@Transactional
	public List<Product> getAll() {
		return  productDal.findAll();
	}


	@Override
	@Transactional
	public List<Product> getByProductName(String productName) {
		  return (List<Product>) this.productDal.getByProductName(productName) ;
	}

	@Override
	@Transactional
	public List<Product> getByProductNameAndCategory_CategoryId(String productName, int categoryId) {
		return (List<Product>) this.productDal.getByProductNameAndCategory_CategoryId(productName, categoryId);
	}

	@Override
	@Transactional
	public List<Product> getByProductNameOrCategory(String productName, int categoryId) {
		return (List<Product>)this.productDal.getByProductNameOrCategory(productName, categoryId);
	}

	@Override
	@Transactional
	public List<Product> getByCategoryIn(List<Integer> categories) {
		return (List<Product>) this.productDal.getByCategoryIn(categories);
	}

	@Override
	@Transactional
	public List<Product> getByProductNameContains(String productName) {
		return (List<Product>)this.productDal.getByProductNameContains(productName);
	}

	@Override
	@Transactional
	public List<Product> getByProductNameStartsWith(String productName) {
		return (List<Product>) this.productDal.getByProductNameStartsWith(productName);
	}

	@Override
	@Transactional
	public List<Product> getByNameAndCategory(String productName, int categoryId) {
		return (List<Product>)this.productDal.getByNameAndCategory(productName, categoryId);
	}
	

	@Override
	@Transactional
	public Result update(Product product) {
		productDal.save(product);
		return new SuccessResult("Ürün Güncellendi.");
	}


	@Override
	public Result add(Product product) {  
		 this.productDal.save(product);
		 return new SuccessResult("Ürün Eklendi.");
	}
	
	
	@Override
	@Transactional
	public Result delete(Product productId) {
		this.productDal.delete(productId);
		return new SuccessResult("Ürün Eklendi.");	
	}

}
