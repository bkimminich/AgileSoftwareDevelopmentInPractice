package de.kimminich.agile.examples.lecture3.specificbean;

import javax.swing.ImageIcon;

public class LabelledIcon {
	
	private ImageIcon image;
	private String label;

	public LabelledIcon(ImageIcon image, String label) {
		super();
		this.image = image;
		this.label = label;
	}

	public ImageIcon getImage() {
		return image;
	}

	public String getLabel() {
		return label;
	}

}
