# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas


def draw_line(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", line_color="#E93B81", line_width=4):
    root = Tk()
    root.title('Line')

    canvas = Canvas(root, width=canvas_width, height=canvas_height, background=canvas_bg)
    
    canvas.create_line(0, canvas_height/2, canvas_width, canvas_height/2, fill=line_color, width=line_width)
    
    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    draw_line()
