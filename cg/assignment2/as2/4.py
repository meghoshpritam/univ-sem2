from tkinter import Tk, Canvas, Frame, Button, Entry, StringVar, Label


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


def init(canvas):
    color = Utils()
    w_x_max, w_y_max = w_x_min, w_y_min = Window.canvas_height_width(canvas)
    w_x_min, w_y_min = w_x_min*0.1, w_y_min*0.1
    w_x_max, w_y_max = w_x_max * 0.9, w_y_max*0.9
    canvas.create_rectangle(w_x_min, w_y_min, w_x_max,
                            w_y_max, outline=color.secondary, width=5)


def cohen_sutherland_line_cliping(canvas, start, end):
    color = Utils()
    rcode_begin = [0, 0, 0, 0]
    rcode_end = [0, 0, 0, 0]
    region_code = [0, 0, 0, 0]
    w_x_max, w_y_max = w_x_min, w_y_min = Window.canvas_height_width(canvas)
    w_x_min, w_y_min = w_x_min*0.1, w_y_min*0.1
    w_x_max, w_y_max = w_x_max * 0.9, w_y_max*0.9
    flag = 0
    x1, y1 = Helper.string_to_coordinates(start)
    x2, y2 = Helper.string_to_coordinates(end)

    canvas.create_rectangle(w_x_min, w_y_min, w_x_max,
                            w_y_max, outline=color.secondary, width=5)
    canvas.create_line(x1, y1, x2, y2, width=5, fill=color.primary)

    if y1 > w_y_max:
        rcode_begin[0] = 1
        flag = 1

    if y1 < w_y_min:
        rcode_begin[1] = 1
        flag = 1

    if x1 > w_x_max:
        rcode_begin[2] = 1
        flag = 1

    if x1 < w_x_min:
        rcode_begin[3] = 1
        flag = 1

    if y2 > w_y_max:
        rcode_end[0] = 1
        flag = 1

    if y2 < w_y_min:
        rcode_end[1] = 1
        flag = 1

    if x2 > w_x_max:
        rcode_end[2] = 1
        flag = 1

    if x2 < w_x_min:
        rcode_end[3] = 1
        flag = 1

    if flag == 0:
        print("No need of clipping as it is already in window")

    flag = 1
    for i in range(0, 4):
        region_code[i] = rcode_begin[i] and rcode_end[i]
        if region_code[i] == 1:
            flag = 0

    if flag == 0:
        print("\n Line is completely outside the window")
        return

    else:
        slope = (float)(y2-y1)/(x2-x1)
        if rcode_begin[2] == 0 and rcode_begin[3] == 1:
            y1 = y1+(float)(w_x_min-x1)*slope
            x1 = w_x_min

        if rcode_begin[2] == 1 and rcode_begin[3] == 0:
            y1 = y1+(float)(w_x_max-x1)*slope
            x1 = w_x_max

        if rcode_begin[0] == 1 and rcode_begin[1] == 0:
            x1 = x1+(float)(w_y_max-y1)/slope
            y1 = w_y_max

        if rcode_begin[0] == 0 and rcode_begin[1] == 1:
            x1 = x1+(float)(w_y_min-y1)/slope
            y1 = w_y_min

        if rcode_end[2] == 0 and rcode_end[3] == 1:
            y2 = y2+(float)(w_x_min-x2)*slope
            x2 = w_x_min

        if rcode_end[2] == 1 and rcode_end[3] == 0:
            y2 = y2+(float)(w_x_max-x2)*slope
            x2 = w_x_max

        if rcode_end[0] == 1 and rcode_end[1] == 0:
            x2 = x2+(float)(w_y_max-y2)/slope
            y2 = w_y_max

        if rcode_end[0] == 0 and rcode_end[1] == 1:
            x2 = x2+(float)(w_y_min-y2)/slope
            y2 = w_y_min

    canvas.create_line(x1, y1, x2, y2, fill=color.secondary, width=5)


if __name__ == "__main__":
    window = Window(cohen_sutherland_line_cliping)
    window.set_title("Cohen Sutherland Line Clipping")
    window.set_input(["Starting point(x,y)", "Ending point(x,y)"])
    window.initial(init)
    window.run()
