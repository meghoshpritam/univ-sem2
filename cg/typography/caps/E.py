# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas, Label


def alphabat_E(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
               outline="#E93B81", width=5):
    root = Tk()
    root.title('Alphabate - E')

    small_side = canvas_height if canvas_height < canvas_width else canvas_width

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    canvas.create_line(small_side * 0.4, small_side*0.2,
                       small_side*0.4, small_side*0.8, width=width, fill=outline)

    canvas.create_line(small_side * 0.4, small_side*0.2,
                       small_side*0.65, small_side*0.2, width=width, fill=outline)

    canvas.create_line(small_side * 0.4, small_side*0.5,
                       small_side*0.6, small_side*0.5, width=width, fill=outline)

    canvas.create_line(small_side * 0.4, small_side*0.8,
                       small_side*0.65, small_side*0.8, width=width, fill=outline)

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    alphabat_E()
