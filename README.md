Personal Expense Management System
===================
This is a personal expense management system that aims to help users better keep track of their daily expenses. The system provides users with a straightforward and user-friendly interface for logging in, entering categorized expenses, updating individual product list, etc. Although users have to manually enter all records, we provide users with some convenient ways for entering the information, such as choosing products from a product list (which can be modified by users) and inserting dates by using a calendar. It also allows users to keep track of their personal spending without needing to share important financial information with parties that they do not trust. Besides, this system enables the users to export their expense history into a well-formatted csv file that allows them to access their expense records anywhere and anytime without the need for an internet connection.

Before running the system, a user will need to set up a database by executing mysql statements in “homeManager.sql” located under the db folder. Our team used MySQL as the database management system. A complete list of program parameters can be found in the file "mvc.ini". 

A csv file named “Expenses.csv" will be generated every time that a user has successfully logged in. The file contains a list of merchandise and all past spending records for that particular user. 

Below, we provide some instructions on using this system:

1. Program entrance is located at src/com/jida/client/main/ProgramEntrance
2. Use the following user account to login:   
      username: Andi  
      password: 0000  
   Or create a new user account through mysql statement in database. 
3. After logged in, click on "Product" from menu bar and select "Product" from the dropdown menu. The user interface will then display a list of all products, entered by the user and their corresponding categories. To add an item, a user needs to enter any related product information and then click "Insert". (Please make sure that the product number is not a duplicate of any other existing product numbers). A user can delete or update products in a similar manner. 
4. To create an expense record, click on "Home Manager" from menu bar and select "Fee Manager" from the dropdown menu. Enter any related information about the spending, and then click "Insert". A record will be added to the user account. A list of all personal expense records that the user has entered will be displayed in the panel below; an empty panel indicates that the user has not yet entered any records. Click on "Refresh" if needed. A user can delete or update his/her expense history in a similar manner. 
5. Finally, to exit the system, a user can either click on the red cross exit button or click on "Product" from menu bar and select "Exit" from there.
