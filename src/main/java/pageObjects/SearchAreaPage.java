package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import com.relevantcodes.extentreports.LogStatus;

import projectUtilities.BaseFunction;
import projectUtilities.CommonFunction;

public class SearchAreaPage extends BaseFunction
{
	public String ShoppingCartAfter;
	public String ValuToreport;
	//CommonFunction cf = new CommonFunction();
	SearchToShoppingCartPage Stsc = new SearchToShoppingCartPage();

	@FindBy(how = How.ID,using = "search_query_top") 
	public WebElement SearchBar;

	@FindBy(how = How.NAME,using = "submit_search") 
	public WebElement SubmitButton; 

	@FindBy(how = How.CSS,using = "span.available-now")
	public WebElement InStock;

	@FindBy(how = How.LINK_TEXT,using = "Add to cart") 
	public WebElement AddToCartButton;

	@FindBy(how = How.CSS,using = "div#layer_cart") 
	public WebElement ShoppingCartDiv;

	@FindBy(how = How.CSS,using = "div.shopping_cart") 
	public WebElement ShoppingCart;

	@FindBy(how = How.CSS,using = "span.heading-counter")
	public WebElement SearchResult;

	@FindBy(how = How.CSS,using = "span.price.product-price")
	public WebElement ItemPrice;

	@FindBy(how = How.CSS,using = "li#list")
	public WebElement ListView;
	
	@FindBy(how = How.CSS,using = "h1.page-heading.product-listing")
	public WebElement SearchTerm;

	@FindBy(how = How.XPATH,using = "//*[@id='layer_cart']/div[1]/div[1]/span[1]") 
	public WebElement CloseDiv1;

	@FindBy(how = How.XPATH,using = "//*[@id='layer_cart']/div[1]/div[2]/h2/span[2]")
	public WebElement TitleShoppingDiv1;

	@FindBy(how = How.XPATH,using = "//*[@id='layer_cart']/div[1]/div[2]/div[1]/span") 
	public WebElement TotalProducts1;

	@FindBy(how = How.XPATH,using = "//*[@id='layer_cart']/div[1]/div[2]/div[2]/span") 
	public WebElement Totalshipping; 

	@FindBy(how = How.XPATH,using  = "//*[@id='layer_cart']/div[1]/div[2]/div[3]/span") 
	public WebElement TotalIncluds;

	@FindBy(how = How.XPATH,using = "//*[@id='layer_cart_product_title']") 
	public WebElement ProductTitle;

	@FindBy(how = How.CSS,using = "span.cross[title='Close window']") 
	public WebElement CloseDiv;

	public SearchAreaPage(WebDriver driver)
	{
		SearchAreaPage.driver = driver;
	}

	public void SearchForAnItemAndAddToShoppingCart() throws Exception
	{
		ValuToreport = SearchBar.getAttribute("placeholder");
		CommonFunction.SendKeyAction(SearchBar,TermSearch ,ValuToreport);
		ValuToreport = ShoppingCart.getText();
		CommonFunction.ClickOnElement(SubmitButton,ValuToreport);
		CommonFunction.waitToElement(SearchTerm);
		CommonFunction.SearchResult(SearchResult);
		if(!ListView.isSelected())
		{
			ListView.click();
		}

		if(InStock.isDisplayed())
		{
			ListView.click();
			ValuToreport = AddToCartButton.getText();
			CommonFunction.ClickOnElement(AddToCartButton,ValuToreport);
			CommonFunction.waitToElement(ShoppingCartDiv);
			try 
			{
				CommonFunction.verifyElementExist(TitleShoppingDiv1);
				CommonFunction.asserequal( TitleShoppingDiv1.getText(),TitleInShoppingDiv);
				CommonFunction.asserequal(TotalProducts1.getText(),ProductPrice);
				CommonFunction.asserequal(Totalshipping.getText(),ShippingPrice);
				CommonFunction.asserequal(TotalIncluds.getText(),TotalPrice);
				CommonFunction.asserequal(ProductTitle.getText(),ProductName);
				logger.info("The Elements are displayed on page!!");
				test.log(LogStatus.PASS, "The Elements: are displayed on page!!");
			} 
			catch (Exception e) 
			{
				logger.error("The title: "+ TitleShoppingDiv1.getText() +" doesn't exsit on page : "+ e.getMessage());
				test.log(LogStatus.FAIL,"The element: "+ TitleShoppingDiv1.getText() +" doesn't exsit on page!! see screenshot: "+ e.getMessage() +" "+ test.addScreenCapture(getScreenshot()));
				e.printStackTrace();
			}
		}

		CommonFunction.waitToElement(CloseDiv);
		String ValueSendToreport = CloseDiv.getAttribute("title");
		CommonFunction.ClickOnElement(CloseDiv,ValueSendToreport);
		try 
		{
			ShoppingCartAfter = ShoppingCart.getText();
			logger.info("The Element: "+ ShoppingCartAfter +" appear  !!");
			test.log(LogStatus.PASS, "The Element :"+ ShoppingCartAfter +" appear!!");
		}
		catch(Exception e) 
		{
			logger.error("Failed to get the text from "+ ShoppingCart +"  : "+ e.getMessage());
			test.log(LogStatus.FAIL,"Failed to get text from "+ ShoppingCart +"  :  see screenshot: "+ e.getMessage() +" "+ test.addScreenCapture(getScreenshot()));
		}
	}
}