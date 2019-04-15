# Paper-Review-Project

Steps to run the Paper Review Projects

Part 1
1. Clone this gitbug repository.
2. FOLDER_PATH is where this project is downloaded.
3. Open MySQL command line client. 
4. Run the following command to setup the database
   mysql> source FOLDER_PATH/sql_scripts/create_database.sql
5. Run the following command to create the database schema
   mysql> source FOLDER_PATH/sql_scripts/create_database_schema.sql
6. Run the following command to insert data into the database
   mysql> source FOLDER_PATH/sql_scripts/insert_database_values.sql