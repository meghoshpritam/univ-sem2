from tkinter import Tk, Canvas


def alphabat_U(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
               outline="#E93B81", width=5):
    root = Tk()
    root.title('Alphabet - U')

    small_side = canvas_height if canvas_height < canvas_width else canvas_width

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    canvas.create_line(small_side * 0.35, small_side*0.2,
                       small_side*0.35, small_side*0.7, width=width, fill=outline)

    canvas.create_line(small_side * 0.65, small_side*0.2,
                       small_side*0.65, small_side*0.7, width=width, fill=outline)

    canvas.create_arc(small_side * 0.35, small_side*0.55,
                      small_side*0.65, small_side*0.8, start=180, extent=180, width=width, style="arc", outline=outline)
    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    alphabat_U()
