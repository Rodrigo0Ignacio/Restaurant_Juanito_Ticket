package controlador;

import java.awt.Color;

public class Color_RGB {
	private int r = 0;
	private int g = 0;
	private int b = 0;

	public Color_RGB() {

	}

	public Color rgbColor_rojo() {
		this.r = 242;
		this.g = 41;
		this.b = 28;

		return new Color(r, g, b);

	}

	public Color rgbColor_verde() {
		this.r = 0;
		this.g = 143;
		this.b = 57;

		return new Color(r, g, b);

	}

}
