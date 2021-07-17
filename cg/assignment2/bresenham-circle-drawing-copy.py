from base import Utils, Window


def put_pixel(canvas, x, y):
    colors = Utils()
    canvas.create_oval(x, y, x, y, width=5,
                       fill=colors.white, outline=colors.primary)


def bresenham_circle_drawing_copy(canvas, x0, y0, radius):
    def draw(xc, yc, x, y):
        put_pixel(canvas, x+xc, y+yc)
        put_pixel(canvas, x+xc, -y+yc)
        put_pixel(canvas, -x+xc, -y+yc)
        put_pixel(canvas, -x+xc, y+yc)
        put_pixel(canvas, y+xc, x+yc)
        put_pixel(canvas, y+xc, -x+yc)
        put_pixel(canvas, -y+xc, -x+yc)
        put_pixel(canvas, -y+xc, x+yc)
   
    x = 0
    y=radius
    d=3-(2*radius)
    draw(x0,y0,x,y);  
  
    while x<=y:
        if d<=0:
            d=d+(4*x)+6
        else: 
            d=d+(4*x)-(4*y)+10
            y=y-1
        x=x+1
        draw(x0, y0, x, y)


if __name__ == "__main__":
    window = Window(bresenham_circle_drawing_copy)
    window.set_title("Bresenham's Circle Drawing Algorithm")
    window.set_input(["Center X", "Center Y",
                     "Radius"])
    window.set_input_type("int")
    window.run()
