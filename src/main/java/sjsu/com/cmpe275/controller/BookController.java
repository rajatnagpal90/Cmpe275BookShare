package sjsu.com.cmpe275.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sjsu.com.cmpe275.Model.BookModel;
import sjsu.com.cmpe275.Model.PostModel;
import sjsu.com.cmpe275.entity.Book;
import sjsu.com.cmpe275.entity.Image;
import sjsu.com.cmpe275.entity.Post;
import sjsu.com.cmpe275.entity.User;
import sjsu.com.cmpe275.service.BookService;

@Controller
public class BookController
{
   private static Logger _logger = Logger.getLogger(BookController.class);
   String loggedinuser = null;
   
   @Autowired
   private BookService _repo;
   
   private static String ACCOUNT_SID = "ACf73ce7345740ebac0c6fc7008bdb494c";
   private static String AUTH_TOKEN = "abb23d41fd23fa5a5fc703fd80ae3290";
   
   @RequestMapping(value = "/index", method = RequestMethod.GET)
   public ModelAndView FirstPage()
   {
      ModelAndView mav = new ModelAndView("index");
      return mav;
   }
   
   @RequestMapping(value = "/buyers", method = RequestMethod.GET)
   public ModelAndView buyer()
   {
      ModelAndView mav = new ModelAndView("buyers");
      return mav;
   }
   
   @RequestMapping(value = "/sellers", method = RequestMethod.GET)
   public ModelAndView seller()
   {
      ModelAndView mav = new ModelAndView("sellers");
      return mav;
   }
   
   @RequestMapping(value = "/upload", method = RequestMethod.POST)
   public ModelAndView upload()
   {
      ModelAndView mav = new ModelAndView("upload");
      return mav;
   }
   /*@RequestMapping(value = "/upload", method = RequestMethod.POST)
   public String uploadedImage(Model m, Image image)
   {
	 m.addAttribute("image", new Image());
	 System.out.println( "image: " +image.getImageName());
	 return "welcome";
   }*/
   
   
//   @RequestMapping(value = "/upload", method = RequestMethod.POST)
//   public ModelAndView uploadPage(
//		   @ModelAttribute("image")
//      Image image
//   ) throws Exception
//   {   System.out.println("HELLLLLLLLLLLLo");
//      _logger.info(image.getISBN());
//      _logger.info(image.getImageName());
//       System.out.println(""+image.getISBN());
//      
//      _repo.addImagetoDB(
//    	 image.getISBN(),
//    	 image.getImageName()
//      );
//    	      
//      ModelAndView mav = new ModelAndView("welcome");
//      return mav;
//   }
   
   @RequestMapping(value = "/uploadform", method = RequestMethod.GET)
   public ModelAndView upDonePage(Model model)
   {  
	  ModelAndView mav = new ModelAndView("uploadform","command", new Image());
      return mav;
   }
   
   @RequestMapping(value = "/books", method = RequestMethod.GET)
   public ModelAndView FPage()
   {
      ModelAndView mav = new ModelAndView("books");
      return mav;
   }
   
