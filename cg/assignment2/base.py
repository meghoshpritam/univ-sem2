from tkinter import Tk, Canvas, Frame, Button, Entry, StringVar, Label


class Helper():
    @staticmethod
    def string_to_coordinates(string_value, tranform_function=None):
        _coordinates = string_value.split(',')
        return [(tranform_function(_coordinates[idx])if tranform_function != None else int(_coordinates[idx]))for idx in range(len(_coordinates))]


class Utils():
    def __init__(self):
        self.white = "#EDEDED"
        self.secondary = "#444444"
        self.dark = "#171717"
        self.primary = "#DA0037"

    def create_button(self, parent, text, command, width="17", bd=0, row=0, col=0, type="secondary"):
        active_color = self.white
        active_bg = self.secondary
        bg = self.white
        color = self.secondary

        if type == "primary":
            bg = self.primary
            color = self.white
            active_bg = self.dark

        Button(parent, text=text, command=command, fg=color, bg=bg,
               activebackground=active_bg, activeforeground=active_color, width=width, bd=0).grid(
            row=row, column=col, padx=5, pady=5)

    def create_input(self, parent, label, value, row=0):
        Label(parent, text=label).grid(
            row=row, column=0, padx=5, pady=5)
        Entry(parent, textvariable=value).grid(
            row=row, column=1,  padx=5, pady=5)


class Window():
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

        self.utils.create_button(self.frame, "Exit", self.exit, row=4, col=0)
        self.utils.create_button(
            self.frame, "Draw", self.submit, row=4, col=1, type="primary")

        self.submit = submit

    def exit(self):
        self.root.destroy()

    def submit(self):
        self.canvas.destroy()
        self.canvas = Canvas(
            self.root, width=500, height=500, background='white')
        self.canvas.grid(row=0, column=1)

        self.submit(self.canvas, *(
            [(int(self.vars[idx].get(), base=10) if self.return_type == "int" else self.vars[idx].get())for idx in range(len(self.vars))]),)

    def run(self):
        self.root.mainloop()

    def set_title(self, title):
        self.root.title(title)

    def set_input(self, labels):
        for idx in range(len(labels)):
            self.vars.append(StringVar())
            self.utils.create_input(
                self.frame, labels[idx], self.vars[idx], row=idx)

    def set_input_type(self, return_type):
        self.return_type = return_type

    def get_input_type(self):
        return self.return_type


def put_pixel(canvas, x, y, outline=None):
    colors = Utils()
    if outline is None:
        outline = colors.primary
    canvas.create_oval(x, y, x, y, width=5,
                       fill=colors.white, outline=outline)


if __name__ == "__main__":
    def submit(canvas, x, y, x2, y2):
        print("called")
        canvas.create_line(10, 10, 200, 100, width=5)

    window = Window(submit)
    window.run()
