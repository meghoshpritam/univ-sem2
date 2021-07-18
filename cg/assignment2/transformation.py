from math import cos, sin, floor, pi


class Transformation():
    @staticmethod
    def rotate(coordinates, angle):
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
        return new_coordinates

    @staticmethod
    def translate(coordinates, factor):
        new_coordinates = []
        for idx in range(0, len(coordinates), 2):
            x = coordinates[idx]
            y = coordinates[idx+1]

            x += factor[0]
            y += factor[1]

            new_coordinates.append(x)
            new_coordinates.append(y)
        return new_coordinates

    @staticmethod
    def scaling(coordinates, factor):
        new_coordinates = []
        for idx in range(0, len(coordinates), 2):
            x = coordinates[idx]
            y = coordinates[idx+1]

            x = x*factor[0]
            y = y*factor[1]

            new_coordinates.append(x)
            new_coordinates.append(y)
        return new_coordinates
