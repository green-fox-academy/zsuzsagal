public class TodoPrint {
    public static void main(String... args){
        String todoText = " - Buy milk\n";
        /*
        Add "My todo:" to the beginning of the todoText
        Add " - Download games" to the end of the todoText
        Add " - Diablo" to the end of the todoText but with indention

        Expected output:

        My todo
        - Buy milk
        - Download games
        - Diablo
*/

        todoText =  "My todo:\n" + todoText.substring(0) + " - Download games\n" + " - Diablo";
        System.out.println(todoText);
    }
}