package spriteframework;

import javax.swing.JFrame;

public abstract class MainFrame extends JFrame  {

    // hotspot
    protected abstract AbstractBoard createBoard();
    
    public MainFrame(String t, int w, int h) {
          
        add(createBoard());
		
		setTitle(t);
		setSize(w, h);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
    }


//    public static void main(String[] args) {
//
//        EventQueue.invokeLater(() -> {
//
//            MainFrameExtended ex = new MainFrameExtended();
//        });
//    }
    
}
