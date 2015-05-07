package sjsu.com.cmpe275.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "seller", catalog = "bookshare")
public class Seller {

   @Id
   @Column(name = "seller_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int sellerId;
	
   @Column(name = "seller_name")
	private String sellerName;
	
   @Column(name = "seller_email")
   private String sellerEmail;
	
 
   @OneToMany
	private Collection<Book> book = new ArrayList<Book>();
   
   @OneToMany
	private Collection<Post> rbook = new ArrayList<Post>();

   public Collection<Post> getRbook() {
	return rbook;
    }

   public void setRbook(Collection<Post> rbook) {
	this.rbook = rbook;
   }

 public int getSellerId() {
	return sellerId;
    }

   public void setSellerId(int sellerId) {
	this.sellerId = sellerId;
   }

   public String getSellerName() {
	return sellerName;
    }

   public void setSellerName(String sellerName) {
	this.sellerName = sellerName;
   }

    public String getSellerEmail() {
	return sellerEmail;
    }

   public void setSellerEmail(String sellerEmail) {
	this.sellerEmail = sellerEmail;
    }

    public Collection<Book> getBook() {
	return book;
    }

    public void setBook(Collection<Book> book) {
 	this.book = book;
     }
	
	

}
