package game;

public class Levels {

    /*
    Nummers komen overeen met de volgende objecten:
    0 = Empty
    1 = Blue barricade
    2 = Blue stone
    3 = Eindveld
    4 = Green barricade
    5 = Green stone
    6 = Player
    7 = Red barricade
    8 = Red stone
    9 = Wall
    */

    private static int[][] level0 ={{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 6, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}};

    private static int[][] level1 ={{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 6, 0, 0, 0, 0, 4, 4, 9, 8, 9},
                                    {9, 9, 7, 7, 5, 0, 0, 0, 0, 0, 9},
                                    {9, 4, 4, 7, 7, 4, 0, 9, 1, 0, 9},
                                    {9, 9, 4, 0, 0, 0, 0, 9, 1, 0, 9},
                                    {9, 1, 2, 0, 4, 9, 9, 9, 9, 4, 9},
                                    {9, 1, 9, 0, 0, 1, 7, 9, 7, 1, 9},
                                    {9, 1, 9, 1, 9, 7, 4, 9, 7, 4, 9},
                                    {9, 4, 0, 9, 0, 1, 7, 0, 1, 4, 9},
                                    {9, 7, 0, 4, 0, 4, 0, 4, 7, 3, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}};

    private static int[][] level2 ={{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 6, 9, 0, 0, 0, 0, 4, 7, 8, 9},
                                    {9, 0, 0, 0, 5, 8, 0, 1, 1, 7, 9},
                                    {9, 0, 4, 7, 7, 4, 0, 7, 7, 5, 9},
                                    {9, 0, 4, 0, 0, 0, 0, 4, 4, 4, 9},
                                    {9, 0, 1, 0, 4, 9, 9, 7, 4, 4, 9},
                                    {9, 0, 9, 0, 0, 1, 7, 7, 9, 9, 9},
                                    {9, 2, 9, 1, 9, 7, 4, 9, 7, 4, 9},
                                    {9, 4, 0, 9, 0, 1, 7, 0, 1, 4, 9},
                                    {9, 7, 0, 4, 0, 4, 0, 4, 1, 3, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}};

    public static int[][] level3 = {{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                                    {9, 6, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                                    {9, 0, 0, 0, 0, 0, 0, 0, 0, 3, 9},
                                    {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}};



    /**
     * @param level is het nummer van de level-array die moet worden teruggegeven
     * @return een van de level arrays hierboven die overeenkomt met @param level.
     */
    public int [][] getLevel(int level){
        if(level == 1){
            return level1;
        } else if(level == 2){
            return level2;
        } else if(level == 3){
            return level3;
        } else
            return level0;
    }
}