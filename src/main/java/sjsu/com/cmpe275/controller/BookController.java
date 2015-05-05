package sjsu.com.cmpe275.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjsu.com.cmpe275.Model.BookModel;
import sjsu.com.cmpe275.Model.PostModel;
import sjsu.com.cmpe275.Model.UserModel;
import sjsu.com.cmpe275.entity.Appuser;
import sjsu.com.cmpe275.entity.Book;
import sjsu.com.cmpe275.entity.Post;
import sjsu.com.cmpe275.service.BookService;


@Controller
public class BookController
{
   private static Logger _logger = Logger.getLogger(BookController.class);
   
   @Autowired
   private BookService _repo;
   
  
   @RequestMapping(value = "/welcome", method = RequestMethod.GET)
   public ModelAndView welcome() throws Exception
   {
      //_repo.indexBooks();

      ModelAndView mav = new ModelAndView("hello");
      mav.addObject("message", "Welcome to Papa Pustak Bhandar!");
      return mav;
   }
   
   
   @RequestMapping(value = "/Mywishlist", method = RequestMethod.GET)
   public ModelAndView mywishList() throws Exception
   {
	   
	   List<Post> allFound = _repo.listallBooks();
	   List<PostModel> postModels = new ArrayList<PostModel>();
	   
	   for (Post p : allFound)
	      {
	         PostModel pm = new PostModel();
	         pm.setISBN(p.getISBN());
	         pm.setDescription(p.getDescription());
	         pm.setTitle(p.getTitle());
	         pm.setPrice(p.getPrice());
	         pm.setDate(p.getDate());
	         
	         postModels.add(pm);
	      }

	   ModelAndView mav = new ModelAndView("Mywishlist");
	      mav.addObject("wishlist", postModels);
	      return mav;
   }

   @RequestMapping(value = "/addBook", method = RequestMethod.GET)
   public ModelAndView addBookPage()
   {
      ModelAndView mav = new ModelAndView("addBook", "command", new BookModel());
      return mav;
   }
   
   @RequestMapping(value = "/wantBook", method = RequestMethod.GET)
   public ModelAndView wantBookPage()
   {
      ModelAndView mav = new ModelAndView("wantBook", "command", new PostModel());
      return mav;
   }
   
   @RequestMapping(value = "/addBookToDB", method = RequestMethod.POST)
   public ModelAndView addBookToDB(
      @ModelAttribute("BookModel")
      BookModel bookInfo
   ) throws Exception
   {
      _logger.info(bookInfo.getISBN());
      _logger.info(bookInfo.getTitle());
      _logger.info(bookInfo.getDescription());
      
      
      _repo.addBookToDB(
         bookInfo.getISBN(),
         bookInfo.getDescription(),
         bookInfo.getTitle()
      );
      
      ModelAndView mav = new ModelAndView("done");
      mav.addObject("message", "Add book to DB successfully");
      return mav;
   }
   
   @RequestMapping(value = "/addwantPost", method = RequestMethod.POST)
   public ModelAndView addwantPosttoDB(
      @ModelAttribute("postinfo")
      PostModel postinfo
   ) throws Exception
   {
      _logger.info(postinfo.getISBN());
      _logger.info(postinfo.getTitle());
      _logger.info(postinfo.getDescription());
      _logger.info(postinfo.getDate());
      
      
      _repo.addwantPosttoDB(
         postinfo.getISBN(),
         postinfo.getDescription(),
         postinfo.getTitle(),
         postinfo.getPrice(),
         postinfo.getDate()
      );
      
     Post post = new Post();
     java.util.Date dateNow = post.getDate();
      
      ModelAndView mav = new ModelAndView("donePost");
            
      return mav;
   }

   
   @RequestMapping(value = "/search", method = RequestMethod.GET)
   public ModelAndView searchPage()
   {
      ModelAndView mav = new ModelAndView("search");
      return mav;
   }

   @RequestMapping(value = "/doSearch", method = RequestMethod.POST)
   public ModelAndView search(
      @RequestParam("searchText")
      String searchText
   ) throws Exception
   {
      List<Book> allFound = _repo.searchForBook(searchText);
      List<BookModel> bookModels = new ArrayList<BookModel>();
      
      for (Book b : allFound)
      {
         BookModel bm = new BookModel();
         bm.setISBN(b.getISBN());
         bm.setDescription(b.getDescription());
         bm.setTitle(b.getTitle());
         
         bookModels.add(bm);
      }
      
      ModelAndView mav = new ModelAndView("foundBooks");
      mav.addObject("foundBooks", bookModels);
      return mav;
   }
}