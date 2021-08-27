import turtle
t = turtle.Turtle()
turtle.speed(200)
t.pensize(4)
s = 5
t.left(90)
t.forward(s)
# t.right(1)
for i in range(10):
    t.right(20)
    t.forward(8)
for i in range(5):
    t.right(1)
    t.forward(30)
t.forward(30)
for i in range(60):
    t.right(5)
    t.forward(2)
for i in range(8):
    t.right(10)
    t.forward(2)
t.left(70)
t.forward(80)
for i in range(20):
    t.left(5)
    t.forward(5)

turtle.done()
