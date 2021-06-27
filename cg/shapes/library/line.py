# docs: https://tkdocs.com/tutorial/canvas.html
from tkinter import Tk, Canvas


def draw_line(starting=(1, 1), ending=(20, 20), canvas_width=500, canvas_height=500, canvas_bg="#ffffff", line_color="#E93B81",
              line_width=4):
    root = Tk()
    root.title('Line')

    center = canvas_width*0.5, canvas_height*0.5

    canvas = Canvas(root, width=canvas_width,
                    height=canvas_height, background=canvas_bg)

    canvas.create_line(canvas_width*0.5, 0,
                       canvas_width*0.5, canvas_height, fill="#F0F0F0", width=1)
    canvas.create_line(0, canvas_height*0.5,
                       canvas_width, canvas_height*0.5, fill="#F0F0F0", width=1)

    canvas.create_line(center[0] + starting[0], - starting[1] + center[1],
                       center[0] + ending[0], - ending[1] + center[1], fill=line_color, width=line_width)

    canvas.pack()
    root.mainloop()


if __name__ == "__main__":
    start_point = input("Enter stating point(separated by comma[,] max 250): ")
    end_point = input("Enter ending point(separated by comma[,] max 250): ")
    s_p = start_point.split(',')
    e_p = end_point.split(',')
    pair1 = (int(s_p[0].strip(), 10), int(s_p[1].strip(), 10))
    pair2 = (int(e_p[0].strip(), 10), int(e_p[1].strip(), 10))
    draw_line(starting=pair1, ending=pair2)
