# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas


def alphabat_a(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
               outline="#E93B81", width=5):
    root = Tk()
    root.title('Alphabet - a')

    small_side = canvas_height if canvas_height < canvas_width else canvas_width

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    canvas.create_arc(small_side * 0.38, small_side*0.2,
                      small_side*0.801, small_side*0.6, start=10,
                      extent=130, width=width, style="arc",
                      outline=outline)

    canvas.create_line(small_side * 0.8, small_side*0.35,
                       small_side*0.8, small_side*0.81,
                       width=width, fill=outline)

    canvas.create_line(small_side * 0.6, small_side*0.5,
                       small_side*0.8, small_side*0.5, width=width, fill=outline)

    canvas.create_arc(small_side * 0.4, small_side*0.5,
                      small_side*0.8, small_side*0.8,
                      start=90, extent=180, width=width,
                      style="arc", outline=outline)

    canvas.create_line(small_side * 0.6, small_side*0.8,
                       small_side*0.8, small_side*0.79, width=width, fill=outline)

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    alphabat_a()
