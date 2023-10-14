from classes.task import Task
from tkinter import *
from tkinter import messagebox


def show_task():
    task = Task().get_one(1)
    # messagebox.showinfo(
    #     "Task", f"Task ID: {task['id']}\nTask Title: {task['title']}\nTask Description: {task['description']}\nTask Done: {task['done']}\nTask User ID: {task['user_id']}\nTask Username: {task['username']}")
    messagebox.showwarning(
        "Task", f"Task ID: {task['id']}\nTask Title: {task['title']}\nTask Description: {task['description']}\nTask Done: {task['done']}\nTask User ID: {task['user_id']}\nTask Username: {task['username']}"
    )


if __name__ == "__main__":
    tasks = Task().get_all()
    print(tasks)

    task = Task().get_one(1)
    print(task)

    Window = Tk()
    Window.title("Task Manager")
    Window.resizable(False, False)
    Window.config(cursor="arrow")

    frame = Frame()
    frame.config(width=500, height=500)
    frame.pack()  # pack() method is used to show the object in the window

    task_id = Label(frame, text=f"Task ID: {task['id']}").place(x=10, y=10)
    task_title = Label(
        frame, text=f"Task Title: {task['title']}").place(x=10, y=30)
    task_description = Label(
        frame, text=f"Task Description: {task['description']}").place(x=10, y=50)
    task_done = Label(
        frame, text=f"Task Done: {task['done']}").place(x=10, y=70)
    task_user_id = Label(
        frame, text=f"Task User ID: {task['user_id']}").place(x=10, y=90)
    task_username = Label(
        frame, text=f"Task Username: {task['username']}").place(x=10, y=110)

    button_read = Button(frame, text="Read",
                         command=show_task).place(x=10, y=150)

    Window.mainloop()
