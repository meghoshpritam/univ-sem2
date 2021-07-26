from base import Helper, Utils, Window



def bezier_curve(canvas, a, b, c, d, color=None, width=5):
    a = Helper.string_to_coordinates(a)
    b = Helper.string_to_coordinates(b)
    c = Helper.string_to_coordinates(c)
    d = Helper.string_to_coordinates(d)
    if color is None:
        colors = Utils()
        color = colors.primary

    p = [[*a], [*b], [*c], [*d]]

    x_start = p[0][0]
    y_start = p[0][1]

    for i in range(0, 11, 1):
        t = i/10
        x = (p[0][0]*(1-t)**3 +
             p[1][0]*3*t*(1-t) ** 2 +
             p[2][0]*3*t**2*(1-t) +
             p[3][0]*t**3)
        y = (p[0][1]*(1-t)**3+p[1][1]*3*t*(1-t) **
             2+p[2][1]*3*t**2*(1-t)+p[3][1]*t**3)

        canvas.create_line(x, y, x_start, y_start, fill=color, width=width)
        x_start = x
        y_start = y


if __name__ == "__main__":
    window = Window(bezier_curve)
    window.set_title("Benzier Curve")
    window.set_input(["Point a(x,y)", "Point b(x,y)",
                     "Point c(x,y)", "Point d(x,y)"])
    window.run()
