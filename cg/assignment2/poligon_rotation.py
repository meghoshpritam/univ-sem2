from math import cos, sin, floor, pi
from base import Helper, Utils, Window


def polygon_rotation(canvas, coordinates, angle):
    colors = Utils()
    coordinates = Helper.string_to_coordinates(coordinates)
    angle = int(angle, 10)
    canvas.create_polygon(coordinates, width=5,
                          fill="", outline=colors.secondary)

    if angle != 0:
        new_coordinates = []
        for idx in range(0, len(coordinates), 2):
            x = coordinates[idx]
            y = coordinates[idx+1]

            c = cos(angle * pi/180)
            s = sin(angle * pi/180)
            x = floor(x * c + y * s)
            y = floor(-x * s + y * c)

            new_coordinates.append(x)
            new_coordinates.append(y)
        canvas.create_polygon(new_coordinates, width=5,
                              fill="", outline=colors.primary)


if __name__ == "__main__":
    window = Window(polygon_rotation)
    window.set_title("Polygon rotation")
    window.set_input(["Enter coordinates(x,y)",
                     "Angle of rotation"])

    window.run()
