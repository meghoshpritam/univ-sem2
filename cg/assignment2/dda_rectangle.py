from base import Helper, Window
from dda_line_drawing import dda_line_drawing


def dda_rectangle(canvas, tl, br):
    tl = Helper.string_to_coordinates(tl)
    br = Helper.string_to_coordinates(br)
    
    dda_line_drawing(canvas, tl[0], tl[1], br[0], tl[1])
    dda_line_drawing(canvas, br[0], tl[1], br[0], br[1])
    dda_line_drawing(canvas, tl[0], br[1], br[0], br[1])
    dda_line_drawing(canvas, tl[0], tl[1], tl[0], br[1])

    
    
if __name__ == "__main__":
    window = Window(dda_rectangle)
    window.set_title("Rectangle using DDA line drawing algorithm")
    window.set_input(["Top left(x,y)", "Bottom right(x,y)"])
    window.run()
