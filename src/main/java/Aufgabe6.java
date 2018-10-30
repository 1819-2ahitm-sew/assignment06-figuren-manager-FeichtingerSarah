abstract class Figur {
    public static void main(String[] args) {
        Figur [] figur = new Figur[5];
        figur[0] = new Dreieck();
        figur[1] = new Kreis();
        figur[2] = new Quadrat();
        figur[3] = new Ellipse();
        figur[4] = new Rechteck();

        for (int i = 0; i < figur.length; i++) {
            System.out.println(figur[i].output());
        }
    }


    public double multiplikator(double wert)
    {
        wert = wert*100;
        int zwischenspeicher = (int) wert;
        wert = zwischenspeicher/100.0;

        return wert;
    }


    abstract double area();           // berechnet den Flächeninhalt
    abstract double circumference();  // berechnet den Umfang
    abstract String output();         // erstellt die Zeichenkette zur Datenausgabe
}

class Dreieck extends Figur{
    int seite1 = 10;
    int seite2 = 15;
    int winkel = 45;

    @Override public double area() {
        return (seite1*seite2)/2;
    }

    @Override public double circumference(){
        return seite1 + seite2 + seite2;
    }

    @Override public String output(){
        return "Dreieck mit der Seite1 = " + seite1 + " und Seite2 = " + seite2 +
                ": Umfang -> " + circumference() + ", Fläche -> " + area();
    }
}

class Quadrat extends Figur{
    int seite = 3;

    @Override public double area() {
        return seite * seite;
    }

    @Override public double circumference(){
        return seite*4;
    }

    @Override public String output(){
        return "Quadrat mit der Seitenlänge = " + seite +
                ": Umfang -> " + circumference() + ", Fläche -> " + area();
    }
}

class Rechteck extends Figur{
    int seite1 = 5;
    int seite2 = 10;

    @Override public double area() {
        return seite1*seite2;
    }

    @Override public double circumference(){
        return (seite1*2) + (seite2*2);
    }

    @Override public String output(){
        return "Rechteck mit der Seite1 = " + seite1 + " und Seite2 = " + seite2 +
                ": Umfang -> " + circumference() + ", Fläche -> " + area();
    }
}

class Kreis extends Figur{
    int radius = 5;

    @Override public double area() {
        return multiplikator(radius * radius * Math.PI);
    }

    @Override public double circumference(){
        return multiplikator(2*radius * Math.PI);
    }

    @Override public String output(){
        return "Kreis mit dem Radius = " + radius +
                ": Umfang -> " + circumference() + ", Fläche -> " + area();
    }
}

class Ellipse extends Figur{
    int hauptachse = 10;
    int nebenachse = 6;

    @Override public double area() {
        return multiplikator(hauptachse * nebenachse * Math.PI);
    }

    @Override public double circumference(){
        return multiplikator(Math.PI*Math.sqrt(2*((hauptachse*hauptachse) + (nebenachse*nebenachse))));
    }

    @Override public String output(){
        return "Ellipse mit der Hauptachse = " + hauptachse + " und Nebenachse = " + nebenachse +
                ": Umfang -> " + circumference() + ", Fläche -> " + area();
    }
}

