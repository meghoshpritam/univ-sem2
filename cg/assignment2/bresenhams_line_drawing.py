from base import put_pixel, Window


def bresenhams_linedrawing(canvas, x1, y1, x2, y2):
    dx = abs(x1-x2)
    dy = abs(y1-y2)
    p = 2*dy-dx

    if x1 > x2:
        x = x2
        y = y2
        end = x1
    else:
        x = x1
        y = y1
        end = x2

    put_pixel(canvas, x, y)

    while x <= end:
        if p < 0:
            x += 1
            p = p+2*dy
        else:
            x += 1
            y += 1
            p = p+2*(dy-dx)

        put_pixel(canvas, x, y)


if __name__ == "__main__":
    window = Window(bresenhams_linedrawing)
    window.set_title("Bresenham’s Line Drawing Algorithm")
    window.set_input(["Starting point x1", "Starting point y1",
                     "Ending point x2", "Ending point y2"])
    window.set_input_type("int")
    window.run()
