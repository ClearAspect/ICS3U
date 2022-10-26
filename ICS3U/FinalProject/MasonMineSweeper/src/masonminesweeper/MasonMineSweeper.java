/*
Roan Mason
06/06/22

MineSweeper
Assignment details - https://docs.google.com/document/d/1CclBSlDpYY4QR3vMyK_R35uNEghr9cCTOz8gZIz7yoc/edit
The plan - https://docs.google.com/document/d/1FfwolH5bZqCYfmU9aqsqMmdIJDWf1Fdz3CQjd5koz-8/edit
flag colour - (228, 46, 25)
*/
package masonminesweeper;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


/**
 *
 * @author romas6904
 */
public class MasonMineSweeper extends javax.swing.JFrame {
    
    public JButton[][] boardReal = new JButton[8][10]; //Array of buttons on the board
    public int[][] boardValues = new int[8][10]; //Value assigned to each button
    public int[][] proximityValues = new int[8][10]; //Mine Proximity values
    public boolean[][] flagTiles = new boolean[8][10]; //Array that stores the flags
    public boolean firstClick = true; //First click on board. Tells program whether to create new mine or not.
    public int spacesLeft = 70; //Spaces before win. Board spaces - # of mines
    public int flags = 10; //Mines on board/needed flags. (Can go negative)
    
    //Values of each type of value that can be stored in boardValues
    public final int COVERED_TILE = 0;
    public final int UNCOVERED_TILE = 9; 
    public final int COVERED_NEIGHBOR_TILE = 10; 
    public final int UNCOVERED_NEIGHBOR_TILE = 11; 
    public final int MINE_TILE = 12;
    
    public boolean playing = false; //Game isnt running
    public Icon flagIcon = new ImageIcon("src/masonminesweeper/Flag.png");

        
    /**
     * Creates new form MasonMineSweeper
     */
    public MasonMineSweeper() {
        initComponents();
        
        getContentPane().setBackground(new Color(74,117,44));
        
        //Place buttons into the board array
        boardReal[0][0] = btn00;
        boardReal[0][1] = btn01;
        boardReal[0][2] = btn02;
        boardReal[0][3] = btn03;
        boardReal[0][4] = btn04;
        boardReal[0][5] = btn05;
        boardReal[0][6] = btn06;
        boardReal[0][7] = btn07;
        boardReal[0][8] = btn08;
        boardReal[0][9] = btn09;
        boardReal[1][0] = btn10;
        boardReal[1][1] = btn11;
        boardReal[1][2] = btn12;
        boardReal[1][3] = btn13;
        boardReal[1][4] = btn14;
        boardReal[1][5] = btn15;
        boardReal[1][6] = btn16;
        boardReal[1][7] = btn17;
        boardReal[1][8] = btn18;
        boardReal[1][9] = btn19;
        boardReal[2][0] = btn20;
        boardReal[2][1] = btn21;
        boardReal[2][2] = btn22;
        boardReal[2][3] = btn23;
        boardReal[2][4] = btn24;
        boardReal[2][5] = btn25;
        boardReal[2][6] = btn26;
        boardReal[2][7] = btn27;
        boardReal[2][8] = btn28;
        boardReal[2][9] = btn29;
        boardReal[3][0] = btn30;
        boardReal[3][1] = btn31;
        boardReal[3][2] = btn32;
        boardReal[3][3] = btn33;
        boardReal[3][4] = btn34;
        boardReal[3][5] = btn35;
        boardReal[3][6] = btn36;
        boardReal[3][7] = btn37;
        boardReal[3][8] = btn38;
        boardReal[3][9] = btn39;
        boardReal[4][0] = btn40;
        boardReal[4][1] = btn41;
        boardReal[4][2] = btn42;
        boardReal[4][3] = btn43;
        boardReal[4][4] = btn44;
        boardReal[4][5] = btn45;
        boardReal[4][6] = btn46;
        boardReal[4][7] = btn47;
        boardReal[4][8] = btn48;
        boardReal[4][9] = btn49;
        boardReal[5][0] = btn50;
        boardReal[5][1] = btn51;
        boardReal[5][2] = btn52;
        boardReal[5][3] = btn53;
        boardReal[5][4] = btn54;
        boardReal[5][5] = btn55;
        boardReal[5][6] = btn56;
        boardReal[5][7] = btn57;
        boardReal[5][8] = btn58;
        boardReal[5][9] = btn59;
        boardReal[6][0] = btn60;
        boardReal[6][1] = btn61;
        boardReal[6][2] = btn62;
        boardReal[6][3] = btn63;
        boardReal[6][4] = btn64;
        boardReal[6][5] = btn65;
        boardReal[6][6] = btn66;
        boardReal[6][7] = btn67;
        boardReal[6][8] = btn68;
        boardReal[6][9] = btn69;
        boardReal[7][0] = btn70;
        boardReal[7][1] = btn71;
        boardReal[7][2] = btn72;
        boardReal[7][3] = btn73;
        boardReal[7][4] = btn74;
        boardReal[7][5] = btn75;
        boardReal[7][6] = btn76;
        boardReal[7][7] = btn77;
        boardReal[7][8] = btn78;
        boardReal[7][9] = btn79;
        
                
    }
    
    /**
     * Checks if space is on the board
     * 
     * @param row - row on the array
     * @param col - column on the array
     * @return - a boolean
     */
    public boolean isValidSpace(int row, int col) {
        //Return true if the space is inside the board dimensions
        return (row >= 0) && (row < 8) && (col >= 0) && (col < 10);
    }
    
    /**
     * Simple check to detect a mine
     * 
     * @param row - row on the array
     * @param col - column on the array
     * @return - a boolean
     */
    public boolean isMine(int row, int col) {
        //Return true if the board values say its a mine
        return boardValues[row][col] == MINE_TILE;
    }
    
    /**
     * https://www.geeksforgeeks.org/cpp-implementation-minesweeper-game/
     * - used some ideas for detecting mines. 
     * - code is mostly the same. not much I could do about that since detecting the mines is so simple. However, did not copy/paste
     * 
     * Test a adjacent tiles for mines (8 of them)
     * 
     *        NW    North     NE
     *                |
     * col -  West - Tile - East
     *                |
     *        SW    South     SE
     *                |
     *                row 
     * 
     * Current tile     (row, col)
     * North            (row, col-1)
     * South            (row, col+1)
     * East             (row+1, col)
     * West             (row-1, col)
     * North-East       (row+1, col-1)
     * North-West       (row-1, col-1)
     * South-East       (row+1, col+1)
     * South-West       (row-1, col+1)
     * 
     * 
     * @param row - row on the array
     * @param col - column on the array
     * @return - an integer
     */
    public int surroundingMines(int row, int col) {
        int numOfMines = 0; //Mines in proximity to the initial tile
        //North space
        if (isValidSpace(row,col-1) == true) { //space is on board
            if (isMine(row,col-1) == true) { //north space is a mine
                numOfMines++; //increase the number of mines by one
            }
        }
        
        //East space
        if (isValidSpace(row+1,col) == true) {
            if (isMine(row+1,col) == true) {
                numOfMines++;
            }
        }
        
        //South space
        if (isValidSpace(row,col+1) == true) {
            if (isMine(row,col+1) == true) {
                numOfMines++;
            }
        }
        
        //West space
        if (isValidSpace(row-1,col) == true) {
            if (isMine(row-1,col) == true) {
                numOfMines++;
            }
        }
        
        //North West space
        if (isValidSpace(row-1,col-1) == true) {
            if (isMine(row-1,col-1) == true) {
                numOfMines++;
            }
        }
        
        //North East space
        if (isValidSpace(row+1,col-1) == true) {
            if (isMine(row+1,col-1) == true) {
                numOfMines++;
            }
        }
        
        //South West space
        if (isValidSpace(row-1,col+1) == true) {
            if (isMine(row-1,col+1) == true) {
                numOfMines++;
            }
        }
        
        //South East space
        if (isValidSpace(row+1,col+1) == true) {
            if (isMine(row+1,col+1) == true) {
                numOfMines++;
            }
        }
        
        return numOfMines;
    }
    
