package vdd.spring.beans.musiciens;

import vdd.spring.exeception.JouerException;

public interface Joueur {
	void jouerMorceau() throws JouerException;
}
