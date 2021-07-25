from base import draw_axis, get_axis_coordinates
from tkinter import Canvas, Tk
from mid_point_circle_drawing import mid_point_circle_drawing


def circle_draw(center, radius):
    root = Tk()
    root.title("Circle with 150,150 center and radius 25")
    canvas = Canvas(root, width=500, height=500, background='white')
    draw_axis(canvas)
    new_center = get_axis_coordinates(canvas,center)

    mid_point_circle_drawing(canvas, new_center[0],new_center[1], radius)
    canvas.pack()
    root.mainloop()


if __name__ == '__main__':
    circle_draw((150, 150), 25)
