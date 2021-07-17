from turtle import width
from base import Utils, Window


def put_pixel(canvas, x, y):
    colors = Utils()
    canvas.create_oval(x, y, x, y, width=5,
                       fill=colors.white, outline=colors.primary)


def dda_linedrawing(canvas, x0, y0, x1, y1):
    x0 = int(x0, base=10)
    y0 = int(y0, base=10)
    x1 = int(x1, base=10)
    y1 = int(y1, base=10)
    
    dx = x1-x0
    dy = y1-y0
    
    x = x0
    y = y0

    p = 2*dy-dx
    
    while(x < x1):
        if p >= 0:
            put_pixel(canvas, x,y)
            print(">>",x,y)
            y = y+1
            p = p+2*dy-2*dx

        else:
            put_pixel(canvas, x, y)
            print(">>|",x,y)
            
            p = p+2*dy
        x = x+1


if __name__ == "__main__":
    window = Window(dda_linedrawing)
    window.set_title("Bresenham’s Line Drawing Algorithm")
    window.run()
