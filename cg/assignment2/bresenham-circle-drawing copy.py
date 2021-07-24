from tkinter import *

def put_pixel(canvas, x, y,):
    canvas.create_oval(x, y, x, y, width=2, fill="white", outline="black")

def bresenham_circle_drawing_copy(canvas, x0, y0, radius):
    def draw(xc, yc, x, y):
        put_pixel(canvas, x+xc, y+yc)
        put_pixel(canvas, x+xc, -y+yc)
        put_pixel(canvas, -x+xc, -y+yc)
        put_pixel(canvas, -x+xc, y+yc)
        put_pixel(canvas, y+xc, x+yc)
        put_pixel(canvas, y+xc, -x+yc)
        put_pixel(canvas, -y+xc, -x+yc)
        put_pixel(canvas, -y+xc, x+yc)

    x = 0
    y = radius
    d = 3-(2*radius)
    draw(x0, y0, x, y)

    while x <= y:
        if d <= 0:
            d = d+(4*x)+6
        else:
            d = d+(4*x)-(4*y)+10
            y = y-1
        x = x+1
        draw(x0, y0, x, y)


root = Tk()
canvas = Canvas(root, width=500, height=500)

bresenham_circle_drawing_copy(canvas, 250, 250, 100)
canvas.pack()
root.mainloop()
