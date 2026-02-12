package chap6;

import io.*;

public class OperateursLogiques {

	public static void main(String[] args) {
		double x = Console.lireDouble("un réel ? ");
		
		//1. [8;10[
		if (x >= 8 && x < 10) {
			System.out.println(x + " est un élément de l'intervalle 1.");
		} else {
			System.out.println(x + " n'est pas un élément de l'intervalle 1.");
		}
		
		if (x <= -5 && x >= 5) {
			System.out.println(x + " est un élément de l'intervalle 2.");
		} else {
			System.out.println(x + " n'est pas un élément de l'intervalle 2.");
		}
		
		if (x <= 0 && (x >= 5 && x < 10)) {
			System.out.println(x + " est un élément de l'intervalle 3.");
		} else {
			System.out.println(x + " n'est pas un élément de l'intervalle 3.");
		}
		
		if (x >= -5 && x <= 15 && x != 0) {
			System.out.println(x + " est un élément de l'intervalle 4.");
		} else {
			System.out.println(x + " n'est pas un élément de l'intervalle 4.");
		}
	}
	
}
