# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas


def draw_square(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff", outline="#E93B81",
                square_width=5):
    root = Tk()
    root.title('Square')

    small_side = canvas_height if canvas_height < canvas_width else canvas_width
    
    canvas = Canvas(root, width=canvas_width, height=canvas_height, background=canvas_bg)
    
    canvas.create_rectangle(small_side / 8, small_side / 8, small_side / 1.15, small_side / 1.15, fill=fill,
                            outline=outline,
                            width=square_width)
    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    draw_square()
