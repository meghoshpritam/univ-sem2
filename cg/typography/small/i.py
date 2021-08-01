# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas


def alphabat_i(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
               outline="#E93B81", width=5):
    root = Tk()
    root.title('Alphabet - i')

    small_side = canvas_height if canvas_height < canvas_width else canvas_width

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    canvas.create_line(small_side * 0.5, small_side*0.3,
                       small_side*0.5, small_side*0.8, width=width, fill=outline)

    canvas.create_oval(small_side*0.5, small_side*0.26,
                       small_side*0.5, small_side*0.26, fill=fill, outline=outline, width=width*1.5)

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    alphabat_i()
