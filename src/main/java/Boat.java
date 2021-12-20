import java.awt.*;

public class Boat extends Vehicle
{
    // Ширина отрисовки лодки
    private final int boatWidth = 200;

    // Высота отрисовки лодки
    private final int boatHeight = 40;

    // Максимальная скорость
    public int MaxSpeed;

    // Вес лодки
    public float Weight;

    // Основной цвет лодки
    public Color MainColor;

    // Разделитель
    protected final char separator = ';';

    public void setMainColor(Color mainColor)
    {
        MainColor = mainColor;
    }

    // Конструктор
    public Boat(int maxSpeed, float weight, Color mainColor, int boatWidth, int boatHeight)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
        this._pictureWidth = boatWidth;
        this._pictureHeight = boatHeight;
    }

    // Конструктор
    public Boat(String info)
    {
        String[] strs = info.split(String.valueOf(separator));
        if (strs.length == 3)
        {
            MaxSpeed = Integer.parseInt(strs[0]);
            Weight = Float.parseFloat(strs[1]);
            MainColor = Color.decode(strs[2]);
        }
    }

    // Изменение направления перемещения
    public void moveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            // Вправо
            case Right:
                if (_startPosX + step < _pictureWidth - boatWidth)
                {
                    _startPosX += step;
                }
                break;

            // Влево
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;

            // Вверх
            case Up:
                if (_startPosY - step > 0)
                {
                    _startPosY -= step;
                }
                break;

            // Вниз
            case Down:
                if (_startPosY + step < _pictureHeight - boatHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }

    // Отрисовка лодки
    @Override
    public void drawTransport(Graphics g)
    {
        Graphics2D g2D = (Graphics2D) g;

        // Отрисовка границ лодки
        g2D.setColor(Color.BLACK);
        g2D.drawLine(_startPosX, _startPosY, _startPosX + 100, _startPosY);
        g2D.drawLine(_startPosX + 100, _startPosY, _startPosX + 160, _startPosY + 20);
        g2D.drawLine(_startPosX + 160, _startPosY + 20, _startPosX + 100, _startPosY + 40);
        g2D.drawLine(_startPosX + 100, _startPosY + 40, _startPosX, _startPosY + 40);
        g2D.drawLine(_startPosX, _startPosY + 40, _startPosX, _startPosY);
        g2D.drawLine(_startPosX + 25, _startPosY + 10, _startPosX + 25, _startPosY + 30);
        g2D.drawLine(_startPosX + 90, _startPosY + 10, _startPosX + 90, _startPosY + 30);
        g2D.drawOval(_startPosX + 10, _startPosY + 10, 20, 20);
        g2D.drawOval(_startPosX + 80, _startPosY + 10, 20, 20);
        g2D.drawRect(_startPosX + 15, _startPosY + 10, 70, 20);

        // Заливка границ лодки
        g2D.setColor(Color.BLACK); // Saddle Brown new Color(139, 69, 19)
        int[] ptsX = {
                _startPosX + 100, _startPosX + 160, _startPosX + 100
        };
        int[] ptsY = {
                _startPosY, _startPosY + 20, _startPosY + 40
        };
        g2D.fillPolygon(ptsX, ptsY, 3);
        g2D.fillRect(_startPosX, _startPosY, 100, 40);

        g2D.setColor(MainColor);
        g2D.fillOval(_startPosX + 80, _startPosY + 10, 20, 20);
        g2D.fillOval(_startPosX + 10, _startPosY + 10, 20,
                20);
        g2D.fillRect(_startPosX + 25, _startPosY +
                10, 65, 20);
    }

    public String toHexString(Color color)
    {
        return "#" + Integer.toHexString(color.getRGB()).substring(2);
    }

    @Override
    public String toString()
    {
        return String.valueOf(MaxSpeed) + separator + Weight + separator + toHexString(MainColor);
    }

}