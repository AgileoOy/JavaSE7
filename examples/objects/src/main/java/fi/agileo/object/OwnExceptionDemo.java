package fi.agileo.object;

class PointsException extends Exception {

    public PointsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String toString() {
        return super.toString();
    }  
}

/*
 Exam-luokka, jossa metodi setPoints() voi aiheuttaa PointsException-tyyppisen poikkeuksen, jos parametrina syötetyt pisteet ylittävät sallitun maksimipistemäärän.
*/

class Exam {

    private int points;
    private int max;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) throws PointsException {
        if (points > this.max) {
            throw new PointsException("Error: points>max: "
                    + points + " > " + max + "!");
        }
        this.points = points;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String toString() {
        return "Exam{" + "points=" + points
                + ", max=" + max + '}';
    }
}

public class OwnExceptionDemo {

    public static void main(String[] args)
            throws PointsException {
        Exam test = new Exam();
        try {
            test.setMax(30);
            test.setPoints(26);
            System.out.println(test);
            test.setMax(20);
            System.out.println(test);
            test.setPoints(26);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}