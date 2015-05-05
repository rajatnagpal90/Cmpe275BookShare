
package sjsu.com.cmpe275.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "Postwantedbook", catalog = "bookshare")
public class Post implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Column(name = "post_id")
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	 private int postId;
	
	 @Column(name = "title")
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	 private String title;
	 
	 @Column(name = "price")
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	 private double price;
	 
	 @Column(name = "ISBN")
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	 private String ISBN;

	 @Column(name = "description")
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	 private String description;
	 
	 @Column(name = "author")
	 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	 private String author;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 @Column(name = "date")
	 @Field(index=Index.YES,analyze=Analyze.YES, store=Store.NO)
	 private Date date;
	 
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

