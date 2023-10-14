import mysql.connector


class Connection:
    __mydb = None

    def __init__(self, host, user, password, database):
        self.__mydb = mysql.connector.connect(
            host=host,
            user=user,
            password=password,
            database=database
        )

    def get_cursor(self):
        return self.__mydb.cursor()


# mydb = mysql.connector.connect(
#     host="localhost",
#     user="root",
#     password="root",
#     database="practice_task"
# )

# # print(mydb)  # it will print a connection object if everything is fine

# mycursor = mydb.cursor()

# # Queries
# # mycursor.execute("SELECT * FROM task") # Select all rows from table
# mycursor.execute(
#     "SELECT id, title, description, done, task.user_id, users.username FROM task LEFT JOIN users ON task.user_id = users.user_id")

# # print(mycursor)  # it will print a cursor object if everything is fine

# # fetchall() method fetches all rows from the last executed statement
# response = mycursor.fetchall()

# print(response)
