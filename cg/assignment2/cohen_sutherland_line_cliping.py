from base import Helper, Utils, Window

def init(canvas):
    color = Utils()
    w_x_max, w_y_max = w_x_min, w_y_min = Window.canvas_height_width(canvas)
    w_x_min, w_y_min = w_x_min*0.1, w_y_min*0.1
    w_x_max, w_y_max = w_x_max * 0.9, w_y_max*0.9
    canvas.create_rectangle(w_x_min, w_y_min, w_x_max,
                            w_y_max, outline=color.secondary, width=5)

def cohen_sutherland_line_cliping(canvas, start, end):
    color = Utils()
    rcode_begin = [0, 0, 0, 0]
    rcode_end = [0, 0, 0, 0]
    region_code = [0, 0, 0, 0]
    w_x_max, w_y_max = w_x_min, w_y_min = Window.canvas_height_width(canvas)
    w_x_min, w_y_min = w_x_min*0.1, w_y_min*0.1
    w_x_max, w_y_max = w_x_max *0.9, w_y_max*0.9
    flag = 0
    x1, y1 = Helper.string_to_coordinates(start)
    x2, y2 = Helper.string_to_coordinates(end)

    canvas.create_rectangle(w_x_min, w_y_min, w_x_max, w_y_max, outline=color.secondary, width=5)
    canvas.create_line(x1, y1, x2, y2, width=5, fill=color.primary)

    if y1 > w_y_max:
        rcode_begin[0] = 1
        flag = 1

    if y1 < w_y_min:
        rcode_begin[1] = 1
        flag = 1

    if x1 > w_x_max:
        rcode_begin[2] = 1
        flag = 1

    if x1 < w_x_min:
        rcode_begin[3] = 1
        flag = 1

    if y2 > w_y_max:
        rcode_end[0] = 1
        flag = 1

    if y2 < w_y_min:
        rcode_end[1] = 1
        flag = 1

    if x2 > w_x_max:
        rcode_end[2] = 1
        flag = 1

    if x2 < w_x_min:
        rcode_end[3] = 1
        flag = 1

    if flag == 0:
        print("No need of clipping as it is already in window")

    flag = 1
    for i in range(0, 4):
        region_code[i] = rcode_begin[i] and rcode_end[i]
        if region_code[i] == 1:
            flag = 0

    if flag == 0:
        print("\n Line is completely outside the window")
        return

    else:
        slope = (float)(y2-y1)/(x2-x1)
        if rcode_begin[2] == 0 and rcode_begin[3] == 1:
            y1 = y1+(float)(w_x_min-x1)*slope
            x1 = w_x_min

        if rcode_begin[2] == 1 and rcode_begin[3] == 0:
            y1 = y1+(float)(w_x_max-x1)*slope
            x1 = w_x_max

        if rcode_begin[0] == 1 and rcode_begin[1] == 0:
            x1 = x1+(float)(w_y_max-y1)/slope
            y1 = w_y_max

        if rcode_begin[0] == 0 and rcode_begin[1] == 1:
            x1 = x1+(float)(w_y_min-y1)/slope
            y1 = w_y_min

        if rcode_end[2] == 0 and rcode_end[3] == 1:
            y2 = y2+(float)(w_x_min-x2)*slope
            x2 = w_x_min

        if rcode_end[2] == 1 and rcode_end[3] == 0:
            y2 = y2+(float)(w_x_max-x2)*slope
            x2 = w_x_max

        if rcode_end[0] == 1 and rcode_end[1] == 0:
            x2 = x2+(float)(w_y_max-y2)/slope
            y2 = w_y_max

        if rcode_end[0] == 0 and rcode_end[1] == 1:
            x2 = x2+(float)(w_y_min-y2)/slope
            y2 = w_y_min

    canvas.create_line(x1, y1, x2, y2, fill=color.secondary, width=5)

if __name__ == "__main__":
    window = Window(cohen_sutherland_line_cliping)
    window.set_title("Cohen Sutherland Line Cliping")
    window.set_input(["Starting point(x,y)", "Ending point(x,y)"])
    window.initial(init)
    window.run()
