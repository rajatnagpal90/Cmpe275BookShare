package sjsu.com.cmpe275.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;


@Entity
@Indexed
@Table(name = "Book", catalog = "bookshare")
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;

 @Id
 @Column(name = "book_id")
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
 private int bookId;
 
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
 
 
 
/**
 * @return the iSBN
 */
public String getISBN() {
	return ISBN;
}
/**
 * @param iSBN the iSBN to set
 */
public void setISBN(String iSBN) {
	ISBN = iSBN;
}
/**
 * @return the description
 */
public String getDescription() {
	return description;
}
/**
 * @param description the description to set
 */
public void setDescription(String description) {
	this.description = description;
}
/**
 * @return the author
 */
public String getAuthor() {
	return author;
}
/**
 * @param author the author to set
 */
public void setAuthor(String author) {
	this.author = author;
}
public int getBookId() {
  return bookId;
 }
 public void setBookId(int bookId) {
  this.bookId = bookId;
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

 
}