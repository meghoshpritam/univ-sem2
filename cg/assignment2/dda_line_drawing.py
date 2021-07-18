from base import put_pixel, Window


def dda_line_drawing(canvas, x0, y0, x1, y1, color=None):
    dx = x1 - x0
    dy = y1 - y0
    steps = dy

    if dx >= dy:
        steps = dx

    dx = dx/steps
    dy = dy/steps
    x = x0
    y = y0
    i = 1

    while i <= steps:
        put_pixel(canvas, x, y, outline=color)
        x += dx
        y += dy
        i = i+1


if __name__ == "__main__":
    window = Window(dda_line_drawing)
    window.set_title("DDA Line Drawing Algorithm")
    window.set_input(["Starting point x1", "Starting point y1",
                     "Ending point x2", "Ending point y2"])
    window.set_input_type("int")
    window.run()
