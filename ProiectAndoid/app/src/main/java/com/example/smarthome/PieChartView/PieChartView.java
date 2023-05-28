package com.example.smarthome.PieChartView;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class PieChartView extends View {
    private Paint paint;
    private RectF rectF;
    private float[] value_degree;
    private int[] COLORS = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.BLACK, Color.GRAY};

    public PieChartView(Context context, float[] values) {
        super(context);
        paint = new Paint();
        rectF = new RectF();
        value_degree = new float[values.length];
        for (int i = 0; i < values.length; i++) {
            value_degree[i] = values[i];
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        int size = (width > height) ? height : width;
        int radius = size / 2;

        int startX = (width / 2) - radius;
        int startY = (height / 2) - radius;

        rectF.set(startX, startY, startX + size, startY + size);

        float total = 0;
        for (float val : value_degree) {
            total += val;
        }

        float temp = 0;
        for (int i = 0; i < value_degree.length; i++) {
            paint.setColor(COLORS[i]);
            canvas.drawArc(rectF, (360 * (temp / total)), (360 * (value_degree[i] / total)), true, paint);
            temp += value_degree[i];
        }
    }
}
