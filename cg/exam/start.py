from tkinter import Tk, Canvas


def draw_star(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
                outline="#E93B81", width=5):
    root = Tk()
    root.title('Star')

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    # star section start
    p1 = 70, 150
    p5 = 430, 150

    p2 = 190, 150
    p4 = 310, 150

    p3 = 250, 30
    p8 = 250, 290

    p6 = 340, 240
    p10 = 160, 240

    p7 = 430, 390
    p9 = 70, 380

    points = (*p1, *p2, *p3, *p4, *p5, *p6, *p7, *p8, *p9, *p10)
    canvas.create_polygon(*points,  fill=outline, outline=outline, width=width)
    # star section end

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    draw_star()