   @RequestMapping(value = "book/books", method = RequestMethod.GET)
   public ModelAndView bookPage()
   {
      ModelAndView mav = new ModelAndView("books");
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
   
   /*@RequestMapping(value = "/login", method = RequestMethod.GET)
   public ModelAndView LoginPage()
   {
      ModelAndView mav = new ModelAndView("login");
      return mav;
   }*/
   
//   @RequestMapping(value = "/register", method = RequestMethod.GET)
//   public ModelAndView RegisterPage()
//   {
//      ModelAndView mav = new ModelAndView("register");
//      return mav;
//   }
   
   @RequestMapping(value = "/bascket", method = RequestMethod.GET)
   public ModelAndView BasketPage()
   {
      ModelAndView mav = new ModelAndView("bascket");
      return mav;
   }
   
   @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
   public ModelAndView getBookPage(@PathVariable("id") String isbn )
   {
	  
      ModelAndView mav = new ModelAndView("book");
     
      mav.addObject("book",  _repo.getBookfromDB(isbn) );
      return mav;
   }
   
   @RequestMapping(value = "/book/buy", method = RequestMethod.GET)
   public ModelAndView getBuyPage()
   {
	   ModelAndView mav = new ModelAndView("buy");
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
	        return mav;
     
   }
   
   @RequestMapping(value = "/welcome", method = RequestMethod.GET)
   public ModelAndView welcome() throws Exception
   {
      _repo.indexBooks();

      ModelAndView mav = new ModelAndView("welcome");
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
   
   @RequestMapping(value = "/wantBook", method = RequestMethod.GET)
   public ModelAndView wantBookPage()
   {
      ModelAndView mav = new ModelAndView("wantBook", "command", new PostModel());
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
   
   @RequestMapping(value="/login", method = RequestMethod.GET)
   public String userLogin(Model m) {
      
       m.addAttribute("user",new User());
       return "login";
   }
   
   @RequestMapping(value="/login", method = RequestMethod.POST)
   public String fromLogout(Model m) {
      
       m.addAttribute("user",new User());
       return "login";
   }
   
   @RequestMapping(value="/sessionLogout", method = RequestMethod.GET)
   public String userLogout(HttpServletRequest request,HttpServletResponse response, User user , Model m, BindingResult result)
   {
   	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
   	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   	response.setDateHeader("Expires", 0); // Proxies.
   	
   	Cookie cookie = null;
   	   Cookie[] cookies = null;
   	   // Get an array of Cookies associated with this domain
   	   cookies = request.getCookies();
   	   if( cookies != null ){
   		   System.out.println("<h2> Found Cookies Name and Value</h2>");
   	      for (int i = 0; i < cookies.length; i++){
   	         cookie = cookies[i];
   	        // if((cookie.getName( )).compareTo("user") == 0 ){
   	            cookie.setMaxAge(0);
   	            response.addCookie(cookie);
   	           System.out.print("Deleted cookie: " + 
   	            cookie.getName( ) + "<br/>");
   	       //  }
   	         System.out.print("Name : " + cookie.getName( ) + ",  ");
   	         System.out.print("Value: " + cookie.getValue( )+" <br/>");
   	      }
   	  }else{
   		  System.out.println(
   	      "<h2>No cookies founds</h2>");
   	  }

   	
   	return "login";
   }

   
   
   @RequestMapping(value="/validating", method = RequestMethod.POST)
   public String validateLogin(HttpServletRequest request,HttpServletResponse response, User user , Model m, BindingResult result)  {
   	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
   	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
   	response.setDateHeader("Expires", 0); // Proxies.
   	
       m.addAttribute("user",new User());
       loggedinuser = user.getUsername();
       System.out.println(user.getUsername());
       System.out.println(user.getPassword());
       if (result.hasErrors()) {
   		System.out.print("abc");
   	    return "login";
   	}
       else{
    	   System.out.println("else entered");
    	   //search query
    	   m.addAttribute("username", user);
    	   return "redirect:/welcome";
       }
       
   }
   
    
 /*  @RequestMapping(value="/Registration", method = RequestMethod.GET)
   public String loggedIn(Model m){
	   
	  return "welcome";
   }
  */ 
   @RequestMapping(value="/register", method = RequestMethod.GET)
   public String regUser(Model m) {
   	System.out.println("registration called");
       m.addAttribute("user",new User());
       return "register";
   }

   @RequestMapping(value="/register", method = RequestMethod.POST)
   public String regLogin(Model m, User user) {
   	
       m.addAttribute("user",new User());
       return "register";
   }

   @RequestMapping(value="/registered", method=RequestMethod.POST)
   public String register(User user, Model m) 
   {
   	m.addAttribute("user",new User());
   	String User = "User";
   System.out.println(user.getUsername());
   	User us =	_repo.findByUserName(user.getUsername());
   	if(us!=null)
   	{
   		m.addAttribute("error", "User already exists. Please Sign in");
   		return "register";
   	}
   	else
   	{
   		_repo.addUserToDb(user);
   	}
   		
   	   return "welcome";
   }
}