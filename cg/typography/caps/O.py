from tkinter import Tk, Canvas


def alphabat_O(canvas_width=500, canvas_height=500, canvas_bg="#ffffff", fill="#ffffff",
               outline="#E93B81", width=5):
    root = Tk()
    root.title('Alphabet - O')

    small_side = canvas_height if canvas_height < canvas_width else canvas_width

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    canvas.create_oval(small_side*0.2, small_side * 0.2, small_side * 0.75,
                       small_side * 0.8, fill=fill, outline=outline, width=width)

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    alphabat_O()
