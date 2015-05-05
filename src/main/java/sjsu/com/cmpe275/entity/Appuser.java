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
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Indexed
@Table(name = "appuser", catalog = "bookshare")
public class Appuser {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private int userId;
	
	@Column(name = "username")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String username;
	
	@Column(name = "email")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String email;
	
	@Column(name = "role")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String role;
	
	@Column(name = "password")
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	

}
