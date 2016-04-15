from turtle import *

def drawRectangleWithStretch(xstretch, ystretch):
	goto(50 * xstretch, 0)
	goto(50 * stretch, 50 * ystretch)
	goto(0, 50 * ystretch)
	goto(0, 0)

def main()
	drawRectangleWithStretch(1, 1)
	hideturtle()
	done()