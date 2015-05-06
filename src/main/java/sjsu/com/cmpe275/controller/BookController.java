package sjsu.com.cmpe275.controller;

import java.util.ArrayList;
import java.util.List;




import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
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
   private static String ACCOUNT_SID = "ACf73ce7345740ebac0c6fc7008bdb494c";
   private static String AUTH_TOKEN = "abb23d41fd23fa5a5fc703fd80ae3290";
   @Autowired
   private BookService _repo;
   
   @RequestMapping(value = "/index", method = RequestMethod.GET)
   public ModelAndView FirstPage()
   {
      ModelAndView mav = new ModelAndView("index");
      return mav;
   }
   
   @RequestMapping(value = "/feedback", method = RequestMethod.GET)
   public ModelAndView FeedbackPage()
   {
      ModelAndView mav = new ModelAndView("feedback");
      return mav;
   }
   
   @RequestMapping(value = "/about", method = RequestMethod.GET)
   public ModelAndView AboutPage()
   {
      ModelAndView mav = new ModelAndView("about");
      return mav;
   }
   
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView LoginPage()
   {
      ModelAndView mav = new ModelAndView("login");
      return mav;
   }
   
   @RequestMapping(value = "/register", method = RequestMethod.GET)
   public ModelAndView RegisterPage()
   {
      ModelAndView mav = new ModelAndView("register");
      return mav;
   }
   
   @RequestMapping(value = "/bascket", method = RequestMethod.GET)
   public ModelAndView BasketPage()
   {
      ModelAndView mav = new ModelAndView("bascket");
      return mav;
   }
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
       System.out.println("inside sendmessage");
        Message message = null;
        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("Body", "Book Available"));
	        params.add(new BasicNameValuePair("To", "+14086685916"));
	        params.add(new BasicNameValuePair("From", "+12679534000"));
	        MessageFactory messageFactory = client.getAccount().getMessageFactory();
	        try {
				message = messageFactory.create(params);
				System.out.println("message sent");
				//m.addAttribute("successmessage","Bike access code is sent to your contact details");
			} catch (TwilioRestException e) {
				e.printStackTrace();
			}
       
      ModelAndView mav = new ModelAndView("foundBooks");
      mav.addObject("foundBooks", bookModels);
      return mav;
   }
}