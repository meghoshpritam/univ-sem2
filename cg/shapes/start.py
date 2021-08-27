# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas


def draw_circle(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
                outline="#E93B81", width=5):
    root = Tk()
    root.title('Star')

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    # star section start
    p1 = 50, 150
    p5 = 450, 150

    p2 = 190, 150
    p4 = 310, 150

    p3 = 250, 30
    p8 = 250, 325

    p6 = 340, 260
    p10 = 160, 260

    p7 = 450, 430
    p9 = 50, 430

    points = (*p1, *p2, *p3, *p4, *p5, *p6, *p7, *p8, *p9, *p10)
    canvas.create_polygon(*points,  fill='red', outline=outline, width=width)
    # star section end

    # circle section start
    x1 = 165
    y1 = 145
    d = 170
    x2 = x1 + d
    y2 = y1 + d
    canvas.create_oval(x1, y1, x2, y2,  fill='green',
                       outline=outline, width=width)
    # circle section end

    # square section start
    x1 = 195
    y1 = 175
    d = 109
    x2 = x1 + d
    y2 = y1 + d
    canvas.create_rectangle(x1, y1, x2, y2,  fill='blue',
                       outline=outline, width=width)
    # square section end

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    draw_circle()
