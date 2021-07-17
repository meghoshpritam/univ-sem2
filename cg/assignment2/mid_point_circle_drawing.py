from base import Utils, Window


def put_pixel(canvas, x, y):
    colors = Utils()
    canvas.create_oval(x, y, x, y, width=5,
                       fill=colors.white, outline=colors.primary)


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


if __name__ == "__main__":
    window = Window(mid_point_circle_drawing)
    window.set_title("Mid Point Circle Drawing Algorithm")
    window.set_input(["Center X", "Center Y",
                     "Radius"])
    window.set_input_type("int")
    window.run()
