PImage milit;
void setup(){
	size(400,200);
//	in Processing, you must load the images inside of the setup function
	milit = loadImage("/WarGame/skins/img/militar.jpg");
}
void draw(){
	background(255);
//	displaying the images simply pass the function the variable and a location
	image(milit,mouseX,mouseY);
}