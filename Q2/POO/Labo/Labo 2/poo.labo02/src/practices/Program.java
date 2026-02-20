package practices;

import javax.swing.JFrame;

public class Program {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI();
      }


      private void createAndShowGUI() {
        var mainWindow = new JFrame("Poo.Labo02 - HELSo spell practice session");
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setContentPane(new SwingSpellPracticeView(new SpellPracticeSession()));
        mainWindow.setSize(640, 480);

        mainWindow.setVisible(true);

      }
    });
  }
}
