from base import put_pixel, Window


def bresenhams_linedrawing(canvas, x0, y0, x1, y1):
    def plot_line_low(x0, y0, x1, y1):
        dx = x1 - x0
        dy = y1 - y0
        yi = 1
        if dy < 0:
            yi = -1
            dy = -dy
        D = (2 * dy) - dx
        y = y0

        for x in range(x0, x1):
            put_pixel(canvas, x,y)
            if D > 0:
                y = y + yi
                D = D + (2 * (dy - dx))
            else:
                D = D + 2*dy

    
    def plot_line_high(x0, y0, x1, y1):
        dx = x1 - x0
        dy = y1 - y0
        xi = 1
        if dx < 0:
            xi = -1
            dx = -dx
        D = (2 * dx) - dy
        x = x0

        for y in range(y0, y1):
            put_pixel(canvas,x, y)
            if D > 0:
                x = x + xi
                D = D + (2 * (dx - dy))
            else:
                D = D + 2*dx

    if abs(y1 - y0) < abs(x1 - x0):
        if x0 > x1:
           plot_line_low(x1, y1, x0, y0)
        else:
            plot_line_low(x0, y0, x1, y1)
    else:
        if y0 > y1:
            plot_line_high(x1, y1, x0, y0)
        else:
            plot_line_high(x0, y0, x1, y1)   


if __name__ == "__main__":
    window = Window(bresenhams_linedrawing)
    window.set_title("Bresenham’s Line Drawing Algorithm")
    window.set_input(["Starting point x1", "Starting point y1",
                     "Ending point x2", "Ending point y2"])
    window.set_input_type("int")
    window.run()
