from tkinter import *

root = Tk()
canvas = Canvas(root, width=500, height=500)

canvas.create_rectangle(20, 20, 400, 300, width=5)
canvas.pack()
root.mainloop()
