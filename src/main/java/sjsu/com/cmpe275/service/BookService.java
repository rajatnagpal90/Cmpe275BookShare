package sjsu.com.cmpe275.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sjsu.com.cmpe275.entity.Appuser;
import sjsu.com.cmpe275.entity.Book;
import sjsu.com.cmpe275.entity.Post;
import sjsu.com.cmpe275.entity.User;

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
         fullTextSession.createIndexer();
      }
      catch(Exception e)
      {
         throw e;
      }
   }
   
   @Transactional
   public void addBookToDB(String ISBN, String bookDescription, String title)
   {
	   Session session = mySessionFactory.getCurrentSession();
	      
	      Book book = new Book();
	 
	      //UUID x = UUID.randomUUID();
	      
	      Date dateNow = new Date();
	      //book.setId(x.toString());
	      book.setISBN(ISBN);
	      book.setDescription(bookDescription);
	      book.setTitle(title);
	      //book.setCreateDate(dateNow);
	      //book.setUpdateDate(dateNow);
	      
	      session.saveOrUpdate(book);
      
      
     
      
      //session.saveOrUpdate(book);
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
   
}
