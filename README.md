Personal Expense Management System
===================
Before executing the program, first, user needs to execute mysql statements in homeManager.sql under db folder. The team used MySQL as the database management system. 

Program entrance is located at src/com/jida/clinet/main/ProgramEntrance

The complete list of program parameters can be found in file: mvc.ini

A csv file with name "Expenses.csv" will be generated everytime a user is succesfully logged in, it will contain the list of products and all the past purchase records for that particular user. 

Here is an example of how you can use this system:

1. Use the program entrance located at src/com/jida/clinet/main/ProgramEntrance
2. Use the following user account to login: 
      username: Huiqing; 
      password: 0000
3. Click on the product button on the left right corner and then you will see a drop down menu, click on product and you will see a list of all the products and their corresponding categories. If you want to add an item, you can enter the product information and then click Insert. (Please make sure that the product number is not a duplicate of the number of any existing products.) You can delete and update the products in the same manner. 
4. If you want to enter purchase records, click on the Home Manager button and then click on Fee Manager in the drop down menu. Then you will see a list of all the purchase records that belong to your account. If you do not have any yet, enter the purchase information and click on Insert, the record will be added and you will be able to see the update in the list. You can delete and update the products in the same manner. 
5. Finally you can exit the system either by clicking on the red cross on the right upper corder or click on Product and then select exit from there. You will need to enter your username and password again to logout safely. 
