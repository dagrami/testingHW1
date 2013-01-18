import static org.junit.Assert.*;

import javax.swing.SwingUtilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TTTGraphics2PTest {

	TTTGraphics2P game;
	TTTGraphics2P.Seed[][] board;

	@Before
	public void setUp() throws Exception {
		game = new TTTGraphics2P();
		board = game.getBoard();
	}

	@Test
	public void testInitialFrameVisible() {
		assertTrue(game.isVisible());
	}

	@Test
	public void testHasWonThreeInColumn() {
		board[0][0] = TTTGraphics2P.Seed.CROSS;
		board[0][1] = TTTGraphics2P.Seed.NOUGHT;
		board[0][2] = TTTGraphics2P.Seed.EMPTY;
		board[1][0] = TTTGraphics2P.Seed.CROSS;
		board[1][1] = TTTGraphics2P.Seed.NOUGHT;
		board[1][2] = TTTGraphics2P.Seed.EMPTY;
		board[2][0] = TTTGraphics2P.Seed.CROSS;
		board[2][1] = TTTGraphics2P.Seed.EMPTY;
		board[2][2] = TTTGraphics2P.Seed.EMPTY;
		
		assertTrue(game.hasWon(TTTGraphics2P.Seed.CROSS, 2, 0));
	}
	
	@Test
	public void testHasWonThreeInRow(){
		board[0][0] = TTTGraphics2P.Seed.NOUGHT;
		board[0][1] = TTTGraphics2P.Seed.CROSS;
		board[0][2] = TTTGraphics2P.Seed.CROSS;
		board[1][0] = TTTGraphics2P.Seed.EMPTY;
		board[1][1] = TTTGraphics2P.Seed.EMPTY;
		board[1][2] = TTTGraphics2P.Seed.EMPTY;
		board[2][0] = TTTGraphics2P.Seed.EMPTY;
		board[2][1] = TTTGraphics2P.Seed.EMPTY;
		board[2][2] = TTTGraphics2P.Seed.EMPTY;
		
		assertFalse(game.hasWon(TTTGraphics2P.Seed.CROSS, 0, 2));
	}
	
	@Test
	public void testHasWonReverseDiagonal() {
		board[0][0] = TTTGraphics2P.Seed.EMPTY;
		board[0][1] = TTTGraphics2P.Seed.EMPTY;
		board[0][2] = TTTGraphics2P.Seed.CROSS;
		board[1][0] = TTTGraphics2P.Seed.EMPTY;
		board[1][1] = TTTGraphics2P.Seed.CROSS;
		board[1][2] = TTTGraphics2P.Seed.NOUGHT;
		board[2][0] = TTTGraphics2P.Seed.EMPTY;
		board[2][1] = TTTGraphics2P.Seed.NOUGHT;
		board[2][2] = TTTGraphics2P.Seed.CROSS;
		
		assertTrue(game.hasWon(TTTGraphics2P.Seed.CROSS, 0, 2));
	}

	@After
	public void tearDown() throws Exception {
		game.dispose();
	}

}
