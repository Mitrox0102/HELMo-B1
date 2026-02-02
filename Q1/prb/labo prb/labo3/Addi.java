package labo2;
public class Addi 
public static void main(String[] args) {
String d1S = "6h 21min 30s"; String d2S = "3h 38min 45s";
int hT, mT, sT; int h, m, s; int h1, m1, s1, h2, m2, s2; int d1, d2, dT;
h = d1S.indexOf("h"); m = d1S.indexOf("min"); s = d1S.indexOf("s");
h1 = Integer.parseInt(d1S.substring(0, h).trim();
m1 = Integer.parseInt(d1S.substring(h + 1, m).trim());
s1 = Integer.parseInt(d1S.substring(m + 3, s).trim());
h = d2S.indexOf("h"); m = d2S.indexOf("min"); s = d2S.indexOf("s");
h2 = Integer.parseInt(d2S.substring(0, h).trim());
m2 = Integer.parseInt(d2S.substring(h + 1, m).trim());
s2 = Integer.parseInt(d2S.substring(m + 3, s).trim());
d1 = h1 * 3600 + m1 * 60 + s1; d2 = h2 * 3600.0 + m2 * 60 + s2;
dT = d1 + d2; hT = dT / 3600; dT %= 3600; mT = dT / 60; sT = dT % 60;
System.out.printf("%dh %dmin %ds\n", hT, mT, sT); }
}