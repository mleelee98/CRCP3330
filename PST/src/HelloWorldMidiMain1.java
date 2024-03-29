
/*
 * c2017-2019 Courtney Brown 
 * 
 * Class: H
 * Description: Demonstration of MIDI file manipulations, etc. & 'MelodyPlayer' sequencer
 * 
 */

import processing.core.*;

import java.util.*; 

//importing the JMusic stuff
import jm.music.data.*;
import jm.JMC;
import jm.util.*;
import jm.midi.*;

import java.io.UnsupportedEncodingException;
import java.net.*;

//import javax.sound.midi.*;

			//make sure this class name matches your file name, if not fix.
public class HelloWorldMidiMain1<T> extends PApplet {
	
	MelodyPlayer player; 
	MidiFileToNotes midiNotes;
	static Tree<String> tree1=new Tree<String>();
	static Tree<String> tree2=new Tree<String>();
	static Tree<String> tree3=new Tree<String>();
	static Tree<Integer> tree4=new Tree<Integer>();

	public static void main(String[] args) {
	PApplet.main("HelloWorldMidiMain1"); 
		
	}

	public void settings() {
		size(500, 500);
	}

	public void setup() {
		fill(120, 50, 240);
		textSize(20);
		text("abracadabra L=3 P=0.1, Press 1", 10, 30); 
		text("acadaacbda L=3 P=0.1, Press 2", 10, 50); 
		text("abcccdaadcdaabcadad L=3 P=0.1, Press 3", 10, 70);
		text("Mary Had a Little Lamb L=3 P=0.1, Press 4", 10, 90);
		text("abracadabra L=3 P=0.2, Press 5", 10, 130); 
		text("acadaacbda L=3 P=0.2, Press 6", 10, 150); 
		text("abcccdaadcdaabcadad L=3 P=0.2, Press 7", 10, 170);
		text("Mary Had a Little Lamb L=3 P=0.2, Press 8", 10, 190);


		// returns a url
		String filePath = getPath("mid/MaryHadALittleLamb.mid");
	//	playMidiFile(filePath);
		midiNotes = new MidiFileToNotes(filePath); //creates a new MidiFileToNotes -- reminder -- ALL objects in Java must 
		//be created with "new". Note how every object is a pointer or reference. Every. single. one.


//		// which line to read in --> this object only reads one line (or ie, voice or ie, one instrument)'s worth of data from the file
//		midiNotes.setWhichLine(0);
//
//		player = new MelodyPlayer(this, 100.0f);
//
//		player.setup();
//
//		player.setMelody(midiNotes.getPitchArray());
//		player.setRhythm(midiNotes.getRhythmArray());
//		

	}

	public void draw() {


	}

	//this finds the absolute path of a file
	String getPath(String path) {

		String filePath = "";
		try {
			filePath = URLDecoder.decode(getClass().getResource(path).getPath(), "UTF-8");

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}

	//this function is not currently called. you may call this from setup() if you want to test
	//this just plays the midi file -- all of it via your software synth. You will not use this function in upcoming projects
	//but it could be a good debug tool.
	void playMidiFile(String filename) {
//		Score theScore = new Score("Temporary score");
//		Read.midi(theScore, filename);
//		Play.midi(theScore);
	}

	//this starts & restarts the melody.
	public void keyPressed() {
		if (key == '1') {
			String[] test1= {"a","b","r","a","c","a","d","a","b","r","a"};
			ArrayList<String> dataA= new ArrayList <String> (Arrays.asList(test1));
			tree1.train(dataA,0.1);
		}
		if (key == '2') {
			String[] test2= {"a","c","a","d","a","a","c","b","d","a"};
			ArrayList<String> dataB= new ArrayList <String> (Arrays.asList(test2));
			tree2.train(dataB,0.1);
		}
		if (key == '3') {
			String[] test3= {"a","b","c","c","c","d","a","a","d","c","d","a","a","b","c","a","d","a","d"};
			ArrayList<String> dataC= new ArrayList <String> (Arrays.asList(test3));
			tree3.train(dataC,0.1);
		}
		if (key == '4') {
			ArrayList<Integer> dataD= new ArrayList <Integer>(midiNotes.getPitchArray());
			tree4.train(dataD,0.1);
		}
		if (key == '5') {
			String[] test1= {"a","b","r","a","c","a","d","a","b","r","a"};
			ArrayList<String> dataA= new ArrayList <String> (Arrays.asList(test1));
			tree1.train(dataA,0.2);
		}
		if (key == '6') {
			String[] test2= {"a","c","a","d","a","a","c","b","d","a"};
			ArrayList<String> dataB= new ArrayList <String> (Arrays.asList(test2));
			tree2.train(dataB,0.2);
		}
		if (key == '7') {
			String[] test3= {"a","b","c","c","c","d","a","a","d","c","d","a","a","b","c","a","d","a","d"};
			ArrayList<String> dataC= new ArrayList <String> (Arrays.asList(test3));
			tree3.train(dataC,0.2);
		}
		if (key == '8') {
			ArrayList<Integer> dataD= new ArrayList <Integer>(midiNotes.getPitchArray());
			tree4.train(dataD,0.2);
		}

	}
	
}
