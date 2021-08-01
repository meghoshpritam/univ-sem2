from tkinter import Tk, Canvas, Frame, Button, Entry, StringVar, Label
from math import cos, sin, floor, pi


class Transformation():
    @staticmethod
    def rotate(coordinates, angle):
        new_coordinates = []
        for idx in range(0, len(coordinates), 2):
            x = coordinates[idx]
            y = coordinates[idx+1]

            c = cos(angle * pi/180)
            s = sin(angle * pi/180)
            x = floor(x * c + y * s)
            y = floor(-x * s + y * c)

            new_coordinates.append(x)
            new_coordinates.append(y)
        return new_coordinates

    @staticmethod
    def translate(coordinates, factor):
        new_coordinates = []
        for idx in range(0, len(coordinates), 2):
            x = coordinates[idx]
            y = coordinates[idx+1]

            x += factor[0]
            y += factor[1]

            new_coordinates.append(x)
            new_coordinates.append(y)
        return new_coordinates

    @staticmethod
    def scaling(coordinates, factor):
        new_coordinates = []
        for idx in range(0, len(coordinates), 2):
            x = coordinates[idx]
            y = coordinates[idx+1]

            x = x*factor[0]
            y = y*factor[1]

            new_coordinates.append(x)
            new_coordinates.append(y)
        return new_coordinates


class Helper:
    @staticmethod
    def string_to_coordinates(string_value, transform_function=None):
        _coordinates = string_value.split(',')
        return [(transform_function(_coordinates[idx]) if transform_function is not None else int(_coordinates[idx]))
                for idx in range(len(_coordinates))]


def create_input(parent, label, value, row=0):
    Label(parent, text=label).grid(
        row=row, column=0, padx=5, pady=5)
    Entry(parent, textvariable=value).grid(
        row=row, column=1, padx=5, pady=5)


class Utils:
    def __init__(self):
        self.white = "#EDEDED"
        self.secondary = "#444444"
        self.dark = "#171717"
        self.primary = "#DA0037"

    def create_button(self, parent, text, command, width="17", row=0, col=0, btn_type="secondary"):
        active_color = self.white
        active_bg = self.secondary
        bg = self.white
        color = self.secondary

        if btn_type == "primary":
            bg = self.primary
            color = self.white
            active_bg = self.dark

        Button(parent, text=text, command=command, fg=color, bg=bg,
               activebackground=active_bg, activeforeground=active_color, width=width, bd=0).grid(
            row=row, column=col, padx=5, pady=5)


class Window:
    def __init__(self, submit) -> None:
        self.root = Tk()
        self.entry = Entry(self.root)

        self.canvas = Canvas(
            self.root, width=500, height=500, background='white')
        self.canvas.grid(row=0, column=1)

        self.frame = Frame(self.root)
        self.frame.grid(row=0, column=0, sticky="n")

        self.vars = []
        self.return_type = "string"
        self.utils = Utils()

        self.submit = submit

    def exit(self):
        self.root.destroy()

    def on_submit(self):
        self.canvas.destroy()
        self.canvas = Canvas(
            self.root, width=500, height=500, background='white')
        self.canvas.grid(row=0, column=1)

        self.submit(self.canvas, *(
            [(int(self.vars[idx].get(), base=10) if self.return_type == "int" else self.vars[idx].get()) for idx in
             range(len(self.vars))]), )

    def run(self):
        self.root.mainloop()

    def set_title(self, title):
        self.root.title(title)

    def set_input(self, labels):
        for idx in range(len(labels)):
            self.vars.append(StringVar())
            create_input(
                self.frame, labels[idx], self.vars[idx], row=idx)

        self.utils.create_button(
            self.frame, "Exit", self.exit, row=len(labels), col=0)
        self.utils.create_button(
            self.frame, "Draw", self.on_submit, row=len(labels), col=1, btn_type="primary")

    def set_input_type(self, return_type):
        self.return_type = return_type

    def get_input_type(self):
        return self.return_type

    def initial(self, init_method):
        init_method(self.canvas)

    @staticmethod
    def canvas_height_width(canvas):
        canvas.update()
        width = canvas.winfo_reqwidth()
        height = canvas.winfo_reqheight()
        return height, width


def put_pixel(canvas, x, y, outline=None):
    colors = Utils()
    if outline is None:
        outline = colors.primary
    canvas.create_oval(x, y, x, y, width=5,
                       fill=colors.white, outline=outline)


def draw_axis(canvas, color="#F0F0F0"):
    canvas.update()
    width = canvas.winfo_reqwidth()
    height = canvas.winfo_reqheight()

    canvas.create_line(int(width / 2), 0, int(width / 2),
                       height, width=2, fill=color)
    canvas.create_line(0, int(height / 2), width,
                       int(height / 2), width=2, fill=color)


def get_axis_coordinates(canvas, coordinates):
    canvas.update()
    width = canvas.winfo_reqwidth()
    height = canvas.winfo_reqheight()
    center = width * 0.5, height * 0.5

    new_coordinates = []
    for idx in range(0, len(coordinates), 2):
        new_coordinates.append(int(coordinates[idx] + center[0]))
        new_coordinates.append(int(-coordinates[idx + 1] + center[1]))
    return tuple(new_coordinates)


def polygon_scaling(canvas, coordinates, factors):
    colors = Utils()
    coordinates = Helper.string_to_coordinates(coordinates)
    factors = Helper.string_to_coordinates(factors, lambda x: float(x))
    canvas.create_polygon(coordinates, width=5,
                          fill="", outline=colors.secondary)

    new_coordinates = []
    for idx in range(0, len(coordinates), 2):
        x = coordinates[idx]
        y = coordinates[idx+1]

        x = x*factors[0]
        y = y*factors[1]

        new_coordinates.append(x)
        new_coordinates.append(y)
    canvas.create_polygon(new_coordinates, width=5,
                          fill="", outline=colors.primary)


if __name__ == "__main__":
    window = Window(polygon_scaling)
    window.set_title("Polygon scaling")
    window.set_input(["Enter coordinates(x,y)",
                     "Scaling factor(Sfx,Sfy)"])

    window.run()
