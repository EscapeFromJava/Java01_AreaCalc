import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Выберите тип фигуры:");
            System.out.println("[1] - окружность");
            System.out.println("[2] - треугольник");
            System.out.println("[3] - прямоугольник");
            int temp = scan.nextInt();

            switch (temp) {
                case 1: {
                    System.out.println("Введите радиус окружности: ");
                    double radius = scan.nextDouble();
                    if (radius > 0) {
                        Circle circ = new Circle(radius);
                        System.out.println("Площадь окружности: " + circ.GetArea());
                    }
                    break;
                }
                case 2: {
                    System.out.println("Введите 3 грани треугольника: ");
                    double edge1 = scan.nextDouble();
                    double edge2 = scan.nextDouble();
                    double edge3 = scan.nextDouble();
                    if (edge1 + edge2 > edge3 &&
                            edge1 + edge3 > edge2 &&
                            edge2 + edge3 > edge1 &&
                            edge1 > 0 && edge2 > 0 && edge3 > 0) {
                        Triangle tri = new Triangle(edge1, edge2, edge3);
                        System.out.println("Площадь треугольника: " + tri.GetArea());
                    }
                    break;
                }
                case 3: {
                    System.out.println("Введите 2 грани прямоугольника: ");
                    double edge1 = scan.nextDouble();
                    double edge2 = scan.nextDouble();
                    if (edge1 > 0 && edge2 > 0) {
                        Rectangle rect = new Rectangle(edge1, edge2);
                        System.out.println("Площадь прямоугольника: " + rect.GetArea());
                    }
                    break;
                }
                default:
                    System.out.println("Некорректный ввод");
            }
        }
    }
}

interface Calc {
    double GetArea();
}

class Circle implements Calc {
    private double _radius;

    public Circle(double _radius) {
        this._radius = _radius;
    }

    @Override
    public double GetArea() {
        return Math.PI * Math.pow(_radius, 2);
    }
}

class Triangle implements Calc {

    private double _edge1;
    private double _edge2;
    private double _edge3;

    public Triangle(double _edge1, double _edge2, double _edge3) {
        this._edge1 = _edge1;
        this._edge2 = _edge2;
        this._edge3 = _edge3;
    }

    @Override
    public double GetArea() {
        double p = (_edge1 + _edge2 + _edge3) / 2;
        return Math.sqrt(p * (p - _edge1) * (p - _edge2) * (p - _edge3));
    }
}

class Rectangle implements Calc {
    private double _edge1;
    private double _edge2;

    public Rectangle(double _edge1, double _edge2) {
        this._edge1 = _edge1;
        this._edge2 = _edge2;
    }

    @Override
    public double GetArea() {
        return _edge1 * _edge2;
    }
}