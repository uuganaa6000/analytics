/**
 * The MIT License (MIT)
 *
 * @author tsogoo_uuganbaatar
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
package org.ta4j.core.indicators.volume;

import org.ta4j.core.TimeSeries;

/**
 * Positive Volume Index (PVI) indicator.
 * <p>
 * @see http://www.metastock.com/Customer/Resources/TAAZ/Default.aspx?p=92
 * @see http://www.investopedia.com/terms/p/pvi.asp
 */
public class PVIIndicatorCustom extends PVIIndicator {

    public PVIIndicatorCustom(TimeSeries series) {
        super(series);
    }
    
    public double PVIPercent(int index, int percent){
        if (index == 0) {
            return -1;
        }
        double currentValue = this.getValue(index).toDouble();
        double previousValue = this.getValue(index-1).toDouble();
        double cal_percent = (1 - (previousValue / currentValue)) * 100;
        if(cal_percent >= percent){
        	return cal_percent;
        }
        return -1;
    }
}