    /**
     * Resets the board and all values
     * 
     */
    public void initialize() {
        firstClick = true; //re-enable the clicks to create mines
        flags = 10; //reset number of flags
        spacesLeft = 70; //reset spaces left to win
        lblFlagCount.setText(flags+""); //reset label
        playing = false; //Game is active but actions are limited
        //Update status that the board is playing
        lblStatus.setForeground(new Color(255, 255, 255));
        lblStatus.setText("Playing!"); 
        
        for (int i = 0; i < boardValues.length; i++) { //Cycle through the board
            for (int j = 0; j < boardValues[i].length; j++) {
                boardValues[i][j] = COVERED_TILE; //set tiles as covered
                flagTiles[i][j] = false; //unflag any tiles
                boardReal[i][j].setIcon(null); //remove flag icon
                proximityValues[i][j] = 0; //reset mine proximity
                boardReal[i][j].setText(""); //remove text
                setBackColor(i,j); //Reset the colour of the tile
            }
        }
    }
    
    /**
     * Randomly generates non-repeating mines that aren't near the user's first click. Places them into an array which stores there location
     * 
     * @param firstRow - Row of where the users first click is 
     * @param firstCol - Column of where the users first click is
     * @return - an array of integers
     */
    public int[][] createMines(int firstRow, int firstCol) {
        int[][] mineLocations = new int[10][2]; //array which stores the row and column of each mine
        //create variables
        int mineRow;
        int mineCol;
        
        
        for (int i = 0; i < mineLocations.length; i++) { //Loop tile array is filled
            //generate a mine in a random space
            mineRow = (int)(Math.random() * 8); 
            mineCol = (int)(Math.random() * 10);
            for (int j = 0; j <= i;) { //check through already created mines
                //if a mine repeats or the mine generated is near the users first click
                if ((mineLocations[j][0] == mineRow && mineLocations[j][1] == mineCol) || isIllegalMine(firstRow, firstCol, mineRow, mineCol) == true) {
                    //generate a new mine in a random space
                    mineRow = (int)(Math.random() * 8);
                    mineCol = (int)(Math.random() * 10);
                    //reset the cycle. Cycles through all generated mines again
                    j = 0;
                } else {
                    //if the mine is valid then check the next mine
                    j++;
                }
            }
            //Once a non-repeating mine that isnt near the users first click, put it in the array.
            
            mineLocations[i][0] = mineRow;
            mineLocations[i][1] = mineCol;
        }
        return mineLocations; 
    }
    
    /**
     * Checks if a mine in one of the 8 adjacent tiles to the users click or where the user clicked
     * This ensures that the game will start with enough revealed tiles. (Prevents user from having to guess)
     * 
     * @param firstRow - Row of where the users first click is 
     * @param firstCol - Column of where the users first click is
     * @param mineRow - Row of mine being tested
     * @param mineCol - Column of mine being tested
     * @return - a boolean
     */
    public boolean isIllegalMine(int firstRow, int firstCol, int mineRow, int mineCol) {
        /*
        Return statement basically checks if the location of the mine is the same as the location of
        the users click or any squares around it.
         */
        return (firstRow == mineRow && firstCol == mineCol) || 
                (firstRow == mineRow && (firstCol - 1) == mineCol) ||
                (firstRow == mineRow && (firstCol + 1) == mineCol) ||
                ((firstRow + 1) == mineRow && firstCol == mineCol) ||
                ((firstRow - 1) == mineRow && firstCol == mineCol) ||
                ((firstRow + 1) == mineRow && (firstCol - 1) == mineCol) ||
                ((firstRow - 1) == mineRow && (firstCol - 1) == mineCol) ||
                ((firstRow + 1) == mineRow && (firstCol + 1) == mineCol) ||
                ((firstRow - 1) == mineRow && (firstCol + 1) == mineCol); 
        //true if the mine is in one of these spaces
        //false if the mine isnt in one of the spaces
        
    }
    
    /**
     * Used to take mines created and place them around the board
     * 
     * @param firstRow - Row of where the users first click is 
     * @param firstCol - Column of where the users first click is
     */
    public void placeMines(int firstRow, int firstCol) {
        int[][] mineLocations = createMines(firstRow, firstCol); //create mines 
        for (int i = 0; i < mineLocations.length; i++) { //Cycle all ten mines into the board
            boardValues[mineLocations[i][0]][mineLocations[i][1]] = MINE_TILE; //use coordinates stored to place mine
        }
        for (int i = 0; i < boardReal.length; i++) { //Cycle through the board
            for (int j = 0; j < boardReal[i].length; j++) {
                if (!isMine(i, j)) { //if its not a mine
                    proximityValues[i][j] = surroundingMines(i,j); //Get the number of mines around the tile
                    
                    if (proximityValues[i][j] != 0) { //if spaces isnt 0
                        boardValues[i][j] = COVERED_NEIGHBOR_TILE; //tile is stored as a covered mine neighboring tile
                    }
                }
            }
        }
        
        
    }
    
    /**
     * https://vaibhavsethia07.medium.com/flood-fill-algorithm-1424de9863da
     * - Used to help think about the flooding
     * 
     * Fill algorithm which reveals tiles and reveals specific neighboring spaces 
     * 
     * Colors for font on board: (Proximity numbers)
     * 1 - (32, 119, 207)
     * 2 - (61, 142, 64)
     * 3 - (209, 45, 53)
     * 4 - (124, 36, 160)
     * 5 - (253, 141, 34)
     * 6 - (22, 152, 166)
     * 7 - (66, 66, 66)
     * 8 - (160, 159, 158)
     * 
     * @param row - starting point y value
     * @param col - starting point x value
     */
    public void flood(int row, int col) {
        
        if (isValidSpace(row, col)) { //space if valid
            if (boardValues[row][col] == COVERED_TILE) { //space if covered
                boardValues[row][col] = UNCOVERED_TILE; //uncover the space
                spacesLeft--; //reduce the amount of spaces left to win
                
                //Calls method again with the values of each neighboring space
                flood(row, col-1);
                flood(row, col+1);
                flood(row+1, col);
                flood(row-1, col);
                flood(row+1, col-1);
                flood(row-1, col-1);
                flood(row+1, col+1);
                flood(row-1, col+1);
            } else if (boardValues[row][col] == COVERED_NEIGHBOR_TILE) { //if tile is covered and neighboring to a mine
                boardValues[row][col] = UNCOVERED_NEIGHBOR_TILE; //set tile as neighboring and uncovered
                spacesLeft--; //reduce the amount of spaces left to win
                if (proximityValues[row][col] != 0) { //if number of neighboring mines isnt 0
                    boardReal[row][col].setText(proximityValues[row][col]+""); //put the number on the board
                }
                switch (proximityValues[row][col]) { //Checks how many mines are near and changes the font colour
                    case 1 -> boardReal[row][col].setForeground(new Color(32, 119, 207));
                    case 2 -> boardReal[row][col].setForeground(new Color(61, 142, 64));
                    case 3 -> boardReal[row][col].setForeground(new Color(209, 45, 53));
                    case 4 -> boardReal[row][col].setForeground(new Color(124, 36, 160));
                    case 5 -> boardReal[row][col].setForeground(new Color(253, 141, 34));
                    case 6 -> boardReal[row][col].setForeground(new Color(22, 152, 166));
                    case 7 -> boardReal[row][col].setForeground(new Color(66, 66, 66));
                    case 8 -> boardReal[row][col].setForeground(new Color(160, 159, 158));
                }  
                
            }
            setBackColor(row,col); //set the backround colour of the space based on its value
            winCheck(); //check if the game is won.
            
        } 
        
    }
    
