# magento-e-commerce
Magento-E-Commerce

Indication 

 => Main folder,  # - Folder,  ## - Package,  @ - Files

Hybrid Framwork (Data Driven Framework + PageObject Design Pattern using PageFactory)

=>src/java/main

##base - To keep all the common functionalities

##utility - To keep Listener.java,ExtentReport.java etc

##pageObject - In this we consider Each webpage as a Object For example : IndexPage.java, HomePage.java likewise...

##dataProvider - To read data from the excel file. ReadDataFromExelFile.java

##actionDriver - To keep all the common actions which we perfom on the webpage like click(), switchTo(), likewise...

=>src/java/test

##all test packages - In this area where we actually write test cases.

#screenshots - Here We store failed test cases screenshots

#driver - chromedriver.exe, firefox.exe etc.

#testData - Execl.xlsx

#configuration - config.properties file

@testNG-all.xml - all test cases 

@log4j.xml - To print log on console

@pom.xml - Hold all the dependencies and plugins

URL - http://live.techpanda.org/index.php/

01) Modules / Pages :=>

IndexPage,
Mobile List Page,
TV List Page,
Account Page,
My cart page + checkout page,
Register Page,
LogIn Page

02) Project Structure =>

src/java/main => 

base,
utility,
pageObject,
actionDriver,
dataProvider

03) src/test/java =>

Test folder according to module/pages

****** IMPORTANT POINTS TO REMEMBER ******

1) After taking screenshot please update project structure to see captured screenshot

