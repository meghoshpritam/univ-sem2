from dda_line_drawing import dda_line_drawing
from base import Helper, Utils, Window


def translate_dda_line(canvas, starting, ending, factors):
    colors = Utils()
    starting = Helper.string_to_coordinates(starting)
    ending = Helper.string_to_coordinates(ending)
    factors = Helper.string_to_coordinates(factors)
    dda_line_drawing(canvas, starting[0], starting[1], ending[0], ending[1], color=colors.secondary)

    def get_new_coordinates(x, y):
        new_x = x + factors[0]
        new_y = y + factors[1]
        return [new_x, new_y]
    
    new_starting = get_new_coordinates(starting[0], starting[1])
    new_ending = get_new_coordinates(ending[0], ending[1])

    dda_line_drawing(canvas, new_starting[0], new_starting[1], new_ending[0], new_ending[1], color=colors.primary)


if __name__ == "__main__":
    window = Window(translate_dda_line)
    window.set_title("Tanslate DDA line")
    window.set_input(["Starting point(x1,y1)", "Ending point (x2,y2)", "Translation factor(tx,ty)"])
    window.run()
