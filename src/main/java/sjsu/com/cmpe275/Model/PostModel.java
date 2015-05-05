package sjsu.com.cmpe275.Model;

import java.util.Date;

public class PostModel {
	
	 private int postId;
	
	 private String title;
	 
	 private double price;
	 
	 private String ISBN;

	 private String description;
	 
	 private String author;
	 
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