    /**
     * Checks if game has been won 
     */
    public void winCheck() { 
        if (spacesLeft == 0) { //if there are no spaces empty spaces left on the board
            playing = false; //Game is no longer playing now
            //Update status that the board has been completed
            lblStatus.setForeground(new Color(54, 137, 245));
            lblStatus.setText("Completed!");
        }
    }
    
    /**
     * Changes colour of tile appropriately. Makes checkerboard pattern 
     * 
     * @param row - Row of tile 
     * @param col - Column of tile 
     */
    public void setBackColor(int row, int col) {
        
        if (row%2 == 0  && col%2 == 0 || row%2 == 1  && col%2 == 1) { //Basically checks where tile is on the board to create a checkerboard pattern
            
            if (boardValues[row][col] == UNCOVERED_TILE || boardValues[row][col] == UNCOVERED_NEIGHBOR_TILE) { //if tile is uncovered
                boardReal[row][col].setBackground(new Color(229,194,159)); //Shade of brown
            } else { //if tile is covered or mine
                boardReal[row][col].setBackground(new Color(170,215,81)); //Shade of green
            }
            
        } else {
            if (boardValues[row][col] == UNCOVERED_TILE || boardValues[row][col] == UNCOVERED_NEIGHBOR_TILE) { //if tile is uncovered
                boardReal[row][col].setBackground(new Color(215,184,153)); //Shade of brown
            } else { //if tile is covered or mine
                boardReal[row][col].setBackground(new Color(162,209,73)); //Shade of green
            }
        }
        
    }
    
    /**
     * Places a flag on tile clicked or removes tile.
     * 
     * @param row
     * @param col 
     */
    public void flag(int row, int col) {
        //If tile is covered or mine. Dont want flags on uncoverd tiles.
        if (boardValues[row][col] == MINE_TILE || boardValues[row][col] == COVERED_TILE || boardValues[row][col] == COVERED_NEIGHBOR_TILE) {
            if (flagTiles[row][col] == false) { //if there isnt already flag
                flags--; //reduce # of flags
                boardReal[row][col].setIcon(flagIcon); //Put flag on tile
                flagTiles[row][col] = true; //Tile is set as flaged
                lblFlagCount.setText(flags+""); //Update count on screen
            } else { //if is a flag already
                flags++; //increase # of flags
                flagTiles[row][col] = false; //Tile is set as unflaged
                boardReal[row][col].setIcon(null); //remove flag
                lblFlagCount.setText(flags+""); //Update count on screen
            }
        }
    }
    
    /**
     * Cheat made to reveal mines on the board (make them grey)
     */
    public void revealMines() {
        for (int i = 0; i < boardReal.length; i++) {
            for (int j = 0; j < boardReal[i].length; j++) {
                if (boardValues[i][j] == MINE_TILE) {
                    boardReal[i][j].setBackground(new Color(176, 176, 176));
                } 
            }
        }
    }
    
    /**
     * Tests for game over/reveals spaces
     * 
     * @param row - Row of click on the board
     * @param col - Column of click on the board
     */
    public void leftClick(int row, int col) {
        
        if (firstClick == true) { //if the user hasnt clicked yet. starts game
            playing = true; //unlock the game
            placeMines(row, col); //places mines
            firstClick = false; //Game start wont happen again
        }
        if (flagTiles[row][col] == false && playing) { //if tile isnt flaged
            if (!isMine(row, col)) { //if tile isnt a mine
                flood(row, col); //reveal tile/check for floodable tiles
            } else { //Tile is a mine. Game Over
                playing = false; //Game is no longer playing
                revealMines(); //Show all mines on the board.
                //Update status that the game is over
                lblStatus.setForeground(new Color(255, 0, 0));
                lblStatus.setText("Game Over!");
            }
        }

    }
    
