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
package addonovan.kftc

import addonovan.kftc.config.Configurations
import addonovan.kftc.config.Profile
import addonovan.kftc.hardware.getDeviceByType
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.HardwareDevice

/**
 * A lot of extensions for OpMode classes.
 *
 * @author addonovan
 * @since 11/14/2016
 */

//
// Hardware Fetching
//

/**
 * Gets the hardware with the given name. This is delegated to happen at a later
 * time.
 *
 * @param[name]
 *          The name of the hardware device.
 * @return A lazy delegate so that the hardware is initialized on the first try.
 */
inline fun < reified T : HardwareDevice > OpMode.get( name: String ): Lazy< T >
{
    return lazy { hardwareMap.getDeviceByType( T::class.java, name ) as T; };
}

//
// Configuration Fetching
//

/**
 * @return The profile for this OpMode.
 */
private fun OpMode.getProfile(): Profile = Configurations.profileFor( javaClass );

fun OpMode.get( name: String, default: Boolean ): Boolean = getProfile()[ name, default ];
fun OpMode.get( name: String, default: Long ): Long       = getProfile()[ name, default ];
fun OpMode.get( name: String, default: Double ): Double   = getProfile()[ name, default ];
fun OpMode.get( name: String, default: String ): String   = getProfile()[ name, default ];