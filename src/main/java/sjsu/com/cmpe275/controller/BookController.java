package sjsu.com.cmpe275.controller;

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
import sjsu.com.cmpe275.entity.Book;
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
      _repo.indexBooks();

      ModelAndView mav = new ModelAndView("hello");
      mav.addObject("message", "Welcome to Papa Pustak Bhandar!");
      return mav;
   }

   @RequestMapping(value = "/addBook", method = RequestMethod.GET)
   public ModelAndView addBookPage()
   {
      ModelAndView mav = new ModelAndView("addBook", "command", new BookModel());
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