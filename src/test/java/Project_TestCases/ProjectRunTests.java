package Project_TestCases;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.openqa.selenium.support.PageFactory;
//import pageObjects.ContactUsPage;
//import pageObjects.FooterAreaPage;
//import pageObjects.HeaderAreaPage;
//import pageObjects.OurStoresPage;
//import pageObjects.RegistrationPage;
//import pageObjects.SearchAreaPage;
//import pageObjects.SearchToShoppingCartPage;
//import pageObjects.SignInPage;
import projectUtilities.BaseFunction;
		
@FixMethodOrder(MethodSorters.NAME_ASCENDING) 

public class ProjectRunTests extends BaseFunction
{
	@Test
	public void test01_StoreLocator() throws Exception
	{
		Osf.OpenOneOfTheStoresLocationCheckingAddressAndDialog();
	}

	@Test
	public void test02_SignIn() throws Exception 
	{
	 	Hef.ClickOnSignIn();
		fsf.LoginToPage();
	}

	@Test
	public void test03_SendContactUsForm() throws Exception 
	{
		Hef.ClickOnContactUs();
		Cuf.SendContactFormAmessage();
		Hef.ClickOnLogoSite();
	}
	/*
	 * This Test case check the field Search of the site.
	 * After searching for an item adding the Item to the Shopping cart 
	 * and verify that details are correct!! 
	 */
	@Test
	public void test04_SearchForAnItemAndAddToCart() throws Exception 
	{
		Saf.SearchForAnItemAndAddToShoppingCart();
	}
	
	

}
