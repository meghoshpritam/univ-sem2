from base import Window, Utils


def init(canvas):
    height, width = Window.canvas_height_width(canvas)
    x_w_max = width*0.9
    y_w_max = height*0.9
    x_w_min = width*0.1
    y_w_min = height*0.1

    x_v_max = width*0.8
    y_v_max = height*0.8
    x_v_min = width*0.2
    y_v_min = height*0.2

    color = Utils()
    canvas.create_rectangle(x_w_max, y_w_max, x_w_min,
                            y_w_min, outline=color.secondary, fill="", width=5)
    canvas.create_rectangle(x_v_max, y_v_max, x_v_min,
                            y_v_min, outline=color.primary, fill="", width=5)


def Window_to_viewport(canvas, x, y):
    color = Utils()
    height, width = Window.canvas_height_width(canvas)
    x_w_max = width*0.9
    y_w_max = height*0.9
    x_w_min = width*0.1
    y_w_min = height*0.1

    x_v_max = width*0.8
    y_v_max = height*0.8
    x_v_min = width*0.2
    y_v_min = height*0.2

    sx = (x_v_max - x_v_min) / (x_w_max - x_w_min)
    sy = (y_v_max - y_v_min) / (y_w_max - y_w_min)

    x1 = x_v_min + ((x - x_w_min) * sx)
    y1 = y_v_min + ((y - y_w_min) * sy)

    init(canvas)

    canvas.create_oval(x, y, x, y, outline=color.secondary, fill="", width=5)

    canvas.create_oval(int(x1), int(y1), int(
        x1), int(y1), outline=color.primary, fill="", width=5)


if __name__ == "__main__":
    window = Window(Window_to_viewport)
    window.set_title("Window to Viewport")
    window.set_input(["Enter x: ", "Enter y: "])
    window.set_input_type("int")
    window.initial(init)
    window.run()


