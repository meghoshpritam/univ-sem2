from transformation import Transformation
from dda_line_drawing import dda_line_drawing
from base import Helper, Utils, Window

def draw_rectangle(canvas, x1,y1, x2,y2, color):
    dda_line_drawing(canvas, x1,y1, x2,y1, color)
    dda_line_drawing(canvas, x2,y1, x2,y2, color)
    dda_line_drawing(canvas, x1,y2, x2,y2, color)
    dda_line_drawing(canvas, x1,y1, x1,y2, color)

def rectangle_translation(canvas, start, end, translation_factor):
    start = Helper.string_to_coordinates(start)
    end = Helper.string_to_coordinates(end)
    translation_factor = Helper.string_to_coordinates(translation_factor)
    
    color = Utils()
    draw_rectangle(canvas, start[0], start[1], end[0], end[1], color.dark)
    new_coordinates = Transformation.translate((start[0], start[1], end[0], end[1]), translation_factor)
    draw_rectangle(canvas, new_coordinates[0], new_coordinates[1], new_coordinates[2], new_coordinates[3], color.primary)

if __name__ == "__main__":
    window = Window(rectangle_translation)
    window.set_title("Rectangle Translation")
    window.set_input(["Starting point(x1,y1)", "Ending point(x2,y2))",
                     "Translation factor(x,y)"])
    window.run()
