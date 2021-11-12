import java.awt.*;
import javax.swing.*;

// Дополнительный класс для отрисовки парусов (усложн.)
public class SailsAdd implements InterAdd
{
    private Sails sails;

    @Override
    public void setSails(int num)
    {
        switch (num)
        {
            case 1:
                sails = Sails.One;
                break;
            case 2:
                sails = Sails.Two;
                break;
            case 3:
                sails = Sails.Three;
                break;
        }
    }

    public Sails getSails()
    {
        return this.sails;
    }

    @Override
    public void draw(Graphics2D g2D, Color color, int x, int y)
    {

        switch (sails)
        {
            case One:
                g2D.setColor(Color.BLACK);
                g2D.setStroke(new BasicStroke(1));

                g2D.drawOval(x + 10, y + 10, 20, 20);
                g2D.drawOval(x + 80, y + 10, 20, 20);
                g2D.drawRect(x + 20, y + 10, 70, 20);

                g2D.setColor(new Color(0, 255, 255));
                g2D.fillRect(x + 20, y + 10, 70, 20);
                break;
            case Two:
                g2D.setColor(Color.BLACK);
                g2D.setStroke(new BasicStroke(1));
                g2D.drawOval(x + 10, y + 10, 20, 20);
                g2D.drawOval(x + 80, y + 10, 20, 20);
                g2D.drawRect(x + 20, y + 10, 70, 20);

                g2D.setColor(color);
                g2D.fillOval(x + 80, y + 10, 20, 20);
                g2D.fillOval(x + 10, y + 10, 20, 20);

                g2D.setColor(new Color(0, 191, 255));
                g2D.fillRect(x + 20, y + 10, 70, 20);

                break;
            case Three:
                g2D.setColor(Color.black);
                g2D.setStroke(new BasicStroke(1));
                g2D.drawOval(x + 10, y + 10, 20, 20);
                g2D.drawOval(x + 80, y + 10, 20, 20);

                g2D.setColor(color);
                g2D.setStroke(new BasicStroke(1));
                g2D.fillRect(x + 20, y + 10, 70, 20);
                g2D.fillOval(x + 80, y + 10, 20, 20);
                g2D.fillOval(x + 10, y + 10, 20, 20);

                g2D.setColor(Color.BLACK);
                g2D.setStroke(new BasicStroke(1));
                g2D.drawRect(x + 20, y + 10, 70, 20);
                break;
        }

    }
}
