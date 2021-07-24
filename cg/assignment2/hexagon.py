from turtle import color, width
from dda_line_drawing import dda_line_drawing
from base import Helper, Utils, Window

def hexagon(canvas, a,b,c,d,e,f):
    color = Utils()
    a = Helper.string_to_coordinates(a)
    b = Helper.string_to_coordinates(b)
    c = Helper.string_to_coordinates(c)
    d = Helper.string_to_coordinates(d)
    e = Helper.string_to_coordinates(e)
    f = Helper.string_to_coordinates(f)
    canvas.create_polygon(a[0], a[1], b[0], b[1], c[0], c[1], d[0],
                          d[1], e[0], e[1], f[0], f[1], fill="", outline=color.primary, width=5)

if __name__ == "__main__":
    window = Window(hexagon)
    window.set_title("Hexagon")
    window.set_input(["Point 1(x,y)", "Point 2(x,y)", "Point 3(x, y)",
                     "Point 4(x, y)", "Point 5(x,y)", "Point 6(x,y)"])
    window.run()
