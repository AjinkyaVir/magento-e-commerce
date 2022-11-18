package loginfunctionality;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.magento.base.Base;
import com.magento.pageObject.DashBoardPage;
import com.magento.pageObject.IndexPage;
import com.magento.pageObject.MyAccountPage;
import com.magento.pageObject.MyWishListPage;
@Listeners(com.magento.utility.Listener.class)
public class TC_006_UserLogin extends Base{

	IndexPage indexPage;
	MyAccountPage myAccountPage;
	DashBoardPage dashBoardPage;
	MyWishListPage myWishListPage;
	
	@Test
	public void userLogin() {
		
		indexPage = new IndexPage();
		indexPage.clickAccountTab();
		indexPage.clickOnMyAccountLink();
		
		myAccountPage = new MyAccountPage();
		myAccountPage.enterEmailId("more.qwerr@gmail.com");
		myAccountPage.enterPassword("asdfghjkl");
		myAccountPage.clickOnLoginBtn();
		
		//indexPage.clickOnMobileTab();
		
		dashBoardPage = new DashBoardPage();
		dashBoardPage.clickOnWishlistPage();
		
		myWishListPage = new MyWishListPage();
		
		myWishListPage.clickOnAddToCartBtn();
		
	}
	
}
