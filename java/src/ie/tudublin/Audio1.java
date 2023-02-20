package ie.tudublin;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

	public void settings()
	{
		size(1024, 500);
	}

	int frameSize = 1024; //1024 samples
	public void setup() {
		colorMode(HSB);
		background(0);

		minim = new Minim(this);
		
		ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16); //ai = audio input, 44100 = sample rate, 16 = 16bit samples
		ab = ai.mix; //ab = audio buffer

		smooth();
		
	}

	
	
	public void draw()
	{	
		background(0);
		stroke(255);
		
		float half = height/2;
		float cgap = 255 / (float)ab.size();

		//calculate the average of buffer, trying to get estimate of how loud the audio is
		//average absolute value : abs
		
		float avg = 0;
		float sum = 0;
		for(int i = 0; i < ab.size(); i++)
		{
			//draw line for every element in the buffer
			//line(i, half, i, half +ab.get(i)); //ab is an ArrayList
			//values go between -1 and +1
			stroke(cgap * i,255,255);
			line(i, half, i, half +ab.get(i) * half);
			sum += abs(ab.get(i));

		}

		avg = sum/ (float)ab.size();

		float r = avg*200;
		float lerpedR = 0;
		lerpedR = lerp(lerpedR, r, 0.1f); //every frame it goes 10% closer to r instead of immediately, so it looks smoother
		circle(100,200,lerpedR);

		//lerp(1,b,t); linear interpolation - used for smoothing

		//lerp(10,20,(float) 0.5);

		/*
		float lerp(float a, float b, float t)
		{
			return a + (b-a)*t;
		}
		 */
		//map();
		

	}
}
