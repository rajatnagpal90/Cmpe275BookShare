
package sjsu.com.cmpe275.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "Postwantedbook", catalog = "bookshare")
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Column(name = "post_id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int postId;
	
	 @Column(name = "title")
	 private String title;
	 
	 @Column(name = "price")
	 private double price;
	 
	 @Column(name = "ISBN")
	 private String ISBN;

	 @Column(name = "description")
	 private String description;
	 
	 @Column(name = "author")
	 private String author;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "date")
	 private Date date;
	 
	 @ManyToOne
	 private Seller seller;
	 
	 public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getPostId() {
			return postId;
		}

		public void setPostId(int postId) {
			this.postId = postId;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getISBN() {
			return ISBN;
		}

		public void setISBN(String iSBN) {
			ISBN = iSBN;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public Date getDate() {
			return new Date();
		}

		public void setDate(Date date) {
			this.date = date;
		}

}

