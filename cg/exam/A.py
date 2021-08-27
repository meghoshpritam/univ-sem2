from tkinter import Tk, Canvas


def alphabat_A(canvas, fill="#ffffff", outline="#E93B81", width=5):
    canvas.create_line(270, 50, 70, 375, width=width, fill=outline)
    canvas.create_line(270, 50, 240, 380, width=width, fill=outline)
    
    canvas.create_arc(25, 330, 78, 380, start=230, extent=100,
                      width=width, style="arc", outline=outline)
    canvas.create_arc(90, 220, 245, 450, start=130, extent=-
                      150, width=width, style="arc", outline=outline)
    canvas.create_arc(100, 10, 350, 320, start=211, extent=120,
                      width=width, style="arc", outline=outline)
    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    root = Tk()
    root.title('Alphabet - A')
    canvas = Canvas(root, width=500, height=500, background="#ffffff")
    alphabat_A(canvas)
