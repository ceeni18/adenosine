package smacrobs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.FitbitDetailsServiceImpl;
import service.FitbitDetailsServiceIntf;
import service.FitbitOAuthService;
import service.FitbitOAuthServiceIntf;
import service.UserProfileServiceImpl;
import service.UserProfileServiceIntf;
import static org.mockito.Mockito.*;

import com.web.controller.MainController;

import junit.framework.TestCase;
 
public class MainControllerTest extends TestCase {
	
	UserProfileServiceIntf mockUserProfileService;
	FitbitDetailsServiceIntf mockFitbitDetailsService;
	FitbitOAuthServiceIntf mockFitbitOAuthService;
	MainController controller;
	
	
	 @Before
	  public void setUp() {
	    MockitoAnnotations.initMocks( this );
	    //Setup
		 mockUserProfileService = mock(UserProfileServiceImpl.class);
		 mockFitbitDetailsService = mock(FitbitDetailsServiceImpl.class);
		 mockFitbitOAuthService = mock(FitbitOAuthService.class);
		 controller = new MainController(mockUserProfileService,mockFitbitDetailsService, mockFitbitOAuthService);
		    
	  }
 
	@Test
	public void testIndex() {
		//Call  controller method
		 ModelAndView result = controller.index();
       
        //assert
	    assertNotNull(result);
	    assertEquals("index",result.getViewName());
	}
	
	@Test
	public void testRedirectToFitbit() throws IOException{
		String result = controller.redirectToFitbit();
		assertNotNull(result);
	}
	
	@Test
	public void testRedirectToContact() throws IOException{
		ModelAndView result = controller.redirectToContact();
		assertNotNull(result);
		assertEquals("contact",result.getViewName());
	}
	
	@Test
	public void testRedirectToSensor() throws IOException{
		ModelAndView result = controller.redirectToSensor();
		assertNotNull(result);
		assertEquals("senso",result.getViewName());
	}
	
	@Test
	public void testRedirectToFit() throws IOException{
		ModelAndView result = controller.redirectToFit();
		assertNotNull(result);
		assertEquals("fitbit",result.getViewName());
	}
	
	@Test
	public void testRedirectErr() throws IOException{
		ModelAndView result = controller.redirectErr();
		assertNotNull(result);
		assertEquals("Error",result.getViewName());
	}

	
	/*@Test
	public void testSaveTiSensor() {
		//Mockito.verify(mockUserProfileService).UpdateTiSensorId("abc", "2nf");
		String result = controller.saveTiSensor("", null);
		assertNotNull(result);
 
}
	
	@Test
	public void testLocalRedirect() {
		HttpSession session = null;
		//String result = controller.localRedirect(session);
		//assertNotNull(result);
	}*/
	
	 //testRedirectFromFitbit 
	
	//testDash board
	
	@Test
	public void testTisensor(){
		ModelAndView result = controller.tisensor();
		assertNotNull(result);
		assertEquals("TiSensor",result.getViewName());
	}
	
	@Test
	public void testMedical(){
		ModelAndView result = controller.medical();
		assertNotNull(result);
		assertEquals("Medical",result.getViewName());
	}
	
}
	
