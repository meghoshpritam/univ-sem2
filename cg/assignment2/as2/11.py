
from tkinter import Canvas, Tk


class Utils():
    def __init__(self):
        self.white = "#EDEDED"
        self.secondary = "#444444"
        self.dark = "#171717"
        self.primary = "#DA0037"


def draw_axis(canvas, color="#F0F0F0", weight=2):
    canvas.update()
    width = canvas.winfo_reqwidth()
    height = canvas.winfo_reqheight()

    canvas.create_line((int)(width/2), 0, (int)(width/2),
                       height, width=2, fill=color)
    canvas.create_line(0, (int)(height/2), width,
                       (int)(height/2), width=2, fill=color)


def get_axis_coordinates(canvas, coordinates):
    canvas.update()
    width = canvas.winfo_reqwidth()
    height = canvas.winfo_reqheight()
    center = width*0.5, height*0.5

    new_coordinates = []
    for idx in range(0, len(coordinates), 2):
        new_coordinates.append((int)(coordinates[idx]+center[0]))
        new_coordinates.append((int)(-coordinates[idx+1]+center[1]))
    return tuple(new_coordinates)


def put_pixel(canvas, x, y, outline=None):
    colors = Utils()
    if outline is None:
        outline = colors.primary
    canvas.create_oval(x, y, x, y, width=5,
                       fill=colors.white, outline=outline)


def mid_point_circle_drawing(canvas, x0, y0, radius):
    x = radius
    y = 0
    err = 0

    while x >= y:
        put_pixel(canvas, x0 + x, y0 + y)
        put_pixel(canvas, x0 + y, y0 + x)
        put_pixel(canvas, x0 - y, y0 + x)
        put_pixel(canvas, x0 - x, y0 + y)
        put_pixel(canvas, x0 - x, y0 - y)
        put_pixel(canvas, x0 - y, y0 - x)
        put_pixel(canvas, x0 + y, y0 - x)
        put_pixel(canvas, x0 + x, y0 - y)

        if err <= 0:
            y += 1
            err += 2*y + 1

        if err > 0:
            x -= 1
            err -= 2*x + 1


def circle_draw(center, radius):
    root = Tk()
    root.title("Circle with 150,150 center and radius 25")
    canvas = Canvas(root, width=500, height=500, background='white')
    draw_axis(canvas)
    new_center = get_axis_coordinates(canvas, center)

    mid_point_circle_drawing(canvas, new_center[0], new_center[1], radius)
    canvas.pack()
    root.mainloop()


if __name__ == '__main__':
    circle_draw((150, 150), 25)
