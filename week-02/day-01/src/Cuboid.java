public class Cuboid {
    public static void main(String[] args) {
        // Write a program that stores 3 sides of a cuboid as variables (doubles)
        // The program should write the surface area and volume of the cuboid like:
        //
        // Surface Area: 600
        // Volume: 1000


        int a = 3;
        int b = 5;
        int c = 10;

        int surfaceArea = 2*((a*b)+(b*c)+(c*a));
        int volume = a*b*c;

        System.out.println(surfaceArea);
        System.out.println(volume);
    }
}
