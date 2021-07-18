from base import Helper, Utils, Window


def polygon_scaling(canvas, coordinates, factors):
    colors = Utils()
    coordinates = Helper.string_to_coordinates(coordinates)
    factors = Helper.string_to_coordinates(factors, lambda x: float(x))
    canvas.create_polygon(coordinates, width=5,
                          fill="", outline=colors.secondary)

    new_coordinates = []
    for idx in range(0, len(coordinates), 2):
        x = coordinates[idx]
        y = coordinates[idx+1]

        x = x*factors[0]
        y = y*factors[1]

        new_coordinates.append(x)
        new_coordinates.append(y)
    canvas.create_polygon(new_coordinates, width=5,
                          fill="", outline=colors.primary)


if __name__ == "__main__":
    window = Window(polygon_scaling)
    window.set_title("Polygon scaling")
    window.set_input(["Enter coordinates(x,y)",
                     "Scaling factor(Sfx,Sfy)"])

    window.run()
