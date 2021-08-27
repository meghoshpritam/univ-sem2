from tkinter import *
root = Tk()
canvas = Canvas(root, width=500, height=500)
canvas.create_line(270, 50, 70, 375, )
canvas.create_line(270, 50, 240, 380,  )
canvas.create_arc(25, 330, 78, 380, start=230, extent=100,
                     style="arc", )
canvas.create_arc(90, 220, 245, 450, start=130, extent=-
                    150,  style="arc")
canvas.create_arc(100, 10, 350, 320, start=211, extent=120,
                     style="arc")
canvas.pack()
root.mainloop()

