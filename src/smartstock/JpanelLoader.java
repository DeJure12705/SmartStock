package smartstock;

import javax.swing.JPanel;

public class JpanelLoader {
   
    // Method to load a JPanel within another JPanel
    public void jPanelLoader(JPanel Main, JPanel setPanel) {
        // Remove all components from the Main JPanel
        Main.removeAll();
        // Create a GroupLayout for the Main JPanel
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(Main);
        Main.setLayout(layout);
        // Set the horizontal layout to include the setPanel
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
        );
        // Set the vertical layout to include the setPanel
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
        );
        // Request the JVM to perform garbage collection
        System.gc();
    } 
}