    /**
     * Flags tiles
     * 
     * @param row - Row of click on the board
     * @param col - Column of click on the board
     */
    public void rightClick(int row, int col) {
        if (playing) { //if game is playing
            flag(row, col); //Run flag method
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn00 = new javax.swing.JButton();
        btn01 = new javax.swing.JButton();
        btn02 = new javax.swing.JButton();
        btn03 = new javax.swing.JButton();
        btn04 = new javax.swing.JButton();
        btn05 = new javax.swing.JButton();
        btn06 = new javax.swing.JButton();
        btn07 = new javax.swing.JButton();
        btn08 = new javax.swing.JButton();
        btn09 = new javax.swing.JButton();
        gameCheat = new javax.swing.JButton();
        btnRestart = new javax.swing.JButton();
        btn18 = new javax.swing.JButton();
        btn19 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn11 = new javax.swing.JButton();
        btn12 = new javax.swing.JButton();
        btn13 = new javax.swing.JButton();
        btn14 = new javax.swing.JButton();
        btn15 = new javax.swing.JButton();
        btn16 = new javax.swing.JButton();
        btn17 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn21 = new javax.swing.JButton();
        btn22 = new javax.swing.JButton();
        btn23 = new javax.swing.JButton();
        btn24 = new javax.swing.JButton();
        btn25 = new javax.swing.JButton();
        btn26 = new javax.swing.JButton();
        btn27 = new javax.swing.JButton();
        btn28 = new javax.swing.JButton();
        btn29 = new javax.swing.JButton();
        btn30 = new javax.swing.JButton();
        btn31 = new javax.swing.JButton();
        btn32 = new javax.swing.JButton();
        btn33 = new javax.swing.JButton();
        btn34 = new javax.swing.JButton();
        btn35 = new javax.swing.JButton();
        btn36 = new javax.swing.JButton();
        btn37 = new javax.swing.JButton();
        btn38 = new javax.swing.JButton();
        btn39 = new javax.swing.JButton();
        btn40 = new javax.swing.JButton();
        btn41 = new javax.swing.JButton();
        btn42 = new javax.swing.JButton();
        btn43 = new javax.swing.JButton();
        btn44 = new javax.swing.JButton();
        btn45 = new javax.swing.JButton();
        btn46 = new javax.swing.JButton();
        btn47 = new javax.swing.JButton();
        btn48 = new javax.swing.JButton();
        btn49 = new javax.swing.JButton();
        btn50 = new javax.swing.JButton();
        btn51 = new javax.swing.JButton();
        btn52 = new javax.swing.JButton();
        btn53 = new javax.swing.JButton();
        btn54 = new javax.swing.JButton();
        btn55 = new javax.swing.JButton();
        btn56 = new javax.swing.JButton();
        btn57 = new javax.swing.JButton();
        btn58 = new javax.swing.JButton();
        btn59 = new javax.swing.JButton();
        btn60 = new javax.swing.JButton();
        btn61 = new javax.swing.JButton();
        btn62 = new javax.swing.JButton();
        btn63 = new javax.swing.JButton();
        btn64 = new javax.swing.JButton();
        btn65 = new javax.swing.JButton();
        btn66 = new javax.swing.JButton();
        btn67 = new javax.swing.JButton();
        btn68 = new javax.swing.JButton();
        btn69 = new javax.swing.JButton();
        btn70 = new javax.swing.JButton();
        btn71 = new javax.swing.JButton();
        btn72 = new javax.swing.JButton();
        btn73 = new javax.swing.JButton();
        btn74 = new javax.swing.JButton();
        btn75 = new javax.swing.JButton();
        btn76 = new javax.swing.JButton();
        btn77 = new javax.swing.JButton();
        btn78 = new javax.swing.JButton();
        btn79 = new javax.swing.JButton();
        lblFlagCount = new javax.swing.JLabel();
        lblFlags = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MineSweeper");
        setBackground(new java.awt.Color(74, 117, 44));

        btn00.setBackground(new java.awt.Color(170, 215, 81));
        btn00.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn00.setBorder(null);
        btn00.setPreferredSize(new java.awt.Dimension(50, 50));
        btn00.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn00MousePressed(evt);
            }
        });

        btn01.setBackground(new java.awt.Color(162, 209, 73));
        btn01.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn01.setBorder(null);
        btn01.setPreferredSize(new java.awt.Dimension(50, 50));
        btn01.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn01MousePressed(evt);
            }
        });

        btn02.setBackground(new java.awt.Color(170, 215, 81));
        btn02.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn02.setBorder(null);
        btn02.setPreferredSize(new java.awt.Dimension(50, 50));
        btn02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn02MousePressed(evt);
            }
        });

        btn03.setBackground(new java.awt.Color(162, 209, 73));
        btn03.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn03.setBorder(null);
        btn03.setPreferredSize(new java.awt.Dimension(50, 50));
        btn03.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn03MousePressed(evt);
            }
        });

        btn04.setBackground(new java.awt.Color(170, 215, 81));
        btn04.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn04.setBorder(null);
        btn04.setPreferredSize(new java.awt.Dimension(50, 50));
        btn04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn04MousePressed(evt);
            }
        });

        btn05.setBackground(new java.awt.Color(162, 209, 73));
        btn05.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn05.setBorder(null);
        btn05.setPreferredSize(new java.awt.Dimension(50, 50));
        btn05.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn05MousePressed(evt);
            }
        });

        btn06.setBackground(new java.awt.Color(170, 215, 81));
        btn06.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn06.setBorder(null);
        btn06.setPreferredSize(new java.awt.Dimension(50, 50));
        btn06.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn06MousePressed(evt);
            }
        });

        btn07.setBackground(new java.awt.Color(162, 209, 73));
        btn07.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn07.setBorder(null);
        btn07.setPreferredSize(new java.awt.Dimension(50, 50));
        btn07.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn07MousePressed(evt);
            }
        });

        btn08.setBackground(new java.awt.Color(170, 215, 81));
        btn08.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn08.setBorder(null);
        btn08.setPreferredSize(new java.awt.Dimension(50, 50));
        btn08.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn08MousePressed(evt);
            }
        });

        btn09.setBackground(new java.awt.Color(162, 209, 73));
        btn09.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn09.setBorder(null);
        btn09.setPreferredSize(new java.awt.Dimension(50, 50));
        btn09.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn09MousePressed(evt);
            }
        });

        gameCheat.setBackground(new java.awt.Color(255, 255, 255));
        gameCheat.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        gameCheat.setText("Reveal");
        gameCheat.setBorder(null);
        gameCheat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameCheatActionPerformed(evt);
            }
        });

        btnRestart.setBackground(new java.awt.Color(255, 255, 255));
        btnRestart.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        btnRestart.setText("Try Again");
        btnRestart.setBorder(null);
        btnRestart.setPreferredSize(new java.awt.Dimension(145, 50));
        btnRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestartActionPerformed(evt);
            }
        });

        btn18.setBackground(new java.awt.Color(162, 209, 73));
        btn18.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn18.setBorder(null);
        btn18.setPreferredSize(new java.awt.Dimension(50, 50));
        btn18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn18MousePressed(evt);
            }
        });

        btn19.setBackground(new java.awt.Color(170, 215, 81));
        btn19.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn19.setBorder(null);
        btn19.setPreferredSize(new java.awt.Dimension(50, 50));
        btn19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn19MousePressed(evt);
            }
        });

        btn10.setBackground(new java.awt.Color(162, 209, 73));
        btn10.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn10.setBorder(null);
        btn10.setPreferredSize(new java.awt.Dimension(50, 50));
        btn10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn10MousePressed(evt);
            }
        });

        btn11.setBackground(new java.awt.Color(170, 215, 81));
        btn11.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn11.setBorder(null);
        btn11.setPreferredSize(new java.awt.Dimension(50, 50));
        btn11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn11MousePressed(evt);
            }
        });

        btn12.setBackground(new java.awt.Color(162, 209, 73));
        btn12.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn12.setBorder(null);
        btn12.setPreferredSize(new java.awt.Dimension(50, 50));
        btn12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn12MousePressed(evt);
            }
        });

        btn13.setBackground(new java.awt.Color(170, 215, 81));
        btn13.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn13.setBorder(null);
        btn13.setPreferredSize(new java.awt.Dimension(50, 50));
        btn13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn13MousePressed(evt);
            }
        });

        btn14.setBackground(new java.awt.Color(162, 209, 73));
        btn14.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn14.setBorder(null);
        btn14.setPreferredSize(new java.awt.Dimension(50, 50));
        btn14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn14MousePressed(evt);
            }
        });

        btn15.setBackground(new java.awt.Color(170, 215, 81));
        btn15.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn15.setBorder(null);
        btn15.setPreferredSize(new java.awt.Dimension(50, 50));
        btn15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn15MousePressed(evt);
            }
        });

        btn16.setBackground(new java.awt.Color(162, 209, 73));
        btn16.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn16.setBorder(null);
        btn16.setPreferredSize(new java.awt.Dimension(50, 50));
        btn16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn16MousePressed(evt);
            }
        });

        btn17.setBackground(new java.awt.Color(170, 215, 81));
        btn17.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn17.setBorder(null);
        btn17.setPreferredSize(new java.awt.Dimension(50, 50));
        btn17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn17MousePressed(evt);
            }
        });

        btn20.setBackground(new java.awt.Color(170, 215, 81));
        btn20.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn20.setBorder(null);
        btn20.setPreferredSize(new java.awt.Dimension(50, 50));
        btn20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn20MousePressed(evt);
            }
        });

        btn21.setBackground(new java.awt.Color(162, 209, 73));
        btn21.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn21.setBorder(null);
        btn21.setPreferredSize(new java.awt.Dimension(50, 50));
        btn21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn21MousePressed(evt);
            }
        });

        btn22.setBackground(new java.awt.Color(170, 215, 81));
        btn22.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn22.setBorder(null);
        btn22.setPreferredSize(new java.awt.Dimension(50, 50));
        btn22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn22MousePressed(evt);
            }
        });

        btn23.setBackground(new java.awt.Color(162, 209, 73));
        btn23.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn23.setBorder(null);
        btn23.setPreferredSize(new java.awt.Dimension(50, 50));
        btn23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn23MousePressed(evt);
            }
        });

        btn24.setBackground(new java.awt.Color(170, 215, 81));
        btn24.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn24.setBorder(null);
        btn24.setPreferredSize(new java.awt.Dimension(50, 50));
        btn24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn24MousePressed(evt);
            }
        });

        btn25.setBackground(new java.awt.Color(162, 209, 73));
        btn25.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn25.setBorder(null);
        btn25.setPreferredSize(new java.awt.Dimension(50, 50));
        btn25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn25MousePressed(evt);
            }
        });

        btn26.setBackground(new java.awt.Color(170, 215, 81));
        btn26.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn26.setBorder(null);
        btn26.setPreferredSize(new java.awt.Dimension(50, 50));
        btn26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn26MousePressed(evt);
            }
        });

        btn27.setBackground(new java.awt.Color(162, 209, 73));
        btn27.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn27.setBorder(null);
        btn27.setPreferredSize(new java.awt.Dimension(50, 50));
        btn27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn27MousePressed(evt);
            }
        });

        btn28.setBackground(new java.awt.Color(170, 215, 81));
        btn28.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn28.setBorder(null);
        btn28.setPreferredSize(new java.awt.Dimension(50, 50));
        btn28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn28MousePressed(evt);
            }
        });

        btn29.setBackground(new java.awt.Color(162, 209, 73));
        btn29.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn29.setBorder(null);
        btn29.setPreferredSize(new java.awt.Dimension(50, 50));
        btn29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn29MousePressed(evt);
            }
        });

        btn30.setBackground(new java.awt.Color(162, 209, 73));
        btn30.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn30.setBorder(null);
        btn30.setPreferredSize(new java.awt.Dimension(50, 50));
        btn30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn30MousePressed(evt);
            }
        });

        btn31.setBackground(new java.awt.Color(170, 215, 81));
        btn31.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn31.setBorder(null);
        btn31.setPreferredSize(new java.awt.Dimension(50, 50));
        btn31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn31MousePressed(evt);
            }
        });

        btn32.setBackground(new java.awt.Color(162, 209, 73));
        btn32.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn32.setBorder(null);
        btn32.setPreferredSize(new java.awt.Dimension(50, 50));
        btn32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn32MousePressed(evt);
            }
        });

        btn33.setBackground(new java.awt.Color(170, 215, 81));
        btn33.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn33.setBorder(null);
        btn33.setPreferredSize(new java.awt.Dimension(50, 50));
        btn33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn33MousePressed(evt);
            }
        });

        btn34.setBackground(new java.awt.Color(162, 209, 73));
        btn34.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn34.setBorder(null);
        btn34.setPreferredSize(new java.awt.Dimension(50, 50));
        btn34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn34MousePressed(evt);
            }
        });

        btn35.setBackground(new java.awt.Color(170, 215, 81));
        btn35.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn35.setBorder(null);
        btn35.setPreferredSize(new java.awt.Dimension(50, 50));
        btn35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn35MousePressed(evt);
            }
        });

        btn36.setBackground(new java.awt.Color(162, 209, 73));
        btn36.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn36.setBorder(null);
        btn36.setPreferredSize(new java.awt.Dimension(50, 50));
        btn36.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn36MousePressed(evt);
            }
        });

        btn37.setBackground(new java.awt.Color(170, 215, 81));
        btn37.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn37.setBorder(null);
        btn37.setPreferredSize(new java.awt.Dimension(50, 50));
        btn37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn37MousePressed(evt);
            }
        });

        btn38.setBackground(new java.awt.Color(162, 209, 73));
        btn38.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn38.setBorder(null);
        btn38.setPreferredSize(new java.awt.Dimension(50, 50));
        btn38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn38MousePressed(evt);
            }
        });

        btn39.setBackground(new java.awt.Color(170, 215, 81));
        btn39.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn39.setBorder(null);
        btn39.setPreferredSize(new java.awt.Dimension(50, 50));
        btn39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn39MousePressed(evt);
            }
        });

        btn40.setBackground(new java.awt.Color(170, 215, 81));
        btn40.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn40.setBorder(null);
        btn40.setPreferredSize(new java.awt.Dimension(50, 50));
        btn40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn40MousePressed(evt);
            }
        });

        btn41.setBackground(new java.awt.Color(162, 209, 73));
        btn41.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn41.setBorder(null);
        btn41.setPreferredSize(new java.awt.Dimension(50, 50));
        btn41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn41MousePressed(evt);
            }
        });

        btn42.setBackground(new java.awt.Color(170, 215, 81));
        btn42.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn42.setBorder(null);
        btn42.setPreferredSize(new java.awt.Dimension(50, 50));
        btn42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn42MousePressed(evt);
            }
        });

        btn43.setBackground(new java.awt.Color(162, 209, 73));
        btn43.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn43.setBorder(null);
        btn43.setPreferredSize(new java.awt.Dimension(50, 50));
        btn43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn43MousePressed(evt);
            }
        });

        btn44.setBackground(new java.awt.Color(170, 215, 81));
        btn44.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn44.setBorder(null);
        btn44.setPreferredSize(new java.awt.Dimension(50, 50));
        btn44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn44MousePressed(evt);
            }
        });

        btn45.setBackground(new java.awt.Color(162, 209, 73));
        btn45.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn45.setBorder(null);
        btn45.setPreferredSize(new java.awt.Dimension(50, 50));
        btn45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn45MousePressed(evt);
            }
        });

        btn46.setBackground(new java.awt.Color(170, 215, 81));
        btn46.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn46.setBorder(null);
        btn46.setPreferredSize(new java.awt.Dimension(50, 50));
        btn46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn46MousePressed(evt);
            }
        });

        btn47.setBackground(new java.awt.Color(162, 209, 73));
        btn47.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn47.setBorder(null);
        btn47.setPreferredSize(new java.awt.Dimension(50, 50));
        btn47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn47MousePressed(evt);
            }
        });

        btn48.setBackground(new java.awt.Color(170, 215, 81));
        btn48.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn48.setBorder(null);
        btn48.setPreferredSize(new java.awt.Dimension(50, 50));
        btn48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn48MousePressed(evt);
            }
        });

        btn49.setBackground(new java.awt.Color(162, 209, 73));
        btn49.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn49.setBorder(null);
        btn49.setPreferredSize(new java.awt.Dimension(50, 50));
        btn49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn49MousePressed(evt);
            }
        });

        btn50.setBackground(new java.awt.Color(162, 209, 73));
        btn50.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn50.setBorder(null);
        btn50.setPreferredSize(new java.awt.Dimension(50, 50));
        btn50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn50MousePressed(evt);
            }
        });

        btn51.setBackground(new java.awt.Color(170, 215, 81));
        btn51.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn51.setBorder(null);
        btn51.setPreferredSize(new java.awt.Dimension(50, 50));
        btn51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn51MousePressed(evt);
            }
        });

        btn52.setBackground(new java.awt.Color(162, 209, 73));
        btn52.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn52.setBorder(null);
        btn52.setPreferredSize(new java.awt.Dimension(50, 50));
        btn52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn52MousePressed(evt);
            }
        });

        btn53.setBackground(new java.awt.Color(170, 215, 81));
        btn53.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn53.setBorder(null);
        btn53.setPreferredSize(new java.awt.Dimension(50, 50));
        btn53.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn53MousePressed(evt);
            }
        });

        btn54.setBackground(new java.awt.Color(162, 209, 73));
        btn54.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn54.setBorder(null);
        btn54.setPreferredSize(new java.awt.Dimension(50, 50));
        btn54.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn54MousePressed(evt);
            }
        });

        btn55.setBackground(new java.awt.Color(170, 215, 81));
        btn55.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn55.setBorder(null);
        btn55.setPreferredSize(new java.awt.Dimension(50, 50));
        btn55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn55MousePressed(evt);
            }
        });

        btn56.setBackground(new java.awt.Color(162, 209, 73));
        btn56.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn56.setBorder(null);
        btn56.setPreferredSize(new java.awt.Dimension(50, 50));
        btn56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn56MousePressed(evt);
            }
        });

        btn57.setBackground(new java.awt.Color(170, 215, 81));
        btn57.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn57.setBorder(null);
        btn57.setPreferredSize(new java.awt.Dimension(50, 50));
        btn57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn57MousePressed(evt);
            }
        });

        btn58.setBackground(new java.awt.Color(162, 209, 73));
        btn58.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn58.setBorder(null);
        btn58.setPreferredSize(new java.awt.Dimension(50, 50));
        btn58.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn58MousePressed(evt);
            }
        });

        btn59.setBackground(new java.awt.Color(170, 215, 81));
        btn59.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn59.setBorder(null);
        btn59.setPreferredSize(new java.awt.Dimension(50, 50));
        btn59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn59MousePressed(evt);
            }
        });

        btn60.setBackground(new java.awt.Color(170, 215, 81));
        btn60.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn60.setBorder(null);
        btn60.setPreferredSize(new java.awt.Dimension(50, 50));
        btn60.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn60MousePressed(evt);
            }
        });

        btn61.setBackground(new java.awt.Color(162, 209, 73));
        btn61.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn61.setBorder(null);
        btn61.setPreferredSize(new java.awt.Dimension(50, 50));
        btn61.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn61MousePressed(evt);
            }
        });

        btn62.setBackground(new java.awt.Color(170, 215, 81));
        btn62.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn62.setBorder(null);
        btn62.setPreferredSize(new java.awt.Dimension(50, 50));
        btn62.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn62MousePressed(evt);
            }
        });

        btn63.setBackground(new java.awt.Color(162, 209, 73));
        btn63.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn63.setBorder(null);
        btn63.setPreferredSize(new java.awt.Dimension(50, 50));
        btn63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn63MousePressed(evt);
            }
        });

        btn64.setBackground(new java.awt.Color(170, 215, 81));
        btn64.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn64.setBorder(null);
        btn64.setPreferredSize(new java.awt.Dimension(50, 50));
        btn64.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn64MousePressed(evt);
            }
        });

        btn65.setBackground(new java.awt.Color(162, 209, 73));
        btn65.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn65.setBorder(null);
        btn65.setPreferredSize(new java.awt.Dimension(50, 50));
        btn65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn65MousePressed(evt);
            }
        });

        btn66.setBackground(new java.awt.Color(170, 215, 81));
        btn66.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn66.setBorder(null);
        btn66.setPreferredSize(new java.awt.Dimension(50, 50));
        btn66.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn66MousePressed(evt);
            }
        });

        btn67.setBackground(new java.awt.Color(162, 209, 73));
        btn67.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn67.setBorder(null);
        btn67.setPreferredSize(new java.awt.Dimension(50, 50));
        btn67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn67MousePressed(evt);
            }
        });

        btn68.setBackground(new java.awt.Color(170, 215, 81));
        btn68.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn68.setBorder(null);
        btn68.setPreferredSize(new java.awt.Dimension(50, 50));
        btn68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn68MousePressed(evt);
            }
        });

        btn69.setBackground(new java.awt.Color(162, 209, 73));
        btn69.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn69.setBorder(null);
        btn69.setPreferredSize(new java.awt.Dimension(50, 50));
        btn69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn69MousePressed(evt);
            }
        });

        btn70.setBackground(new java.awt.Color(162, 209, 73));
        btn70.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn70.setBorder(null);
        btn70.setPreferredSize(new java.awt.Dimension(50, 50));
        btn70.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn70MousePressed(evt);
            }
        });

        btn71.setBackground(new java.awt.Color(170, 215, 81));
        btn71.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn71.setBorder(null);
        btn71.setPreferredSize(new java.awt.Dimension(50, 50));
        btn71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn71MousePressed(evt);
            }
        });

        btn72.setBackground(new java.awt.Color(162, 209, 73));
        btn72.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn72.setBorder(null);
        btn72.setPreferredSize(new java.awt.Dimension(50, 50));
        btn72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn72MousePressed(evt);
            }
        });

        btn73.setBackground(new java.awt.Color(170, 215, 81));
        btn73.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn73.setBorder(null);
        btn73.setPreferredSize(new java.awt.Dimension(50, 50));
        btn73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn73MousePressed(evt);
            }
        });

        btn74.setBackground(new java.awt.Color(162, 209, 73));
        btn74.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn74.setBorder(null);
        btn74.setPreferredSize(new java.awt.Dimension(50, 50));
        btn74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn74MousePressed(evt);
            }
        });

        btn75.setBackground(new java.awt.Color(170, 215, 81));
        btn75.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn75.setBorder(null);
        btn75.setPreferredSize(new java.awt.Dimension(50, 50));
        btn75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn75MousePressed(evt);
            }
        });

        btn76.setBackground(new java.awt.Color(162, 209, 73));
        btn76.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn76.setBorder(null);
        btn76.setPreferredSize(new java.awt.Dimension(50, 50));
        btn76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn76MousePressed(evt);
            }
        });

        btn77.setBackground(new java.awt.Color(170, 215, 81));
        btn77.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn77.setBorder(null);
        btn77.setPreferredSize(new java.awt.Dimension(50, 50));
        btn77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn77MousePressed(evt);
            }
        });

        btn78.setBackground(new java.awt.Color(162, 209, 73));
        btn78.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn78.setBorder(null);
        btn78.setPreferredSize(new java.awt.Dimension(50, 50));
        btn78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn78MousePressed(evt);
            }
        });

        btn79.setBackground(new java.awt.Color(170, 215, 81));
        btn79.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        btn79.setBorder(null);
        btn79.setPreferredSize(new java.awt.Dimension(50, 50));
        btn79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn79MousePressed(evt);
            }
        });

        lblFlagCount.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblFlagCount.setForeground(new java.awt.Color(255, 255, 255));
        lblFlagCount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFlagCount.setText("10");

        lblFlags.setBackground(new java.awt.Color(255, 255, 255));
        lblFlags.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblFlags.setForeground(new java.awt.Color(255, 255, 255));
        lblFlags.setText("Flags:");

        lblStatus.setBackground(new java.awt.Color(255, 255, 255));
        lblStatus.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Playing!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(lblStatus)
                        .addGap(25, 25, 25)
                        .addComponent(lblFlags)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFlagCount)
                        .addGap(50, 50, 50)
                        .addComponent(gameCheat, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRestart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStatus)
                    .addComponent(lblFlags)
                    .addComponent(lblFlagCount, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gameCheat, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn09, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn08, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn07, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn05, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn03, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn00, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn46, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn59, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn58, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn57, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn69, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn68, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn63, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn71, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn70, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn79, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn78, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn77, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn76, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn74, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn73, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn72, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gameCheatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameCheatActionPerformed
        // TODO add your handling code here:
        revealMines();
    }//GEN-LAST:event_gameCheatActionPerformed

    private void btn00MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn00MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) { //if leftclick
            leftClick(0, 0); //Call left click method on coordinates
        } else if (evt.getButton() == 3) {
            rightClick(0, 0); //Call right click method on coordinates
        }
    }//GEN-LAST:event_btn00MousePressed

    private void btn01MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn01MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 1);
        } else if (evt.getButton() == 3) {
            rightClick(0, 1);
        }
    }//GEN-LAST:event_btn01MousePressed

    private void btn02MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn02MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 2);
        } else if (evt.getButton() == 3) {
            rightClick(0, 2);
        }
    }//GEN-LAST:event_btn02MousePressed

    private void btn03MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn03MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 3);
        } else if (evt.getButton() == 3) {
            rightClick(0, 3);
        }
    }//GEN-LAST:event_btn03MousePressed

    private void btn04MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn04MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 4);
        } else if (evt.getButton() == 3) {
            rightClick(0, 4);
        }
    }//GEN-LAST:event_btn04MousePressed

    private void btn05MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn05MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 5);
        } else if (evt.getButton() == 3) {
            rightClick(0, 5);
        }
    }//GEN-LAST:event_btn05MousePressed

    private void btn06MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn06MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 6);
        } else if (evt.getButton() == 3) {
            rightClick(0, 6);
        }
    }//GEN-LAST:event_btn06MousePressed

    private void btn07MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn07MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 7);
        } else if (evt.getButton() == 3) {
            rightClick(0, 7);
        }
    }//GEN-LAST:event_btn07MousePressed

    private void btn08MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn08MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 8);
        } else if (evt.getButton() == 3) {
            rightClick(0, 8);
        }
    }//GEN-LAST:event_btn08MousePressed

    private void btn09MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn09MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(0, 9);
        } else if (evt.getButton() == 3) {
            rightClick(0, 9);
        }
    }//GEN-LAST:event_btn09MousePressed

    private void btn10MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn10MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 0);
        } else if (evt.getButton() == 3) {
            rightClick(1, 0);
        }
    }//GEN-LAST:event_btn10MousePressed

    private void btn11MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn11MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 1);
        } else if (evt.getButton() == 3) {
            rightClick(1, 1);
        }
    }//GEN-LAST:event_btn11MousePressed

    private void btn12MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn12MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 2);
        } else if (evt.getButton() == 3) {
            rightClick(1, 2);
        }
    }//GEN-LAST:event_btn12MousePressed

    private void btn13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn13MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 3);
        } else if (evt.getButton() == 3) {
            rightClick(1, 3);
        }
    }//GEN-LAST:event_btn13MousePressed

    private void btn14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn14MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 4);
        } else if (evt.getButton() == 3) {
            rightClick(1, 4);
        }
    }//GEN-LAST:event_btn14MousePressed

    private void btn15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn15MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 5);
        } else if (evt.getButton() == 3) {
            rightClick(1, 5);
        }
    }//GEN-LAST:event_btn15MousePressed

    private void btn16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn16MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 6);
        } else if (evt.getButton() == 3) {
            rightClick(1, 6);
        }
    }//GEN-LAST:event_btn16MousePressed

    private void btn17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn17MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 7);
        } else if (evt.getButton() == 3) {
            rightClick(1, 7);
        }
    }//GEN-LAST:event_btn17MousePressed

    private void btn18MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn18MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 8);
        } else if (evt.getButton() == 3) {
            rightClick(1, 8);
        }
    }//GEN-LAST:event_btn18MousePressed

    private void btn19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn19MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(1, 9);
        } else if (evt.getButton() == 3) {
            rightClick(1, 9);
        }
    }//GEN-LAST:event_btn19MousePressed

    private void btn20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn20MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 0);
        } else if (evt.getButton() == 3) {
            rightClick(2, 0);
        }
    }//GEN-LAST:event_btn20MousePressed

    private void btn21MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn21MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 1);
        } else if (evt.getButton() == 3) {
            rightClick(2, 1);
        }
    }//GEN-LAST:event_btn21MousePressed

    private void btn22MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn22MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 2);
        } else if (evt.getButton() == 3) {
            rightClick(2, 2);
        }
    }//GEN-LAST:event_btn22MousePressed

    private void btn23MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn23MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 3);
        } else if (evt.getButton() == 3) {
            rightClick(2, 3);
        }
    }//GEN-LAST:event_btn23MousePressed

    private void btn24MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn24MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 4);
        } else if (evt.getButton() == 3) {
            rightClick(2, 4);
        }
    }//GEN-LAST:event_btn24MousePressed

    private void btn25MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn25MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 5);
        } else if (evt.getButton() == 3) {
            rightClick(2, 5);
        }
    }//GEN-LAST:event_btn25MousePressed

    private void btn26MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn26MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 6);
        } else if (evt.getButton() == 3) {
            rightClick(2, 6);
        }
    }//GEN-LAST:event_btn26MousePressed

    private void btn27MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn27MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 7);
        } else if (evt.getButton() == 3) {
            rightClick(2, 7);
        }
    }//GEN-LAST:event_btn27MousePressed

    private void btn28MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn28MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 8);
        } else if (evt.getButton() == 3) {
            rightClick(2, 8);
        }
    }//GEN-LAST:event_btn28MousePressed

    private void btn29MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn29MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(2, 9);
        } else if (evt.getButton() == 3) {
            rightClick(2, 9);
        }
    }//GEN-LAST:event_btn29MousePressed

    private void btn30MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn30MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 0);
        } else if (evt.getButton() == 3) {
            rightClick(3, 0);
        }
    }//GEN-LAST:event_btn30MousePressed

    private void btn31MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn31MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 1);
        } else if (evt.getButton() == 3) {
            rightClick(3, 1);
        }
    }//GEN-LAST:event_btn31MousePressed

    private void btn32MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn32MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 2);
        } else if (evt.getButton() == 3) {
            rightClick(3, 2);
        }
    }//GEN-LAST:event_btn32MousePressed

    private void btn33MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn33MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 3);
        } else if (evt.getButton() == 3) {
            rightClick(3, 3);
        }
    }//GEN-LAST:event_btn33MousePressed

    private void btn34MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn34MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 4);
        } else if (evt.getButton() == 3) {
            rightClick(3, 4);
        }
    }//GEN-LAST:event_btn34MousePressed

    private void btn35MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn35MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 5);
        } else if (evt.getButton() == 3) {
            rightClick(3, 5);
        }
    }//GEN-LAST:event_btn35MousePressed

    private void btn36MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn36MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 6);
        } else if (evt.getButton() == 3) {
            rightClick(3, 6);
        }
    }//GEN-LAST:event_btn36MousePressed

    private void btn37MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn37MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 7);
        } else if (evt.getButton() == 3) {
            rightClick(3, 7);
        }
    }//GEN-LAST:event_btn37MousePressed

    private void btn38MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn38MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 8);
        } else if (evt.getButton() == 3) {
            rightClick(3, 8);
        }
    }//GEN-LAST:event_btn38MousePressed

    private void btn39MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn39MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(3, 9);
        } else if (evt.getButton() == 3) {
            rightClick(3, 9);
        }
    }//GEN-LAST:event_btn39MousePressed

    private void btn40MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn40MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 0);
        } else if (evt.getButton() == 3) {
            rightClick(4, 0);
        }
    }//GEN-LAST:event_btn40MousePressed

    private void btn41MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn41MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 1);
        } else if (evt.getButton() == 3) {
            rightClick(4, 1);
        }
    }//GEN-LAST:event_btn41MousePressed

    private void btn42MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn42MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 2);
        } else if (evt.getButton() == 3) {
            rightClick(4, 2);
        } 
    }//GEN-LAST:event_btn42MousePressed

    private void btn43MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn43MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 3);
        } else if (evt.getButton() == 3) {
            rightClick(4, 3);
        }
    }//GEN-LAST:event_btn43MousePressed

    private void btn44MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn44MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 4);
        } else if (evt.getButton() == 3) {
            rightClick(4, 4);
        }
    }//GEN-LAST:event_btn44MousePressed

    private void btn45MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn45MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 5);
        } else if (evt.getButton() == 3) {
            rightClick(4, 5);
        }
    }//GEN-LAST:event_btn45MousePressed

    private void btn46MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn46MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 6);
        } else if (evt.getButton() == 3) {
            rightClick(4, 6);
        }
    }//GEN-LAST:event_btn46MousePressed

    private void btn47MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn47MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 7);
        } else if (evt.getButton() == 3) {
            rightClick(4, 7);
        }
    }//GEN-LAST:event_btn47MousePressed

    private void btn48MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn48MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 8);
        } else if (evt.getButton() == 3) {
            rightClick(4, 8);
        }
    }//GEN-LAST:event_btn48MousePressed

    private void btn49MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn49MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(4, 9);
        } else if (evt.getButton() == 3) {
            rightClick(4, 9);
        }
    }//GEN-LAST:event_btn49MousePressed

    private void btn50MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn50MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 0);
        } else if (evt.getButton() == 3) {
            rightClick(5, 0);
        }
    }//GEN-LAST:event_btn50MousePressed

    private void btn51MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn51MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 1);
        } else if (evt.getButton() == 3) {
            rightClick(5, 1);
        }
    }//GEN-LAST:event_btn51MousePressed

    private void btn52MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn52MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 2);
        } else if (evt.getButton() == 3) {
            rightClick(5, 2);
        }
    }//GEN-LAST:event_btn52MousePressed

    private void btn53MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn53MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 3);
        } else if (evt.getButton() == 3) {
            rightClick(5, 3);
        }
    }//GEN-LAST:event_btn53MousePressed

    private void btn54MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn54MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 4);
        } else if (evt.getButton() == 3) {
            rightClick(5, 4);
        }
    }//GEN-LAST:event_btn54MousePressed

    private void btn55MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn55MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 5);
        } else if (evt.getButton() == 3) {
            rightClick(5, 5);
        }
    }//GEN-LAST:event_btn55MousePressed

    private void btn56MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn56MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 6);
        } else if (evt.getButton() == 3) {
            rightClick(5, 6);
        }
    }//GEN-LAST:event_btn56MousePressed

    private void btn57MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn57MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 7);
        } else if (evt.getButton() == 3) {
            rightClick(5, 7);
        }
    }//GEN-LAST:event_btn57MousePressed

    private void btn58MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn58MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 8);
        } else if (evt.getButton() == 3) {
            rightClick(5, 8);
        }
    }//GEN-LAST:event_btn58MousePressed

    private void btn59MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn59MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(5, 9);
        } else if (evt.getButton() == 3) {
            rightClick(5, 9);
        }
    }//GEN-LAST:event_btn59MousePressed

    private void btn60MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn60MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 0);
        } else if (evt.getButton() == 3) {
            rightClick(6, 0);
        }
    }//GEN-LAST:event_btn60MousePressed

    private void btn61MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn61MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 1);
        } else if (evt.getButton() == 3) {
            rightClick(6, 1);
        }
    }//GEN-LAST:event_btn61MousePressed

    private void btn62MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn62MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 2);
        } else if (evt.getButton() == 3) {
            rightClick(6, 2);
        }
    }//GEN-LAST:event_btn62MousePressed

    private void btn63MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn63MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 3);
        } else if (evt.getButton() == 3) {
            rightClick(6, 3);
        }
    }//GEN-LAST:event_btn63MousePressed

    private void btn64MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn64MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 4);
        } else if (evt.getButton() == 3) {
            rightClick(6, 4);
        }
    }//GEN-LAST:event_btn64MousePressed

    private void btn65MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn65MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 5);
        } else if (evt.getButton() == 3) {
            rightClick(6, 5);
        }
    }//GEN-LAST:event_btn65MousePressed

    private void btn66MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn66MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 6);
        } else if (evt.getButton() == 3) {
            rightClick(6, 6);
        }
    }//GEN-LAST:event_btn66MousePressed

    private void btn67MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn67MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 7);
        } else if (evt.getButton() == 3) {
            rightClick(6, 7);
        }
    }//GEN-LAST:event_btn67MousePressed

    private void btn68MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn68MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 8);
        } else if (evt.getButton() == 3) {
            rightClick(6, 8);
        }
    }//GEN-LAST:event_btn68MousePressed

    private void btn69MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn69MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(6, 9);
        } else if (evt.getButton() == 3) {
            rightClick(6, 9);
        }
    }//GEN-LAST:event_btn69MousePressed

    private void btn70MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn70MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 0);
        } else if (evt.getButton() == 3) {
            rightClick(7, 0);
        }
    }//GEN-LAST:event_btn70MousePressed

    private void btn71MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn71MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 1);
        } else if (evt.getButton() == 3) {
            rightClick(7, 1);
        }
    }//GEN-LAST:event_btn71MousePressed

    private void btn72MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn72MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 2);
        } else if (evt.getButton() == 3) {
            rightClick(7, 2);
        }
    }//GEN-LAST:event_btn72MousePressed

    private void btn73MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn73MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 3);
        } else if (evt.getButton() == 3) {
            rightClick(7, 3);
        }
    }//GEN-LAST:event_btn73MousePressed

    private void btn74MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn74MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 4);
        } else if (evt.getButton() == 3) {
            rightClick(7, 4);
        }
    }//GEN-LAST:event_btn74MousePressed

    private void btn75MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn75MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 5);
        } else if (evt.getButton() == 3) {
            rightClick(7, 5);
        }
    }//GEN-LAST:event_btn75MousePressed

    private void btn76MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn76MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 6);
        } else if (evt.getButton() == 3) {
            rightClick(7, 6);
        }
    }//GEN-LAST:event_btn76MousePressed

    private void btn77MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn77MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 7);
        } else if (evt.getButton() == 3) {
            rightClick(7, 7);
        }
    }//GEN-LAST:event_btn77MousePressed

    private void btn78MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn78MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 8);
        } else if (evt.getButton() == 3) {
            rightClick(7, 8);
        }
    }//GEN-LAST:event_btn78MousePressed

    private void btn79MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn79MousePressed
        // TODO add your handling code here:
        if (evt.getButton() == 1) {
            leftClick(7, 9);
        } else if (evt.getButton() == 3) {
            rightClick(7, 9);
        }
    }//GEN-LAST:event_btn79MousePressed

	private void btnRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestartActionPerformed
        // TODO add your handling code here:
        initialize(); //restarts board
    }//GEN-LAST:event_btnRestartActionPerformed
                
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MasonMineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MasonMineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MasonMineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MasonMineSweeper.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MasonMineSweeper().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn00;
    private javax.swing.JButton btn01;
    private javax.swing.JButton btn02;
    private javax.swing.JButton btn03;
    private javax.swing.JButton btn04;
    private javax.swing.JButton btn05;
    private javax.swing.JButton btn06;
    private javax.swing.JButton btn07;
    private javax.swing.JButton btn08;
    private javax.swing.JButton btn09;
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn11;
    private javax.swing.JButton btn12;
    private javax.swing.JButton btn13;
    private javax.swing.JButton btn14;
    private javax.swing.JButton btn15;
    private javax.swing.JButton btn16;
    private javax.swing.JButton btn17;
    private javax.swing.JButton btn18;
    private javax.swing.JButton btn19;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn21;
    private javax.swing.JButton btn22;
    private javax.swing.JButton btn23;
    private javax.swing.JButton btn24;
    private javax.swing.JButton btn25;
    private javax.swing.JButton btn26;
    private javax.swing.JButton btn27;
    private javax.swing.JButton btn28;
    private javax.swing.JButton btn29;
    private javax.swing.JButton btn30;
    private javax.swing.JButton btn31;
    private javax.swing.JButton btn32;
    private javax.swing.JButton btn33;
    private javax.swing.JButton btn34;
    private javax.swing.JButton btn35;
    private javax.swing.JButton btn36;
    private javax.swing.JButton btn37;
    private javax.swing.JButton btn38;
    private javax.swing.JButton btn39;
    private javax.swing.JButton btn40;
    private javax.swing.JButton btn41;
    private javax.swing.JButton btn42;
    private javax.swing.JButton btn43;
    private javax.swing.JButton btn44;
    private javax.swing.JButton btn45;
    private javax.swing.JButton btn46;
    private javax.swing.JButton btn47;
    private javax.swing.JButton btn48;
    private javax.swing.JButton btn49;
    private javax.swing.JButton btn50;
    private javax.swing.JButton btn51;
    private javax.swing.JButton btn52;
    private javax.swing.JButton btn53;
    private javax.swing.JButton btn54;
    private javax.swing.JButton btn55;
    private javax.swing.JButton btn56;
    private javax.swing.JButton btn57;
    private javax.swing.JButton btn58;
    private javax.swing.JButton btn59;
    private javax.swing.JButton btn60;
    private javax.swing.JButton btn61;
    private javax.swing.JButton btn62;
    private javax.swing.JButton btn63;
    private javax.swing.JButton btn64;
    private javax.swing.JButton btn65;
    private javax.swing.JButton btn66;
    private javax.swing.JButton btn67;
    private javax.swing.JButton btn68;
    private javax.swing.JButton btn69;
    private javax.swing.JButton btn70;
    private javax.swing.JButton btn71;
    private javax.swing.JButton btn72;
    private javax.swing.JButton btn73;
    private javax.swing.JButton btn74;
    private javax.swing.JButton btn75;
    private javax.swing.JButton btn76;
    private javax.swing.JButton btn77;
    private javax.swing.JButton btn78;
    private javax.swing.JButton btn79;
    private javax.swing.JButton btnRestart;
    private javax.swing.JButton gameCheat;
    private javax.swing.JLabel lblFlagCount;
    private javax.swing.JLabel lblFlags;
    private javax.swing.JLabel lblStatus;
    // End of variables declaration//GEN-END:variables
}
