package sjsu.com.cmpe275.dao;
 
import java.util.ArrayList;
import java.util.List;
 
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import sjsu.com.cmpe275.entity.User;
 
@Repository
public class UserDaoImpl implements UserDao {
 
	@Autowired
	private SessionFactory sessionFactory;
	
	
 
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {
 
		List<User> users = new ArrayList<User>();
 
		users = sessionFactory.getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username)
			.list();
 
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
 
	}
 
}