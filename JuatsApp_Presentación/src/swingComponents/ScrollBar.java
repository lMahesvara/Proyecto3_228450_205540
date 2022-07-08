package swingComponents;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBar extends JScrollBar {

    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5,5));
        setBackground(new Color(55,64,69));
        setUnitIncrement(20);
    }
}
