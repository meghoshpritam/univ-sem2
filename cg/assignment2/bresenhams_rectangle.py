from base import Helper, Window
from bresenhams_line_drawing import bresenhams_linedrawing

# TODO: implement the vertical line drawing algorithm and complete the rectangle drawing algorithm


def bresenhams_rectangle(canvas, tl, br):
    tl = Helper.string_to_coordinates(tl)
    br = Helper.string_to_coordinates(br)

    # bresenhams_linedrawing(canvas, tl[0], tl[1], br[0], tl[1])
    bresenhams_linedrawing(canvas, br[0], tl[1], br[0], br[1])
    # bresenhams_linedrawing(canvas, tl[0], br[1], br[0], br[1])
    # bresenhams_linedrawing(canvas, tl[0], tl[1], tl[0], br[1])


if __name__ == "__main__":
    window = Window(bresenhams_rectangle)
    window.set_title("Rectangle using Bresenhams line drawing algorithm")
    window.set_input(["Top left(x,y)", "Bottom right(x,y)"])
    window.run()
