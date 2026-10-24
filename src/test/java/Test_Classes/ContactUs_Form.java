package Test_Classes;

import Base_Package.Base_Test;
import PageObjectModels.Contactus_Page;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ContactUs_Form extends Base_Test
{
    @Test
    public void verificationOfContactusForm()
    {
        Contactus_Page contactus_page=new Contactus_Page(driver);
        contactus_page.verificationOfContactUsPage("Siya","abc@gmail.com","Regarding order cancellation","I want to cancel my order as it comes defective");

    }

}
