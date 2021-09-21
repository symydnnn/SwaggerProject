package staj.proje.Entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "products"})
@Table(name="categories")
@ApiModel(value="categoryNesne",description = "Model")
public class Category {

	@Id
	@Column(name="category_id")
	@ApiModelProperty(value="categoryId",example = "1")
	@JsonProperty
	private int categoryId;
	
	@Column(name="category_name")
	@ApiModelProperty(value="categoryName",example = "Produce")
	@JsonProperty
	private String category_name;
	
	@OneToMany(mappedBy="category")
	@JsonProperty
	private List<Product> products;
	
}
