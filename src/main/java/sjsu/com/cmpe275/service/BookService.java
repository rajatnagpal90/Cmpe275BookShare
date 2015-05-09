package sjsu.com.cmpe275.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjsu.com.cmpe275.entity.Book;
import sjsu.com.cmpe275.entity.Image;
import sjsu.com.cmpe275.entity.Post;
import sjsu.com.cmpe275.entity.User;
import sjsu.com.cmpe275.entity.Seller;

@Repository
@SuppressWarnings("unchecked")
public class BookService
{
	
   @Autowired
   private SessionFactory mySessionFactory;

   @Transactional
   public void indexBooks() throws Exception
   {
      try
      {
         Session session = mySessionFactory.getCurrentSession();
      
         FullTextSession fullTextSession = Search.getFullTextSession(session);
         fullTextSession.createIndexer().startAndWait();
      }
      catch(Exception e)
      {
         throw e;
      }
   }
   
   
   
   @Transactional
   public void addwantPosttoDB(String ISBN, String bookDescription, String title, double price,Date dateNow)
   {
	   Session session = mySessionFactory.getCurrentSession();
	      
	      Post post = new Post();
	 
	      //UUID x = UUID.randomUUID();
	      
	      dateNow = new Date();
	      //book.setId(x.toString());
	      post.setISBN(ISBN);
	      post.setDescription(bookDescription);
	      post.setTitle(title);
	      post.setPrice(price);
	      post.setDate(dateNow);
	      
	      
	      session.saveOrUpdate(post); 
   }
   
   @Transactional
   public List<Book> searchForBook(String searchText) throws Exception
   {
      try
      {
         Session session = mySessionFactory.getCurrentSession();
         
         FullTextSession fullTextSession = Search.getFullTextSession(session);

         QueryBuilder qb = fullTextSession.getSearchFactory()
           .buildQueryBuilder().forEntity(Book.class).get();
         org.apache.lucene.search.Query query = qb
           .keyword().onFields("ISBN", "title", "description")
           .matching(searchText)
           .createQuery();

         org.hibernate.Query hibQuery = 
            fullTextSession.createFullTextQuery(query, Book.class);

         List<Book> results = hibQuery.list();
         return results;
      }
      catch(Exception e)
      {
         throw e;
      }
   }
   
   @Transactional
   public List<Post> listallBooks() throws Exception
   {
      try
      {
    	  Session session = mySessionFactory.getCurrentSession();
    	  List<Post> booksPosted = session.createCriteria(Post.class).setResultTransformer
    			  (Criteria.DISTINCT_ROOT_ENTITY).list();
    	  return booksPosted;
      }
      catch(Exception e)
      {
         throw e;
      }
   }
   
   @Transactional
   public Book getBookfromDB(String bookISBN){
	   Query query = mySessionFactory.getCurrentSession().createQuery("from Book where ISBN = :uname").setParameter("uname", bookISBN);
	   //Book load= (Book ) mySessionFactory.getCurrentSession().get(Book.class, bookId);
	   return (Book)query.list().get(0) ;
   }
   
   @Transactional
   public Image getImagefromDB(String bookISBN){
	   Query query = mySessionFactory.getCurrentSession().createQuery("from Image where ISBN = :uname").setParameter("uname", bookISBN);
	   return (Image)query.list().get(0) ;
   }
   
   @Transactional
   public void addImagetoDB(String ISBN, String ImageName)
   {
	   Session session = mySessionFactory.getCurrentSession();
	      
	      Image img = new Image();
	     
	      img.setISBN(ISBN);
	      img.setImageName(ImageName);
	      
	      session.saveOrUpdate(img); 
   }
   
  
   
   @Transactional
   public void addBookToDB(String ISBN, String bookDescription, String title, User us)
   {
	   Session session = mySessionFactory.getCurrentSession();
	      
	      Book book = new Book();
	 
	      //UUID x = UUID.randomUUID();
	      System.out.println("addbooktodb called by seller:"+us.getUsername());
	      Date dateNow = new Date();
	      //book.setId(x.toString());
	      book.setISBN(ISBN);
	      book.setDescription(bookDescription);
	      book.setTitle(title);
	      
	     // book.setUser(us);
	     // book.setAuthor(us.getUsername());
	      //book.setCreateDate(dateNow);
	      //book.setUpdateDate(dateNow);
	      
	      session.saveOrUpdate(book);
      
      
     
      
      //session.saveOrUpdate(book);
   }
   
   @Transactional
   public void addUserToDb(String uname, int mobilenumber, String pwd, String confpwd)
   {
	   Session session = mySessionFactory.getCurrentSession();
   User user = new User();
   user.setUsername(uname);
   user.setPassword(pwd);

   user.setMobileNo(mobilenumber);
   user.setConfpassword(confpwd);// User user = new User();
   session.save(user);
   //UUID x = UUID.randomUUID();
   
  // Date dateNow = new Date();
   //book.setId(x.toString());
 //  book.setISBN(ISBN);
 //  book.setDescription(bookDescription);
//   book.setTitle(title);
   //book.setCreateDate(dateNow);
   //book.setUpdateDate(dateNow);
   
   }
   
   @Transactional
	public User findByUserName(String username, String password) {

		//List<User> users = new ArrayList<User>();
		//String pass = "rajat";
		Query query = mySessionFactory.getCurrentSession().createQuery("from User where username = :uname and password = :pwd").setParameter("uname", username).setParameter("pwd",password);
System.out.println("book service find by username entered username= "+username+"pwd="+password+" query size="+query.list().size());
		//UserEntity loadItem= (UserEntity ) sessionFactory.getCurrentSession().get(UserEntity.class, username);
		//Book load= (Book ) sessionFactory.getCurrentSession().get(Book.class, 1);
		if (query.list().size() > 0) {
			return (User)query.list().get(0);
		} else {
			return null;
		}

	}
   
}