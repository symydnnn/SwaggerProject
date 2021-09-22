package staj.proje.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value="productNesne",description = "Model")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	@ApiModelProperty(value="productId",example = "1")
	@JsonProperty
	private int productId;
	
	@Column(name="product_name")
	@ApiModelProperty(value="productName",example = "Chai")
	@JsonProperty
	private String productName;
	
	@Column(name="unit_price")
	@ApiModelProperty(value="productUnitPrice",example = "15")
	@JsonProperty
	private double unitPrice;
	
	@Column(name="units_in_stock")
	@ApiModelProperty(value="productUnitInStok",example = "20")
	@JsonProperty
	private short unitsInStok;
	
	@Column(name="quantity_per_unit")
	@ApiModelProperty(value="productQuantityPerUnit",example = "30")
	@JsonProperty
	private String quantityPerUnit;
	
	@ManyToOne()
	@JoinColumn(name="category_id")
 	@ApiModelProperty(value="categoryId",example = "1")
	@JsonProperty()
	private Category category;

}
