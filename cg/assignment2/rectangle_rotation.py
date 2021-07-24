from transformation import Transformation
from dda_line_drawing import dda_line_drawing
from base import Helper, Utils, Window

def draw_rectangle(canvas, coordinates, color):
    canvas.create_polygon(*coordinates, fill="", outline=color, width=5)

def rectangle_rotation(canvas, start, end, angle):
    start = Helper.string_to_coordinates(start)
    end = Helper.string_to_coordinates(end)
    angle = int(angle,10)
    coordinates = (start[0], start[1], end[0], start[1], end[0],end[1], start[0], end[1], start[0], start[1])
    
    color = Utils()
    draw_rectangle(canvas, coordinates, color.dark)
    new_coordinates = Transformation.rotate(coordinates, angle)
    print(new_coordinates)
    draw_rectangle(canvas, new_coordinates, color.primary)

if __name__ == "__main__":
    window = Window(rectangle_rotation)
    window.set_title("Rectangle Rotation")
    window.set_input(["Starting point(x1,y1)", "Ending point(x2,y2))",
                     "Rotation Angle"])
    window.run()
