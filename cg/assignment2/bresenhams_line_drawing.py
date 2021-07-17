from base import Utils, Window


def put_pixel(canvas, x, y):
    colors = Utils()
    canvas.create_oval(x, y, x, y, width=5,
                       fill=colors.white, outline=colors.primary)


def bresenhams_linedrawing(canvas, x0, y0, x1, y1):
    dx = x1-x0
    dy = y1-y0

    x = x0
    y = y0

    p = 2*dy-dx

    while(x < x1):
        if p >= 0:
            put_pixel(canvas, x, y)
            y = y+1
            p = p+2*dy-2*dx

        else:
            put_pixel(canvas, x, y)
            p = p+2*dy
        x = x+1


if __name__ == "__main__":
    window = Window(bresenhams_linedrawing)
    window.set_title("Bresenham’s Line Drawing Algorithm")
    window.set_input(["Starting point x1", "Starting point y1",
                     "Ending point x2", "Ending point y2"])
    window.set_input_type("int")
    window.run()
