package boot.rest.inmemory.models;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sku;
	private String name;
	private String description;
	private Integer length;
	private Integer width;
	private double height;
	private double weight;
	private Integer availability;
	private BigDecimal price;
	private String image;

	@Enumerated(EnumType.STRING)
	private Colors color;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryid", nullable = false)
	@JsonIgnore
	private Categories categories;
	private String brand;
	private String sellar;
	@Enumerated(EnumType.STRING)
	private Size size;
}