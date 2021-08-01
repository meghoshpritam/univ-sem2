# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas


def alphabat_y(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
               outline="#E93B81", width=5):
    root = Tk()
    root.title('Alphabet - y')

    small_side = canvas_height if canvas_height < canvas_width else canvas_width

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    canvas.create_line(small_side * 0.45, small_side*0.51,
                       small_side*0.55, small_side*0.65, width=width, fill=outline)

    canvas.create_line(small_side * 0.6, small_side*0.5,
                       small_side*0.5, small_side*0.78, width=width, fill=outline)

    canvas.create_arc(small_side * 0.4, small_side*0.65,
                      small_side*0.515, small_side*0.8, start=270, extent=80, width=width, style="arc", outline=outline)

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    alphabat_y()
