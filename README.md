Personal Expense Management System
===================
Before executing this program, the user needs to set up the database by executing mysql statements in homeManager.sql under db folder. Our team used MySQL as the database management system. A complete list of program parameters can be found in file: mvc.ini. 

Program entrance is located at src/com/jida/clinet/main/ProgramEntrance.

A csv file with name "Expenses.csv" will be generated everytime a user has succesfully logged in, it will contain the list of products and all the past purchase records for that particular user. 

Below we provide some instructions on using this system:

1. Use the program entrance located at src/com/jida/clinet/main/ProgramEntrance
2. Use the following user account to login:   
      username: Andi  
      password: 0000  
   Or create a new account through mysql statment in database. 
3. Click on the product button on the upper left hand corner and the user will see a drop down menu. Click on "product". Interface will then display a list of all products and their corresponding categories. To add an item, a user should enter related product information and then click Insert. (Please make sure that the product number is not a duplicate of any other existing product numbers). A user can delete and update products in a similar manner. 
4. To enter purchase records, click Home Manager from the menu bar and select Fee Manager from the drop down menu. Now, a user should see a list of all personal expense records that the user has entered; empty panel if the user has not entered any records before. To create an expense record, first, enter all the related information, then click on Insert, the record will be added to the user account. A user can delete and update his/her expense history in a similar manner. 
5. Finally, to exit the system, a user can either click on the red cross on the upper right corner or click on Product from menu bar and select exit from there.
