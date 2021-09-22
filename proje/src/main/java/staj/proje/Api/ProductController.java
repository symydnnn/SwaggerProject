package staj.proje.Api;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import staj.proje.Business.IProductService;
import staj.proje.Entities.Product;

@RestController
@RequestMapping("/api/products") 
@Api(value=" Product Rest Service")
@ApiModel(value="ProductApi")
public class ProductController {

	private IProductService productService;
	 
	@Autowired
	public ProductController(IProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	@ApiOperation(value="Ürün sıralama")
	public List<Product> getAll(){
		return productService.getAll(); //Tüm ürünleri listeler
		
	}
	
	@GetMapping("/getByProductName")
	@ApiOperation(value="Bu isimdeki ürünü getirme")
	public List<Product> getByProductName(@RequestParam ("productName") String productName){
		return productService.getByProductName(productName);  //Ürünü ismine göre arar
	}
	@GetMapping("/getByProductNameAndCategory_CategoryId")
	@ApiOperation(value="Bu isimdeki ve bu Kategori id deki ürünü getirme")
	public List<Product> getByProductNameAndCategory_CategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		return productService.getByProductNameAndCategory_CategoryId(productName,categoryId);  //Ürünü id ve kategorideki ürünü arar ve düzenler.
	}
	
	@GetMapping("/getByProductNameStartsWith")
	@ApiOperation(value="Bu isimdeki ve bu Kategori id deki ürünü getirme")
	public List<Product> getByProductNameStartsWith(@RequestParam("productName") String productName){
		return productService.getByProductNameStartsWith(productName);  //Baslangıc adına göre sıralar
	}
	@PutMapping("/update")
	@ApiOperation(value="Ürün güncelleme")
	public void update(@RequestBody Product product){
		 productService.update(product);  //Kayıtlı olan ürünü günceller	
	}

	@PostMapping("/add")
	@ApiOperation(value="Ürün ekleme")
	public void add(@RequestBody Product product){
		 productService.add(product); //Ürün kaydı oluşturur
	}
	@DeleteMapping("/delete")
	@ApiOperation(value="Ürün silme")
	public void delete(@RequestParam ("productId") Product productId){
		 productService.delete(productId);  //Kayıtlı olan ürünü siler :: ERROR 500 Hatası
	}
}
