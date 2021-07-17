from tkinter import Tk, Canvas, Frame, Button, BOTH, TOP, BOTTOM, Entry, StringVar, OptionMenu, Label, E, W

root = Tk()

entry = Entry(root)
stvar = StringVar()
stvar.set("one")

canvas = Canvas(
    root, width=300, height=200, background='white')
canvas.grid(row=0, column=1)

frame = Frame(root)
frame.grid(row=0, column=0, sticky="n")

option = OptionMenu(frame, stvar, "one", "two", "three")
label1 = Label(frame, text="Figure").grid(row=0, column=0, sticky="nw")
label2 = Label(frame, text="X").grid(row=1, column=0, sticky="w")
label3 = Label(frame, text="Y").grid(row=2, column=0, sticky="w")
option.grid(row=0, column=1, sticky="nwe")
entry = Entry(frame).grid(row=1, column=1, sticky=E + W)
entry1 = Entry(frame).grid(row=2, column=1, sticky=E)
Button1 = Button(frame, text="Draw").grid(row=3, column=1, sticky="we")
canvas.create_rectangle(80, 80, 120, 120, fill="blue")

root.mainloop()
