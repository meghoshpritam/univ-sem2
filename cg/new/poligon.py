from tkinter import *

root = Tk()
canvas = Canvas(root, width=500, height=500)

canvas.create_polygon(10, 10, 200, 50, 90, 150, 50, 80,
                      120, 55, width=5)
canvas.pack()
root.mainloop()
