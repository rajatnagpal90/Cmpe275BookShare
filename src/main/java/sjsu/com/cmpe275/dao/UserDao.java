package sjsu.com.cmpe275.dao;
 
import sjsu.com.cmpe275.entity.User;
 
public interface UserDao {
 
	User findByUserName(String username);
 
}