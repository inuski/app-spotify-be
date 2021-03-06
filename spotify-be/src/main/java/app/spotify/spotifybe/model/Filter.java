package app.spotify.spotifybe.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the filters database table.
 * 
 */
@Entity
@Table(name="filters")
@NamedQuery(name="Filter.findAll", query="SELECT f FROM Filter f")
public class Filter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="description", length=70)
	private String description;

	private BigDecimal price;

	//bi-directional many-to-many association to Order
	@ManyToMany(mappedBy="filters")
	private List<Order> orders;

	public Filter() {
	}

	public Filter(int id, String description, BigDecimal price, List<Order> orders) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.orders = orders;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Filter [id=" + id + ", description=" + description + ", price=" + price + ", orders=" + orders + "]";
	}

}