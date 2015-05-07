package sjsu.com.cmpe275.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "Image", catalog = "bookshare")
public class Image {
	
	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID;
	
	@Column(name = "ISBN")
	private String ISBN;
	 
	@Column(name = "ImageName")
	private String ImageName;

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String imageName) {
		ImageName = imageName;
		System.out.println("image.java"+imageName);
	}
	 
}
