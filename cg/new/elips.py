from tkinter import *

root = Tk()
canvas = Canvas(root, width=500, height=500)

canvas.create_oval(20, 20, 300, 400, width=5)
canvas.pack()
root.mainloop()
