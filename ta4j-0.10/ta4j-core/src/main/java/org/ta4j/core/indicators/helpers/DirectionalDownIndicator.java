/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2017 Marc de Verdelhan & respective authors (see AUTHORS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.ta4j.core.indicators.helpers;

import org.ta4j.core.Decimal;
import org.ta4j.core.Indicator;
import org.ta4j.core.TimeSeries;
import org.ta4j.core.indicators.CachedIndicator;

/**
 * Directional down indicator.
 * <p>
 */
public class DirectionalDownIndicator extends CachedIndicator<Decimal>{

    private final Indicator<Decimal> admdown;
    private final Indicator<Decimal> atr;
    private final int timeFrame;

    public DirectionalDownIndicator(TimeSeries series, int timeFrame) {
        super(series);
        this.admdown = new AverageDirectionalMovementDownIndicator(series, timeFrame);
        this.atr = new AverageTrueRangeIndicator(series, timeFrame);
        this.timeFrame = timeFrame;
    }

    @Override
    protected Decimal calculate(int index) {
        return admdown.getValue(index).dividedBy(atr.getValue(index));
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " timeFrame: "+ timeFrame;
    }
}
