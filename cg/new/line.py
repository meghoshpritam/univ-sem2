from tkinter import *

root = Tk()
canvas = Canvas(root, width=500, height=500)

canvas.create_line(1, 200, 500, 200, width=5)
canvas.pack()
root.mainloop()
