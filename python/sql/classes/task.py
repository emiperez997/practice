from db.connection import Connection


class Task:
    __mydb = None

    def __init__(self):
        self.__mydb = Connection("localhost", "root", "root", "practice_task")

    def get_all(self):
        mycursor = self.__mydb.get_cursor()

        mycursor.execute(
            "SELECT id, title, description, done, task.user_id, users.username FROM task LEFT JOIN users ON task.user_id = users.user_id")

        fetch = mycursor.fetchall()

        response = []

        for task in fetch:
            response.append({
                "id": task[0],
                "title": task[1],
                "description": task[2],
                "done": bool(task[3]),
                "user_id": task[4],
                "username": task[5]
            })

        return response

    def get_one(self, id: int):
        mycursor = self.__mydb.get_cursor()

        mycursor.execute(
            f"SELECT id, title, description, done, task.user_id, users.username FROM task LEFT JOIN users ON task.user_id = users.user_id WHERE id = {id}")

        fetch = mycursor.fetchone()

        response = {
            "id": fetch[0],
            "title": fetch[1],
            "description": fetch[2],
            "done": bool(fetch[3]),
            "user_id": fetch[4],
            "username": fetch[5]
        }

        return response

    def create(self, title: str, description: str, done: bool, user_id: int):
        mycursor = self.__mydb.get_cursor()

        # sql = "INSERT INTO task (title, description, done, user_id) VALUES (%s, %s, %s, %s)"
        # val = (title, description, done, user_id)
        # mycursor.execute(sql, val)

        sql = f"INSERT INTO task (title, description, done, user_id) VALUES ('{title}', '{description}', {done}, {user_id})"
        mycursor.execute(sql)

        self.__mydb.commit()

        return mycursor.rowcount

    def update(self, id: int, title: str, description: str, done: bool, user_id: int):
        mycursor = self.__mydb.get_cursor()

        sql = f"UPDATE task SET title = '{title}', description = '{description}', done = {done}, user_id = {user_id} WHERE id = {id}"
        mycursor.execute(sql)

        self.__mydb.commit()

        return mycursor.rowcount

    def delete(self, id: int):
        mycursor = self.__mydb.get_cursor()

        sql = f"DELETE FROM task WHERE id = {id}"
        mycursor.execute(sql)

        self.__mydb.commit()

        return mycursor.rowcount
