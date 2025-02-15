/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Austin Donovan (addonovan)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package addonovan.kftc.hardware

import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.hardware.ServoImpl

/**
 * A class which serves to distinguish a regular servo from a
 * continuous (aka 360°) one. A few additions are made, such
 * as the [stop] method and the [StopPosition] property, but
 * it's identical to a regular [Servo] for the most part.
 *
 * @author addonovan
 * @since 6/26/16
 */
@HardwareExtension( Servo::class )
open class ContinuousServo( servo: Servo, name: String ) : ServoImpl( servo.controller, servo.portNumber )
{

    //
    // Vals
    //

    /** The position to use to tell the servo to stop moving. */
    val StopPosition = 0.5;

    //
    // Actions
    //

    /**
     * Sets the position of the servo to [StopPosition] so that
     * the continuous servo stops moving.
     */
    fun stop()
    {
        position = StopPosition;
    }

}